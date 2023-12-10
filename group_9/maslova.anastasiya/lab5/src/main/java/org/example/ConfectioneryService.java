package org.example;

import org.example.bench.Benchmarked;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public interface ConfectioneryService {
    @Benchmarked
    YearMonth theLeastProfitableMonth(List<Order> orderList);

    @Benchmarked
    Map<YearMonth, Order> theHeaviestCakeInEveryMonthOfThisYear(List<Order> orderList);

    @Benchmarked
    Map<YearMonth, List<Order>> ordersByMonth(List<Order> orderList);
}
