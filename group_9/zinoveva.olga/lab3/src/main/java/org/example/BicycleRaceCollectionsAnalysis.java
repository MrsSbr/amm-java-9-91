package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BicycleRaceCollectionsAnalysis {
    private static final int COUNT_TEST = 20;
    private static final int COUNT_ELEM = 12427;

    public static void main(String[] args) {
        List<Supplier<Collection<BicycleRace>>> suppliers = List.of(
                ArrayList::new,
                HashSet::new,
                LinkedList::new
        );
        List<String> suppliersNames = List.of("ArrayList", "HashSet", "LinkedList");
        List<String> methodsNames = List.of("findAthletesWithPrizesInThreeYears", "countWinner", "findAthletesByCondition");
        BicycleRaceTask task = new BicycleRaceTask();
        for (int i = 0; i < suppliers.size(); i++) {
            Collection<BicycleRace> bicycleRaces = createCollection(COUNT_ELEM, suppliers.get(i));
            int finalI = i;
            methodsNames.forEach(method ->
                    System.out.println("Время работы " + suppliersNames.get(finalI) + " для " +
                            method + " составляет: " + timeForCollection(bicycleRaces, method) + " наносекунд")
            );
        }
    }

    public static long timeForCollection(Collection<BicycleRace> bicycleRaces, String methodName) {
        long startTime = System.nanoTime();
        BicycleRaceTask task = new BicycleRaceTask();
        for (int i = 0; i < COUNT_TEST; i++) {
            switch (methodName) {
                case "findAthletesWithPrizesInThreeYears": {
                    task.findAthletesWithPrizesInThreeYears(bicycleRaces);
                }
                case "countWinner": {
                    task.countWinner(bicycleRaces);
                }
                default: {
                    task.findAthletesByCondition(bicycleRaces);
                }
            }
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / (long) COUNT_TEST;
    }

    public static Collection<BicycleRace> createCollection(int count, Supplier<Collection<BicycleRace>> supplier) {
        return Stream.generate(BicycleRaceFactory::createBicycleRace)
                .limit(count)
                .collect(Collectors.toCollection(supplier));
    }
}
