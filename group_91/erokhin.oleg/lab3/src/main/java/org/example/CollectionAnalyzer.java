package org.example;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionAnalyzer {
    private static final int HIVE_COUNT = 35;

    public static void main(String[] args) {
        List<Supplier<Collection<Hive>>> hiveSuppliers = List.of(
                LinkedList::new,
                ArrayList::new,
                HashSet::new
        );
        List<String> collectionNames = List.of("LinkedList", "ArrayList", "HashSet");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Количество лет: ");
        int years = scanner.nextInt();

        List<Double> totalHoneyProductionByYear = null;
        List<Double> totalHoneyByHive = null;

        final int runForTimes = 10;
        for (int i = 0; i < hiveSuppliers.size(); i++) {
            Supplier<Collection<Hive>> supplier = hiveSuppliers.get(i);
            ApiaryStatistics statistics = new ApiaryStatistics(supplier, generateHives(years), years);

            long now = System.nanoTime();

            for (int j = 0; j < runForTimes; j++) {
                totalHoneyProductionByYear = statistics.totalHoneyProductionByYear();
                totalHoneyByHive = statistics.totalHoneyByHive();
            }

            long elapsed = System.nanoTime() - now;

            System.out.println("Время работы контейнера " + collectionNames.get(i) +
                    " составило в среднем " + elapsed / runForTimes + " наносекунд");
        }

        System.out.println("Статистика по объемам меда за каждый год: " + totalHoneyProductionByYear.toString());
        System.out.println("Общий объем меда за весь период по каждому улью: " + totalHoneyByHive.toString());
    }

    public static List<Hive> generateHives(int years) {
        Random random = new Random();

        return IntStream
                .range(0, HIVE_COUNT)
                .mapToObj(x -> new Hive(
                        IntStream
                                .range(0, years)
                                .mapToDouble(year -> 0.0 + 100.0 * random.nextDouble())
                                .boxed()
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }
}
