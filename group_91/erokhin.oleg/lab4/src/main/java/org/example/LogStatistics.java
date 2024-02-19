package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LogStatistics {
    private static final Logger logger = LogManager.getLogger(LogStatistics.class);

    public Map<HttpStatusCode, Long> getCodeStatistics(Collection<Log> logs) {
        logger.info("Вызов метода getCodeStatistics");

        return logs.stream()
                .collect(Collectors.groupingBy(Log::getCode, Collectors.counting()));
    }

    public Map<String, Long> getResourceStatistics(Collection<Log> logs) {
        logger.info("Вызов метода getResourceStatistics");

        return logs.stream()
                .collect(Collectors.groupingBy(Log::getResource, Collectors.counting()));
    }

    public String getMostUnstableResource(Collection<Log> logs) {
        logger.info("Вызов метода getMostUnstableResource");

        Map<String, Integer> errorCountByResource = new HashMap<>();
        for (Log log : logs) {
            if (isErrorCode(log.getCode())) {
                errorCountByResource.merge(log.getResource(), 1, Integer::sum);
            }
        }

        return errorCountByResource
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String getResourceWithHighestSuccessRatio(Collection<Log> logs) {
        logger.info("Вызов метода getResourceWithHighestSuccessRatio");

        Map<String, Integer> totalResponsesByResource = new HashMap<>();
        Map<String, Integer> successfulResponsesByResource = new HashMap<>();

        for (Log log : logs) {
            String resource = log.getResource();
            HttpStatusCode code = log.getCode();

            totalResponsesByResource.merge(resource, 1, Integer::sum);

            if (isSuccessCode(code)) {
                successfulResponsesByResource.merge(resource, 1, Integer::sum);
            }
        }

        String resourceWithHighestSuccessRatio = null;
        double highestRatio = 0;

        for (String resource : totalResponsesByResource.keySet()) {
            int totalResponses = totalResponsesByResource.get(resource);
            int successfulResponses = successfulResponsesByResource.getOrDefault(resource, 0);
            double ratio = (double) successfulResponses / totalResponses;

            if (ratio > highestRatio) {
                highestRatio = ratio;
                resourceWithHighestSuccessRatio = resource;
            }
        }

        return resourceWithHighestSuccessRatio;
    }

    private static boolean isErrorCode(HttpStatusCode code) {
        int statusCode = code.getCode();
        return statusCode >= 400 && statusCode <= 599;
    }

    private static boolean isSuccessCode(HttpStatusCode code) {
        int statusCode = code.getCode();
        return statusCode >= 200 && statusCode <= 299;
    }
}
