package org.example;

import java.util.Random;

public class ExperimentFactory {
    private static final Random RANDOM = new Random();

    public static Experiment createRandomExperiment() {
        AlcoholType type = AlcoholType.getRandomType();
        double amount = 50 + RANDOM.nextDouble() * 450; // от 50 до 500 мл
        boolean peakAchieved = RANDOM.nextBoolean();
        return new Experiment(type, amount, peakAchieved);
    }
}

