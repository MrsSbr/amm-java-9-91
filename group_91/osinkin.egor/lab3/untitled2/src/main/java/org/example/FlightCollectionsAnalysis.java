package org.example;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

public class FlightCollectionsAnalysis {
    private static final int COUNT_TEST = 20;
    private static final int COUNT_ELEM = 12427;

    public static void main(String[] args) {
        List<Supplier<Collection<Flight>>> suppliers = List.of(
                ArrayList::new,
                HashSet::new,
                LinkedList::new
        );
        List<String> suppliersNames = List.of("ArrayList", "HashSet", "LinkedList");
        String methodName = "taskCount";
        // task = new BicycleRaceTask();
        for (int i = 0; i < suppliers.size(); i++) {
            Collection<Flight> flights = createCollection(COUNT_ELEM, suppliers.get(i));

            System.out.println("Время работы " + suppliersNames.get(i) + " для " +
                    methodName + " составляет: " + timeForCollection(flights) + " наносекунд");

        }
    }

    public static long timeForCollection(Collection<Flight> flights) {
        long startTime = System.nanoTime();
        //BicycleRaceTask task = new BicycleRaceTask();
        for (int i = 0; i < COUNT_TEST; i++) {
            Calendar date = GeneratePassages.generateDate(new Random());
            TaskFlight.taskCount(date, flights);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / (long) COUNT_TEST;
    }

    public static Collection<Flight> createCollection(int count, Supplier<Collection<Flight>> supplier) {

        return Stream.generate(GeneratePassages::generateFlight)
                .limit(count)
                .collect(toCollection(supplier));
    }
}