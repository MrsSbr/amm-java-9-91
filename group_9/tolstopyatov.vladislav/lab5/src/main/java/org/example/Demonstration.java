package org.example;

import benchmark.Benchmark;
import service.IService;
import service.Service;
import statistics.MethodStat;
import statistics.Stat;

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
* */

public class Demonstration {
    public static void main(String[] args) {
        IService service = new Service();
        IService trackedService = Benchmark.track(service);

        trackedService.do1();
        trackedService.do2();

        Stat stat = Benchmark.getStatistics(trackedService);
        stat.print(System.out);
    }
}