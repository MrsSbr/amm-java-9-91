package org.example;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;

public interface ConfectioneryService {
    public YearMonth theLeastProfitableMonth(List<Order> orderList);

    public Map<YearMonth, Order> theHeaviestCakeInEveryMonthOfThisYear(List<Order> orderList);

    public Map<YearMonth, List<Order>> ordersByMonth(List<Order> orderList);
}


