package main.java;
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
                System.out.println("Invalid data: " + line);
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

    public static void writeToFile(String filePath, List<String> lines) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, lines);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл " + filePath + ": " + e.getMessage());
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

        // Пример использования
        String inputFilePath = "group_9/aksenova.anastasia/lab4/src/resources/input.txt";
        List<String> inputData = readFromFile(inputFilePath);
        FloristRecord floristRecord = processFlowerBouquets(inputData);

        // Задача 1: Найти месяц с наибольшим разнообразием цветов
        String mostDiverseMonth = findMostDiverseMonth(floristRecord);
        System.out.println("Месяц с наибольшим разнообразием цветов: " + mostDiverseMonth);

        // Задача 2: Заработок по каждому типу букетов
        Map<String, Double> earningsByBouquetType = calculateEarningsByBouquetType(floristRecord);
        System.out.println("Заработок по каждому типу букетов: " + earningsByBouquetType);

        // Задача 3: Предпочтения доставки для каждого цветка
        Map<String, String> deliveryPreferences = determineDeliveryPreferenceForEachFlower(floristRecord);
        System.out.println("Предпочтения доставки для каждого цветка: " + deliveryPreferences);
        // Запись результатов в файл
        writeResultsToFile("group_9/aksenova.anastasia/lab4/src/resources/output.txt",  mostDiverseMonth, earningsByBouquetType, deliveryPreferences);
    }

    public static void writeResultsToFile(String filePath, String mostDiverseMonth,
                                          Map<String, Double> earningsByBouquetType,
                                          Map<String, String> deliveryPreferences) {
        try {
            // Создаем список строк для записи в файл
            List<String> lines = List.of(
                    "Месяц с наибольшим разнообразием цветов: " + mostDiverseMonth,
                    "Заработок по каждому типу букетов: " + earningsByBouquetType,
                    "Предпочтения доставки для каждого цветка: " + deliveryPreferences
            );

            // Записываем список строк в файл
            Path path = Paths.get(filePath);
            Files.write(path, lines);

        } catch (IOException e) {
            throw new RuntimeException("Ошибка при записи в файл " + filePath, e);
        }
    }
}