package ru.glebbulavin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        String filePath = "./src/main/java/ru/glebbulavin/sales_data.txt";

        DataParser parser = new DataParser();
        try {
            Collection<SaleRecord> records = parser.parseFile(filePath);

            DataProcessor processor = new DataProcessor(records);

            Map<String, String> maxMarkupDealershipPerCar = processor.findMaxMarkupDealershipPerCar();
            System.out.println("Дилерский центр с максимальной наценкой для каждого автомобиля:");
            maxMarkupDealershipPerCar.forEach((car, dealership) ->
                    System.out.println("Автомобиль: " + car + ", Дилер: " + dealership));

            String dealershipWithMostUniqueConfigurations = processor.findDealershipWithMostUniqueConfigurations();
            System.out.println("Дилерский центр, продавший больше всего различных комплектаций за последние 3 года: "
                    + dealershipWithMostUniqueConfigurations);

            Map<String, BigDecimal> totalEarningsPerDealership = processor.calculateTotalEarningsPerDealership();
            System.out.println("Суммарный заработок для каждого дилерского центра:");
            totalEarningsPerDealership.forEach((dealership, earnings) ->
                    System.out.println("Дилер: " + dealership + ", Заработок: " + earnings));
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
