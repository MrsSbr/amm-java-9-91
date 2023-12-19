package org.example;

public class Main {
    public static void main(String[] args) {
        Service service = new ServiceImpl();
        Service trackedService = Benchmark.track(service);

        trackedService.do1();
        trackedService.do2();
        trackedService.do3();
        trackedService.do4();

        Stat stat = Benchmark.getStat(trackedService);
        stat.print(System.out);
    }
}

interface Service {
    @Benchmarked
    void do1();

    @Benchmarked
    void do2();

    @Benchmarked
    void do3();

    @Benchmarked
    void do4();
}

class ServiceImpl implements Service {
    @Override
    public void do1() {
        try {
            Thread.sleep(100); // Задержка для имитации выполнения
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("do1 executed");
    }

    @Override
    public void do2() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("do2 executed");
    }

    @Override
    public void do3() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("do3 executed");
    }

    @Override
    public void do4() {
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("do4 executed");
    }
}
