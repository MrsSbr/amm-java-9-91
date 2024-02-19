package org.example;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryServiceTest {

    @Test
    public void testFindCourierWithMostRestaurants() {
        List<Order> orders = createTestOrders();
        String result = DeliveryService.findCourierWithMostRestaurants(orders);
        assertEquals("Courier1", result);
    }

    @Test
    public void testFindRestaurantWithMostDishesLastYear() {
        List<Order> orders = createTestOrders();
        // Создаем желаемую дату (например, 2023-02-01)
        LocalDate referenceDate = LocalDate.of(2023, 2, 1);
        String result = DeliveryService.findRestaurantWithMostDishesLastYear(orders, referenceDate);
        assertEquals("Restaurant2", result);
    }

    @Test
    public void testFindMonthWithMostDeliveryTime() {
        List<Order> orders = createTestOrders();
        Month result = DeliveryService.findMonthWithMostDeliveryTime(orders);
        assertEquals(Month.JANUARY, result);
    }

    private List<Order> createTestOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(LocalDate.of(2023, 1, 1), "Courier1", "Restaurant1", "Dish1", 10));
        orders.add(new Order(LocalDate.of(2023, 1, 1), "Courier2", "Restaurant2", "Dish2", 12));
        orders.add(new Order(LocalDate.of(2023, 1, 1), "Courier1", "Restaurant2", "Dish3", 15));
        return orders;
    }
}