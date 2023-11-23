package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Tribe {
    public static void main(String[] args) {
        List<Hunt> hunts = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 8573; i++) {
            String name = "Hunter" + (random.nextInt(5) + 1);
            int weight = random.nextInt(1000) + 500;
            LocalDate date = LocalDate.of(2020, Month.JANUARY, 1).plusDays(random.nextInt(1095));
            hunts.add(new Hunt(name, weight, date.getYear(), date.getMonthValue(), date.getDayOfMonth()));
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате ГГГГ ММ ДД: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.println("Имена охотников, которые добывали мясо:");
        List<String> hunters = getHunters(hunts);
        hunters.forEach(System.out::println);
        System.out.println("Общее количество мяса за 3 года от указанной даты: " + getTotalWeight(hunts, year, month, day));
        System.out.println("Сколько мяса добыл каждый охотник:");
        List<String> hunterWeights = getHunterWeights(hunts);
        hunterWeights.forEach(System.out::println);
    }

    public static List<String> getHunters(List<Hunt> hunts) {
        return hunts.stream()
                .map(Hunt::getHunter)
                .distinct()
                .collect(Collectors.toList());
    }

    public static int getTotalWeight(List<Hunt> hunts, int year, int month, int day) {
        LocalDate date = LocalDate.of(year, month, day);
        LocalDate startDate = date.minusYears(3);
        LocalDate endDate = date;
        return hunts.stream()
                .filter(hunt -> hunt.getDate().isAfter(startDate) && hunt.getDate().isBefore(endDate))
                .mapToInt(Hunt::getWeight)
                .sum();
    }

    public static List<String> getHunterWeights(List<Hunt> hunts) {
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
