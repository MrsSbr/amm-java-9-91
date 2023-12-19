package org.example;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryServiceTest {

    @Test
    public void testFindCourierWithMostRestaurants() {
        List<Order> orders = Arrays.asList(
                new Order(LocalDate.now(), "Courier1", "Restaurant1", "Dish1", LocalDateTime.now()),
                new Order(LocalDate.now(), "Courier2", "Restaurant2", "Dish2", LocalDateTime.now()),
                new Order(LocalDate.now(), "Courier1", "Restaurant3", "Dish3", LocalDateTime.now())
        );

        assertEquals("Courier1", DeliveryService.findCourierWithMostRestaurants(orders));
    }

    @Test
    public void testFindRestaurantWithMostDishesLastYear() {
        List<Order> orders = Arrays.asList(
                new Order(LocalDate.now().minusMonths(6), "Courier1", "Restaurant1", "Dish1", LocalDateTime.now()),
                new Order(LocalDate.now().minusMonths(9), "Courier2", "Restaurant2", "Dish2", LocalDateTime.now()),
                new Order(LocalDate.now().minusMonths(3), "Courier1", "Restaurant1", "Dish3", LocalDateTime.now())
        );

        assertEquals("Restaurant1", DeliveryService.findRestaurantWithMostDishesLastYear(orders));
    }

    @Test
    public void testFindMonthWithMostDeliveryTime() {
        List<Order> orders = Arrays.asList(
                new Order(LocalDate.now(), "Courier1", "Restaurant1", "Dish1", LocalDateTime.of(2023, 1, 1, 10, 0)),
                new Order(LocalDate.now(), "Courier2", "Restaurant2", "Dish2", LocalDateTime.of(2023, 1, 1, 12, 0)),
                new Order(LocalDate.now(), "Courier1", "Restaurant1", "Dish3", LocalDateTime.of(2023, 1, 1, 15, 0))
        );

        assertEquals(1, DeliveryService.findMonthWithMostDeliveryTime(orders).getValue());
    }
}