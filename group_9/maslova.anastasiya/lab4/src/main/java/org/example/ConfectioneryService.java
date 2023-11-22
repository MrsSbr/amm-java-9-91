package org.example;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConfectioneryService {
    private final List<Order> orderList;

    public ConfectioneryService(List<Order> orderList) {
        this.orderList = orderList;
    }

    // найти месяц, в котором кондитерская получила самый низкий доход
    public YearMonth theLeastProfitableMonth() {

        // Создаем Map, в котором ключами будут YearMonth, а значениями - суммарная прибыль за каждый месяц
        Map<YearMonth, BigDecimal> profitForMonth = orderList.stream()
                .collect(Collectors.groupingBy( // группируем по дате начала месяца
                        order -> YearMonth.of(order.getDate().getYear(), order.getDate().getMonth()),
                        Collectors.mapping( // вычисляем суммарную стоимость заказов в месяц
                                Order::getCost,
                                Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                        )
                ));

        // Находим месяц с наименьшей прибылью, используя Stream.min и сравнивая по значению (прибыли)
        return profitForMonth.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Нет данных о прибыли за месяц"))
                .getKey();
    }

    // вывести самый тяжелый торт в каждом месяце этого года
    public Map<YearMonth, Order> theHeaviestCakeInEveryMonthOfThisYear() {
        // Фильтруем заказы для текущего года, оставляем только те, что были сделаны в текущем году
        return orderList.stream()
                .filter(order -> order.getDate().getYear() == YearMonth.now().getYear())
                .collect(
                        Collectors.toMap(
                                order -> YearMonth.of(order.getDate().getYear(), order.getDate().getMonth()), // ключ - YearMonth
                                Function.identity(), // значение - сам заказ (Order)
                                BinaryOperator.maxBy(Comparator.comparingDouble(Order::getWeight))  // находим максимальный заказ по весу
                        )
                );
    }

    // вывести список заказов тортов по месяцам
    public Map<YearMonth, List<Order>> ordersByMonth() {
        // Группируем заказы по YearMonth, чтобы получить списки заказов по месяцам
        return orderList.stream()
                .collect(Collectors.groupingBy(
                        order -> YearMonth.of(order.getDate().getYear(), order.getDate().getMonth())
                ));
    }
}
