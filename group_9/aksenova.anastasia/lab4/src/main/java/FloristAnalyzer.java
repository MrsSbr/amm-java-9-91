package main.java;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class FloristAnalyzer {
    private FloristRecord floristRecord;

    public FloristAnalyzer(FloristRecord floristRecord) {
        this.floristRecord = floristRecord;
    }

    public String findMostDiverseMonth() {
        Map<String, Long> monthCountMap = floristRecord.getRecords().stream()
                .collect(Collectors.groupingBy(bouquet -> bouquet.getDate().split("-")[1], Collectors.counting()));

        String mostDiverseMonth = monthCountMap.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        return mostDiverseMonth;
    }

    public Map<String, Double> calculateEarningsByBouquetType() {
        return floristRecord.getRecords().stream()
                .collect(Collectors.groupingBy(FlowerBouquet::getBouquetType, Collectors.summingDouble(FlowerBouquet::getCost)));
    }

    public Map<String, String> determineDeliveryPreferenceForEachFlower() {
        return floristRecord.getRecords().stream()
                .collect(Collectors.groupingBy(FlowerBouquet::getBouquetType,
                        Collectors.collectingAndThen(Collectors.groupingBy(FlowerBouquet::getDeliveryType, Collectors.counting()),
                                deliveryCountMap -> {
                                    String preferredDeliveryType = deliveryCountMap.entrySet().stream()
                                            .max(Comparator.comparing(Map.Entry::getValue))
                                            .map(Map.Entry::getKey)
                                            .orElse(null);
                                    return preferredDeliveryType == null ? "Unknown" : preferredDeliveryType;
                                })));
    }
}
