package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FloristApp {

    public static FloristRecord processFlowerBouquets(List<String> lines) {
        FloristRecord floristRecord = new FloristRecord();
        for (String line : lines) {
            String[] parts = line.split(";");
            if (parts.length == 5) {
                String date = parts[0];
                String bouquetType = parts[1];
                List<String> bouquetComposition = Arrays.asList(parts[2].split(", "));
                double cost = Double.parseDouble(parts[3]);
                String deliveryType = parts[4];

                FlowerBouquet bouquet = new FlowerBouquet(date, bouquetType, bouquetComposition, cost, deliveryType);
                floristRecord.addRecord(bouquet);
            } else {
                System.out.println("Неверные данные: " + line);
            }
        }
        return floristRecord;
    }

    public static List<String> readFromFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static String findMostDiverseMonth(FloristRecord floristRecord) {
        Map<String, Long> monthCountMap = floristRecord.getRecords().stream()
                .collect(Collectors.groupingBy(bouquet -> bouquet.getDate().split("-")[1], Collectors.counting()));

        Optional<Map.Entry<String, Long>> maxEntry = monthCountMap.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        return maxEntry.map(Map.Entry::getKey).orElse(null);
    }

    public static Map<String, Double> calculateEarningsByBouquetType(FloristRecord floristRecord) {
        return floristRecord.getRecords().stream()
                .collect(Collectors.groupingBy(FlowerBouquet::getBouquetType, Collectors.summingDouble(FlowerBouquet::getCost)));
    }

    public static Map<String, String> determineDeliveryPreferenceForEachFlower(FloristRecord floristRecord) {
        Map<String, Map<String, Long>> flowerDeliveryCountMap = floristRecord.getRecords().stream()
                .flatMap(bouquet -> bouquet.getBouquetComposition().stream().distinct()
                        .map(flower -> new AbstractMap.SimpleEntry<>(flower, bouquet.getDeliveryType())))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.groupingBy(Map.Entry::getValue, Collectors.counting())));

        Map<String, String> deliveryPreferenceMap = new HashMap<>();

        flowerDeliveryCountMap.forEach((flower, deliveryCountMap) -> {
            long deliveryCount = deliveryCountMap.getOrDefault("Доставка", 0L);
            long pickupCount = deliveryCountMap.getOrDefault("Самовывоз", 0L);

            String preference = deliveryCount > pickupCount ? "Доставка" : "Самовывоз";
            deliveryPreferenceMap.put(flower, preference);
        });

        return deliveryPreferenceMap;
    }

    public static void main(String[] args) {

        String inputFilePath = "group_9/aksenova.anastasia/lab 4/src/main/java/resources/input.txt";
        List<String> inputData = readFromFile(inputFilePath);
        FloristRecord floristRecord = processFlowerBouquets(inputData);

        String mostDiverseMonth = findMostDiverseMonth(floristRecord);
        System.out.println("Месяц с наибольшим разнообразием цветов: " + mostDiverseMonth);

        Map<String, Double> earningsByBouquetType = calculateEarningsByBouquetType(floristRecord);
        System.out.println("Заработок по каждому типу букетов: " + earningsByBouquetType);

        Map<String, String> deliveryPreferences = determineDeliveryPreferenceForEachFlower(floristRecord);
        System.out.println("Предпочтения доставки для каждого цветка: " + deliveryPreferences);

        writeResultsToFile("group_9/aksenova.anastasia/lab 4/src/main/java/resources/output.txt",  mostDiverseMonth, earningsByBouquetType, deliveryPreferences);
    }

    public static void writeResultsToFile(String filePath, String mostDiverseMonth,
                                          Map<String, Double> earningsByBouquetType,
                                          Map<String, String> deliveryPreferences) {
        try {
            List<String> lines = List.of(
                    "Месяц с наибольшим разнообразием цветов: " + mostDiverseMonth,
                    "Заработок по каждому типу букетов: " + earningsByBouquetType,
                    "Предпочтения доставки для каждого цветка: " + deliveryPreferences
            );

            Path path = Paths.get(filePath);
            Files.write(path, lines);

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи в файл " + filePath, e);
        }
    }
}