package org.example;

import java.nio.file.Path;
import java.time.YearMonth;
import java.util.List;

public class Confectionery {
    private static final Path PATH = Path.of("maslova.anastasiya/lab4/src/main/resources/orders.txt");
    private final ConfectioneryService confectioneryService;

    public Confectionery() {
        List<Order> orderList = MyFileReader.readOrdersFromFile(PATH);
        confectioneryService = new ConfectioneryService(orderList);
    }

    public void printMenu() {
        System.out.println("\n\n1. Найти месяц, в котором кондитерская получила самый низкий доход");
        System.out.println("2. Вывести самый тяжелый торт в каждом месяце этого года");
        System.out.println("3. Вывести список заказов тортов по месяцам");
        System.out.println("0. Выход");
    }

    public void printTheLeastProfitableMonth() {
        YearMonth res = confectioneryService.theLeastProfitableMonth();
        System.out.println("Самый неприбыльный месяц —— " + res.getMonth() + " в " + res.getYear() + " году");
    }

    public void printTheHeaviestCakeInEveryMonthOfThisYear() {
        System.out.println("Самый тяжелый торт для каждого месяца в " + YearMonth.now().getYear() + " году:");
        confectioneryService.theHeaviestCakeInEveryMonthOfThisYear()
                .forEach(
                        (key, value) -> System.out.println("Месяц: " + key.getMonth() + "\n" + value.toString())
                );
    }

    public void printOrdersByMonth() {
        System.out.println("Список заказов по месяцам");
        confectioneryService.ordersByMonth()
                .forEach((key, value) -> {
                    System.out.println("Год: " + key.getYear() + " Месяц: " + key.getMonth());
                    value.forEach(order -> System.out.println(order.toString()));
                });
    }
}
