package org.example;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerformanceTest {
    private static final int NUM_EXPERIMENTS = 2312; // Количество экспериментов для тестирования
    private static final int NUM_TRIALS = 10; // Количество испытаний для каждого метода

    public static void main(String[] args) {
        List<Experiment> experiments = IntStream.range(0, NUM_EXPERIMENTS)
                .mapToObj(i -> ExperimentFactory.createRandomExperiment())
                .collect(Collectors.toList());

        List<Supplier<Collection<Experiment>>> collectionSuppliers = Arrays.asList(
                ArrayList::new, LinkedList::new, Vector::new, HashSet::new
        );

        for (Supplier<Collection<Experiment>> supplier : collectionSuppliers) {
            Collection<Experiment> collection = supplier.get();
            ExperimentRunner runner = new ExperimentRunner(() -> collection, experiments);
            String collectionName = collection.getClass().getSimpleName();

            measureAveragePerformance(runner::calculateAverageAmountForPeak, "calculateAverageAmountForPeak", collectionName);
            measureAveragePerformance(runner::getAlcoholTypesTasted, "getAlcoholTypesTasted", collectionName);
            measureAveragePerformance(runner::getTotalAlcoholConsumed, "getTotalAlcoholConsumed", collectionName);
        }
    }

    private static void measureAveragePerformance(Runnable method, String methodName, String collectionName) {
        long totalDuration = 0;
        for (int i = 0; i < NUM_TRIALS; i++) {
            long startTime = System.nanoTime();
            method.run();
            long endTime = System.nanoTime();
            totalDuration += endTime - startTime;
        }
        long averageDuration = totalDuration / NUM_TRIALS;
        System.out.println(collectionName + " - " + methodName + ": Среднее время - " + averageDuration + " наносекунд");
    }
}
