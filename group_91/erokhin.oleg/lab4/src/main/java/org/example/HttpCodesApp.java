package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class HttpCodesApp {
    private static final String file = "http-codes.txt";
    private static final Logger logger = LogManager.getLogger(HttpCodesApp.class);

    public static void main(String[] args) {
        logger.info("Начало работы программы");

        LogReader logReader = new LogReader();
        LogStatistics logStatistics = new LogStatistics();

        try {
            List<Log> logs = logReader.read(file);

            logger.info("Статистика по кодам:" + logStatistics.getCodeStatistics(logs));
            logger.info("Статистика по ресурсам:" + logStatistics.getResourceStatistics(logs));
            logger.info("Самый нестабильный ресурс:" + logStatistics.getMostUnstableResource(logs));
            logger.info("Ресурс с самым большим отношением успешных ответов к общему количеству:" +
                    logStatistics.getResourceWithHighestSuccessRatio(logs));
        } catch (Exception ex) {
            logger.error("Перехвачено исключение: " + ex.getMessage());
        }

        logger.info("Конец работы программы");
    }
}