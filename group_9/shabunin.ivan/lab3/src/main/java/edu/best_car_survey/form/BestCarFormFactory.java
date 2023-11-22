package edu.best_car_survey.form;

import java.util.List;
import java.util.Random;

public final class BestCarFormFactory {
    static final List<String> BRANDS = List.of("Audi", "BMW", "Skoda", "Peugeot", "Ford");
    static final int LOWER_AGE = 20;
    static final int UPPER_AGE = 65;
    private static final Random RANDOM = new Random();

    private BestCarFormFactory() {
    }

    public static BestCarForm generate() {
        int age = RANDOM.nextInt(LOWER_AGE, UPPER_AGE);
        String brand = BRANDS.get(RANDOM.nextInt(BRANDS.size()));
        return new BestCarForm(age, brand);
    }
}
