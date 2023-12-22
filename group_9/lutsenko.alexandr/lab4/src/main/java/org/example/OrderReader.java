package org.example;
import java.util.Collections;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class OrderReader {

    public static List<Order> readOrdersFromFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return Files.lines(path)
                    .map(OrderReader::parseOrder)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error reading orders from file: " + filePath);
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private static Order parseOrder(String line) {
        String[] parts = line.split(";");
        LocalDate date = LocalDate.parse(parts[0]);
        String courier = parts[1];
        String restaurant = parts[2];
        String items = parts[3];
        int deliveryTime = Integer.parseInt(parts[4]); // Парсим строку в целое число

        return new Order(date, courier, restaurant, items, deliveryTime);
    }
}