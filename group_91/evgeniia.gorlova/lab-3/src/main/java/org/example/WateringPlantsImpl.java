package org.example;

public class WateringPlantsImpl implements WateringService {
    @Override
    public int calculateSteps(int[] plants, int capacity) {
        int steps = 0;
        int water = capacity;

        for (int plant : plants) {
            if (plant > water) {
                // Не хватает воды, возвращаемся к реке
                steps += 1;
                water = capacity;
            }

            water -= plant;
            steps += 1;
        }

        return steps;
    }
}
