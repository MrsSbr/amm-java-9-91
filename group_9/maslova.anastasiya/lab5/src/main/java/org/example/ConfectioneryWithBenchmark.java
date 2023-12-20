package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.bench.Benchmark;
import org.example.bench.Stat;

import java.nio.file.Path;
import java.util.List;

/*
Создать универсальный прокси, который будет для каждого метода в интерфейсе с аннотацией @Benchmarked
считать время выполнения и записывать его консоль.

Использование должно выглядеть примерно так:

interface Service {...}
class Benchmark {...}
main(...) {
    Service service = ...;
    Service trackedService = Benchmark.track(service);
    trackedService.do1();
    trackedService.do2();
    ...
    Stat stat = Benchmark.getStat(trackedService);
    stat.print(System.out);
}
 */

public class ConfectioneryWithBenchmark {
    private static final Logger logger = LogManager.getLogger(ConfectioneryWithBenchmark.class);
    private static final Path PATH = Path.of("maslova.anastasiya/lab5/src/main/resources/orders.txt");

    public static void main(String[] args) {
        logger.info("Начало работы программы");

        ConfectioneryService confectionery = new ConfectioneryServiceImpl();
        ConfectioneryService trackedConfectionery = Benchmark.track(confectionery);

        MyFileReader myFileReader = new MyFileReader();
        List<Order> orderList = myFileReader.readOrdersFromFile(PATH);

        trackedConfectionery.theLeastProfitableMonth(orderList);
        trackedConfectionery.ordersByMonth(orderList);
        trackedConfectionery.theHeaviestCakeInEveryMonthOfThisYear(orderList);

        Stat stat = Benchmark.getStat(trackedConfectionery);
        stat.print(System.out);

        logger.info("Конец работы программы");
    }
}