package org.example;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public interface ConfectioneryService {
    YearMonth theLeastProfitableMonth(List<Order> orderList);

    Map<YearMonth, Order> theHeaviestCakeInEveryMonthOfThisYear(List<Order> orderList);

    Map<YearMonth, List<Order>> ordersByMonth(List<Order> orderList);
}


