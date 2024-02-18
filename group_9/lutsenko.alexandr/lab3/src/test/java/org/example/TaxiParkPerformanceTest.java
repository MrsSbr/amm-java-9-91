package org.example;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TaxiParkPerformanceTest {

    public static class TaxiParkState {
        List<TaxiDriver> arrayListDrivers;
        List<TaxiDriver> linkedListDrivers;
        Set<TaxiDriver> hashSetDrivers;

        public void setup() {
            arrayListDrivers = new ArrayList<>();
            linkedListDrivers = new LinkedList<>();
            hashSetDrivers = new HashSet<>();

            for (int i = 0; i < 1000000; i++) {
                arrayListDrivers.add(new TaxiDriver("Driver " + i));
                linkedListDrivers.add(new TaxiDriver("Driver " + i));
                hashSetDrivers.add(new TaxiDriver("Driver " + i));
            }
        }
    }

    public double arrayListPerformance(TaxiParkState state) {
        return state.arrayListDrivers.stream()
                .mapToDouble(TaxiDriver::getFuelConsumption)
                .sum();
    }

    public double linkedListPerformance(TaxiParkState state) {
        return state.linkedListDrivers.stream()
                .mapToDouble(TaxiDriver::getFuelConsumption)
                .sum();
    }

    public double hashSetPerformance(TaxiParkState state) {
        return state.hashSetDrivers.stream()
                .mapToDouble(TaxiDriver::getFuelConsumption)
                .sum();
    }

    public static void main(String[] args) {
        TaxiParkPerformanceTest taxiParkPerformance = new TaxiParkPerformanceTest();
        TaxiParkState state = new TaxiParkState();
        state.setup();

        long start, end;
        int iterations = 5;

        // ArrayList performance
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            taxiParkPerformance.arrayListPerformance(state);
        }
        end = System.nanoTime();
        System.out.println("ArrayList performance: " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");

        // LinkedList performance
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            taxiParkPerformance.linkedListPerformance(state);
        }
        end = System.nanoTime();
        System.out.println("LinkedList performance: " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");

        // HashSet performance
        start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            taxiParkPerformance.hashSetPerformance(state);
        }
        end = System.nanoTime();
        System.out.println("HashSet performance: " + TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");
    }
}