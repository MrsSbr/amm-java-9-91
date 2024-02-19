package org.example;
import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeliveryService {
    // Найти курьера, который доставлял еду из всех ресторанов
    public static String findCourierWithMostRestaurants(List<Order> orders) {
        Map<String, Long> courierToRestaurantsCount = orders.stream()
                .collect(Collectors.groupingBy(Order::getCourier, Collectors.mapping(Order::getRestaurant, Collectors.toSet())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (long) entry.getValue().size()));

        return courierToRestaurantsCount.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Найти ресторан, из которого за последний год доставлялось самое большое количество различных блюд
    public static String findRestaurantWithMostDishesLastYear(List<Order> orders, LocalDate referenceDate) {
        LocalDate lastYear = referenceDate.minusYears(1);
        Map<String, Long> restaurantToDishesCount = orders.stream()
                .filter(order -> order.getDate().isAfter(lastYear))
                .collect(Collectors.groupingBy(Order::getRestaurant, Collectors.mapping(Order::getItems, Collectors.toSet())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (long) entry.getValue().size()));

        if (restaurantToDishesCount.isEmpty()) {
            return "No orders in the last year";
        }

        return restaurantToDishesCount.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("No data found");
    }

    // Найти месяц, в который курьеры потратили больше всего времени на доставку
    public static Month findMonthWithMostDeliveryTime(List<Order> orders) {
        Map<Month, Integer> monthToDeliveryTime = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getDate().getMonth(),
                        Collectors.summingInt(Order::getDeliveryTime)
                ));

        return monthToDeliveryTime.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static void main(String[] args) {
        String ordersFilePath = "group_9/lutsenko.alexandr/lab_4/src/resources/orders";
        String outputFilePath = "group_9/lutsenko.alexandr/lab_4/src/resources/output";

        List<Order> orders = OrderReader.readOrdersFromFile(ordersFilePath);

        // Получаем текущую дату
        LocalDate currentDate = LocalDate.now();

        // Получаем результаты
        String result = "Courier with most restaurants: " + findCourierWithMostRestaurants(orders) + "\n" +
                "Restaurant with most dishes last year: " + findRestaurantWithMostDishesLastYear(orders, currentDate) + "\n" +
                "Month with most delivery time: " + findMonthWithMostDeliveryTime(orders);

        // Вывод результатов в файл
        ResultWriter.writeResultsToFile(outputFilePath, result);
    }
}