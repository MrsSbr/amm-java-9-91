package org.example;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
public class TaxiParkPerformanceTest {

    @State(Scope.Benchmark)
    public static class TaxiParkState {
        List<TaxiDriver> arrayListDrivers;
        List<TaxiDriver> linkedListDrivers;
        Set<TaxiDriver> hashSetDrivers;

        @Setup(Level.Iteration)
        public void setup() {
            arrayListDrivers = new ArrayList<>();
            linkedListDrivers = new LinkedList<>();
            hashSetDrivers = new HashSet<>();

            for (int i = 0; i < 1000000; i++) {
                arrayListDrivers.add(new TaxiDriver("Driver " + i, "Brand", "Model"));
                linkedListDrivers.add(new TaxiDriver("Driver " + i, "Brand", "Model"));
                hashSetDrivers.add(new TaxiDriver("Driver " + i, "Brand", "Model"));
            }
        }
    }

    @Benchmark
    public double arrayListPerformance(TaxiParkState state) {
        return state.arrayListDrivers.stream()
                .mapToDouble(TaxiDriver::getFuelConsumption)
                .sum();
    }

    @Benchmark
    public double linkedListPerformance(TaxiParkState state) {
        return state.linkedListDrivers.stream()
                .mapToDouble(TaxiDriver::getFuelConsumption)
                .sum();
    }

    @Benchmark
    public double hashSetPerformance(TaxiParkState state) {
        return state.hashSetDrivers.stream()
                .mapToDouble(TaxiDriver::getFuelConsumption)
                .sum();
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(TaxiParkPerformanceTest.class.getSimpleName())
                .build();
        new Runner(options).run();
    }
}