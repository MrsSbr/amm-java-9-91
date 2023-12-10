import org.example.ConfectioneryService;
import org.example.ConfectioneryServiceImpl;
import org.example.Order;
import org.example.bench.Benchmark;
import org.example.bench.Stat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BenchmarkTest {
    private List<Order> orderList;

    @BeforeEach
    void setup() {
        orderList = new ArrayList<>();
        orderList.add(new Order(LocalDate.now(), "cake", 5.0, new BigDecimal(100)));
        orderList.add(new Order(LocalDate.now(), "cake", 5.0, new BigDecimal(300)));
        orderList.add(new Order(LocalDate.now().minusMonths(1), "cake", 5.0, new BigDecimal(500)));
    }

    @Test
    public void notNullObject() {
        ConfectioneryService tracked = Benchmark.track(new ConfectioneryServiceImpl());
        Stat stat = Benchmark.getStat(tracked);
        assertNotNull(stat);
    }

    @Test
    public void statsContains() {
        ConfectioneryService tracked = Benchmark.track(new ConfectioneryServiceImpl());

        tracked.ordersByMonth(orderList);
        tracked.theLeastProfitableMonth(orderList);
        tracked.theHeaviestCakeInEveryMonthOfThisYear(orderList);

        Stat stat = Benchmark.getStat(tracked);

        assertEquals(3, stat.stats().size());
    }

    @Test
    public void emptyStats() {
        ConfectioneryService tracked = Benchmark.track(new ConfectioneryServiceImpl());
        Stat stat = Benchmark.getStat(tracked);

        assertEquals(0, stat.stats().size());
    }

    @Test
    public void nullObject() {
        assertThrows(IllegalArgumentException.class, () -> {
            ConfectioneryService tracked = Benchmark.track(null);
        });
    }

    @Test
    public void notTrackedService() {
        assertThrows(IllegalArgumentException.class, () -> {
            Stat stat = Benchmark.getStat(new ConfectioneryServiceImpl());
        });
    }
}
