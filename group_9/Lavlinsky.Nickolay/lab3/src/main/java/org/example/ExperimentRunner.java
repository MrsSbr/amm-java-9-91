package org.example;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.Set;

public class ExperimentRunner {
    private Collection<Experiment> experiments;

    public ExperimentRunner(Supplier<Collection<Experiment>> collectionSupplier, List<Experiment> initialExperiments) {
        this.experiments = collectionSupplier.get();
        this.experiments.addAll(initialExperiments);
    }

    // Среднее количество алкоголя для достижения пика Балмера
    public double calculateAverageAmountForPeak() {
        return experiments.stream()
                .filter(Experiment::isPeakAchieved)
                .mapToDouble(Experiment::getAmount)
                .average()
                .orElse(0);
    }

    // Список продегустированных напитков
    public Set<AlcoholType> getAlcoholTypesTasted() {
        return experiments.stream()
                .map(Experiment::getAlcoholType)
                .collect(Collectors.toSet());
    }

    // Общий объем выпитого алкоголя
    public double getTotalAlcoholConsumed() {
        return experiments.stream()
                .mapToDouble(Experiment::getAmount)
                .sum();
    }
}

