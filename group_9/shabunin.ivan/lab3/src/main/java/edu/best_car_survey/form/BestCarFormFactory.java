package edu.best_car_survey.form;

import java.util.Random;

public final class BestCarFormFactory {
    static final CarBrand[] BRANDS = CarBrand.values();
    static final int LOWER_AGE = 20;
    static final int UPPER_AGE = 65;
    private static final Random RANDOM = new Random();

    private BestCarFormFactory() {
    }

    public static BestCarForm generate() {
        int age = RANDOM.nextInt(LOWER_AGE, UPPER_AGE);
        CarBrand brand = BRANDS[RANDOM.nextInt(BRANDS.length)];
        return new BestCarForm(age, brand);
    }
}
