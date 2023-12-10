import org.example.ConfectioneryService;
import org.example.ConfectioneryServiceImpl;
import org.example.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConfectioneryTest {
    private final ConfectioneryService confectioneryService = new ConfectioneryServiceImpl();
    private List<Order> orderList;

    @BeforeEach
    void setup() {
        orderList = new ArrayList<>();
    }

    @Test
    public void testTheLeastProfitableMonth() {
        // Тест на поиск самого низкого дохода (заказы есть)
        orderList.add(new Order(LocalDate.now(), "cake", 5.0, new BigDecimal(100)));
        orderList.add(new Order(LocalDate.now(), "cake", 5.0, new BigDecimal(300)));
        orderList.add(new Order(LocalDate.now().minusMonths(1), "cake", 5.0, new BigDecimal(500)));


        YearMonth leastProfitableMonth = confectioneryService.theLeastProfitableMonth(orderList);

        assertEquals(YearMonth.now(), leastProfitableMonth);
    }

    @Test
    public void testTheLeastProfitableMonthWithNoOrders() {
        // Тест на поиск самого низкого дохода (заказов нет)

        assertThrows(NoSuchElementException.class, () -> confectioneryService.theLeastProfitableMonth(orderList));
    }

    @Test
    public void testTheHeaviestCakeInEveryMonthOfThisYear() {
        // Тест на поиск самого тяжелого торта в каждом месяце текущего года (заказы есть)

        orderList.add(new Order(LocalDate.now(), "cake", 5.0, new BigDecimal(100)));
        orderList.add(new Order(LocalDate.now(), "cake2", 7.0, new BigDecimal(100)));

        Map<YearMonth, Order> heaviestCakes = confectioneryService.theHeaviestCakeInEveryMonthOfThisYear(orderList);

        assertEquals(Map.of(YearMonth.now(), orderList.get(1)), heaviestCakes);
    }

    @Test
    public void testTheHeaviestCakeInEveryMonthOfThisYearWithNoOrders() {
        // Тест на поиск самого тяжелого торта в каждом месяце текущего года (заказов нет)

        Map<YearMonth, Order> heaviestCakes = confectioneryService.theHeaviestCakeInEveryMonthOfThisYear(orderList);

        assertEquals(Map.of(), heaviestCakes);
    }


    @Test
    public void testOrdersByMonth() {
        // Тест на вывод списка заказов тортов по месяцам (заказы есть)
        orderList.add(new Order(LocalDate.now(), "cake", 5.0, new BigDecimal(100)));
        orderList.add(new Order(LocalDate.now().minusMonths(1), "cake2", 7.0, new BigDecimal(100)));

        Map<YearMonth, List<Order>> ordersByMonth = confectioneryService.ordersByMonth(orderList);

        assertEquals(
                Map.of(
                        YearMonth.now(), List.of(orderList.get(0)),
                        YearMonth.now().minusMonths(1), List.of(orderList.get(1))
                ),
                ordersByMonth
        );
    }

    @Test
    public void testOrdersByMonthWithNoOrders() {
        // Тест на вывод списка заказов тортов по месяцам (заказов нет)
        Map<YearMonth, List<Order>> ordersByMonth = confectioneryService.ordersByMonth(orderList);

        assertEquals(Map.of(), ordersByMonth);
    }
}
