package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ExperimentRunnerTest {

    @Test
    void calculateAverageAmountForPeak_withMixedResults_returnsCorrectAverage() {
        List<Experiment> experiments = new ArrayList<>();
        experiments.add(new Experiment(AlcoholType.VODKA, 100, true));
        experiments.add(new Experiment(AlcoholType.WINE, 200, false));
        experiments.add(new Experiment(AlcoholType.BEER, 150, true));

        ExperimentRunner runner = new ExperimentRunner(ArrayList::new, experiments);

        assertEquals(125.0, runner.calculateAverageAmountForPeak(), "Среднее количество алкоголя для успешных экспериментов неверно.");
    }

    @Test
    void getAlcoholTypesTasted_withVariousTypes_returnsAllTypes() {
        List<Experiment> experiments = new ArrayList<>();
        experiments.add(new Experiment(AlcoholType.VODKA, 100, true));
        experiments.add(new Experiment(AlcoholType.WINE, 200, false));
        experiments.add(new Experiment(AlcoholType.BEER, 150, true));

        ExperimentRunner runner = new ExperimentRunner(ArrayList::new, experiments);

        assertTrue(runner.getAlcoholTypesTasted().containsAll(List.of(AlcoholType.VODKA, AlcoholType.WINE, AlcoholType.BEER)),
                "Список продегустированных напитков не содержит все типы.");
    }

    @Test
    void getTotalAlcoholConsumed_withVariousAmounts_returnsTotalAmount() {
        List<Experiment> experiments = new ArrayList<>();
        experiments.add(new Experiment(AlcoholType.VODKA, 100, true));
        experiments.add(new Experiment(AlcoholType.WINE, 200, false));
        experiments.add(new Experiment(AlcoholType.BEER, 150, true));

        ExperimentRunner runner = new ExperimentRunner(ArrayList::new, experiments);

        assertEquals(450.0, runner.getTotalAlcoholConsumed(), "Общий объем выпитого алкоголя неверно рассчитан.");
    }

    @Test
    void calculateAverageAmountForPeak_withNoSuccessfulExperiments_returnsZero() {
        List<Experiment> experiments = new ArrayList<>();
        experiments.add(new Experiment(AlcoholType.WINE, 100, false));
        experiments.add(new Experiment(AlcoholType.BEER, 200, false));

        ExperimentRunner runner = new ExperimentRunner(ArrayList::new, experiments);

        assertEquals(0.0, runner.calculateAverageAmountForPeak(), "Среднее должно быть 0 при отсутствии успешных экспериментов.");
    }

    @Test
    void calculateAverageAmountForPeak_withAllSuccessfulExperiments_returnsCorrectAverage() {
        List<Experiment> experiments = new ArrayList<>();
        experiments.add(new Experiment(AlcoholType.VODKA, 100, true));
        experiments.add(new Experiment(AlcoholType.WHISKEY, 200, true));

        ExperimentRunner runner = new ExperimentRunner(ArrayList::new, experiments);

        assertEquals(150.0, runner.calculateAverageAmountForPeak(), "Среднее количество алкоголя для всех успешных экспериментов неверно.");
    }

    @Test
    void calculateAverageAmountForPeak_withNoExperiments_returnsZero() {
        List<Experiment> experiments = new ArrayList<>();

        ExperimentRunner runner = new ExperimentRunner(ArrayList::new, experiments);

        assertEquals(0.0, runner.calculateAverageAmountForPeak(), "Среднее должно быть 0 при отсутствии экспериментов.");
    }

    @Test
    void getAlcoholTypesTasted_withNoExperiments_returnsEmptySet() {
        List<Experiment> experiments = new ArrayList<>();

        ExperimentRunner runner = new ExperimentRunner(ArrayList::new, experiments);

        assertTrue(runner.getAlcoholTypesTasted().isEmpty(), "Список напитков должен быть пустым при отсутствии экспериментов.");
    }

    @Test
    void getTotalAlcoholConsumed_withNoExperiments_returnsZero() {
        List<Experiment> experiments = new ArrayList<>();

        ExperimentRunner runner = new ExperimentRunner(ArrayList::new, experiments);

        assertEquals(0.0, runner.getTotalAlcoholConsumed(), "Общий объем выпитого должен быть 0 при отсутствии экспериментов.");
    }
}
