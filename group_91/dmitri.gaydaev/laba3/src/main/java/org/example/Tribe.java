package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Tribe implements TribeInterface {

    public static List<Hunt> createHuntsList() {
        List<Hunt> hunts = new ArrayList<>();
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 8573; i++) {
            String name = "Hunter" + (random.nextInt(5) + 1);
            int weight = random.nextInt(1000) + 500;
            LocalDate date = LocalDate.of(2020, Month.JANUARY, 1).plusDays(random.nextInt(1095));
            hunts.add(new Hunt(name, weight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время заполнения ArrayList: " + (endTime - startTime) + " мс");

        return hunts;
    }

    public static List<Hunt> createHuntsListLinled() {
        List<Hunt> hunts = new LinkedList<>();
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 8573; i++) {
            String name = "Hunter" + (random.nextInt(5) + 1);
            int weight = random.nextInt(1000) + 500;
            LocalDate date = LocalDate.of(2020, Month.JANUARY, 1).plusDays(random.nextInt(1095));
            hunts.add(new Hunt(name, weight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Время заполнения LinkedList: " + (endTime - startTime) + " мс");

        return hunts;
    }

    @Override
    public List<String> getHunters(List<Hunt> hunts) {
        return hunts.stream()
                .map(Hunt::getHunter)
                .distinct()
                .collect(Collectors.toList());

    }

    @Override
    public int getTotalWeight(List<Hunt> hunts, int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate startDate = date.minusYears(3);
        LocalDate endDate = date;
        return hunts.stream()
                .filter(hunt -> hunt.getDate().isAfter(startDate) && hunt.getDate().isBefore(endDate))
                .mapToInt(Hunt::getWeight)
                .sum();

    }


    @Override
    public List<String> getHunterWeights(List<Hunt> hunts) {
        Map<String, Integer> hunterWeights = new HashMap<>();
        for (Hunt hunt : hunts) {
            String hunter = hunt.getHunter();
            int weight = hunt.getWeight();
            hunterWeights.merge(hunter, weight, Integer::sum);
        }

        return hunterWeights.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.toList());


    }


}

