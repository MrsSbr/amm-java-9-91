package org.example;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;


public class DeliveryService {
    // Найти курьера, который доставлял еду из всех ресторанов
    public static String findCourierWithMostRestaurants(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCourier, Collectors.mapping(Order::getRestaurant, Collectors.toSet())))
                .entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().size()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Найти ресторан, из которого за последний год доставлялось самое большое количество различных блюд
    public static String findRestaurantWithMostDishesLastYear(List<Order> orders) {
        LocalDate oneYearAgo = LocalDate.now().minusYears(1);

        return orders.stream()
                .filter(order -> order.getDate().isAfter(oneYearAgo))
                .collect(Collectors.groupingBy(Order::getRestaurant, Collectors.mapping(Order::getItems, Collectors.toSet())))
                .entrySet().stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().size()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Найти месяц, в который курьеры потратили больше всего времени на доставку
    public static Month findMonthWithMostDeliveryTime(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(order -> order.getDeliveryTime().getMonth(), Collectors.summingLong(order -> order.getDeliveryTime().getHour())))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(LocalDate.now(), "Courier1", "Restaurant1", "Dish1", LocalDateTime.of(2023, 1, 1, 10, 0)),
                new Order(LocalDate.now(), "Courier2", "Restaurant2", "Dish2", LocalDateTime.of(2023, 1, 1, 12, 0)),
                new Order(LocalDate.now(), "Courier1", "Restaurant2", "Dish3", LocalDateTime.of(2023, 1, 1, 15, 0))
        );

        System.out.println("Courier with most restaurants: " + findCourierWithMostRestaurants(orders));
        System.out.println("Restaurant with most dishes last year: " + findRestaurantWithMostDishesLastYear(orders));
        System.out.println("Month with most delivery time: " + findMonthWithMostDeliveryTime(orders));
    }
}