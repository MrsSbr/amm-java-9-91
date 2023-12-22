package org.example.plants;

import org.example.plants.PlantSaleEntry;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlantShopAnalyzer {

    public static String findMostBloomingMonth(List<PlantSaleEntry> salesData) {
        Map<String, Long> bloomingMonthCounts = salesData.stream()
                .filter(entry -> "Flowering".equals(entry.getType()))
                .collect(Collectors.groupingBy(
                        entry -> entry.getDate().split("-")[1],
                        Collectors.counting()
                ));

        return bloomingMonthCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }
    public static Map<String, List<String>> findPotSizesForPlants(List<PlantSaleEntry> salesData) {
        return salesData.stream()
                .collect(Collectors.groupingBy(
                        PlantSaleEntry::getName,
                        Collectors.mapping(PlantSaleEntry::getPotSize, Collectors.toList())
                ));
    }

    public static String findLeastProfitablePlant(List<PlantSaleEntry> salesData) {
        Map<String, Double> plantProfits = salesData.stream()
                .collect(Collectors.groupingBy(
                        PlantSaleEntry::getName,
                        Collectors.summingDouble(PlantSaleEntry::getPrice)
                ));

        return plantProfits.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }
}
