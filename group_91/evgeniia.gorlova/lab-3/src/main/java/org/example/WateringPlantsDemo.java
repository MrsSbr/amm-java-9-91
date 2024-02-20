package org.example;

public class WateringPlantsDemo {
    public static void main(String[] args) {
        WateringService wateringService = new WateringPlantsImpl();

        int[] plants1 = {2, 2, 3, 3};
        int capacity1 = 5;
        System.out.println("пример 1: " + wateringService.calculateSteps(plants1, capacity1));

        int[] plants2 = {1, 1, 1, 4, 2, 3};
        int capacity2 = 4;
        System.out.println("пример 2: " + wateringService.calculateSteps(plants2, capacity2));

        int[] plants3 = {7, 7, 7, 7, 7, 7, 7};
        int capacity3 = 8;
        System.out.println("пример 3: " + wateringService.calculateSteps(plants3, capacity3));
    }
}