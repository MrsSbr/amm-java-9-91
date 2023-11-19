package main.java.org.example;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeaPlantationCollectionsAnalysis {

    private static final int TESTS_AMOUNT = 30;
    private final List<String> methodsTitles;
    private final List<String> suppliersTitles;
    private final TeaPlantationSettings settings;
    private final TeaPlantationFunctionality tpf;

    TeaPlantationCollectionsAnalysis() {
        settings = new TeaPlantationSettings();
        tpf = new TeaPlantationFunctionality();
        suppliersTitles = Stream.of("ArrayList", "LinkedList", "HashSet")
                .collect(Collectors.toList());
        methodsTitles = Stream.of(
                "Самый урожайный год для каждого вида чая",
                "Перечислить виды чая, собранные в 2018",
                "Вес самого большого пакета для каждого вида чая"
        ).collect(Collectors.toList());
    }

    public void testDifferentCollections() {
        methodsTitles.forEach(method ->
                suppliersTitles.forEach(supplier -> System.out.println("Время работы коллекции " +
                        supplier + " над методом '" + method + "' = " +
                        checkCollectionTimePerformance(supplier, method) + " нс"))
        );
    }

    private long checkCollectionTimePerformance(String supplier, String method) {

        Collection<TeaPackage> teaPackages = settings.createPlantation(defineCollectionType(supplier));
        long start = System.nanoTime();

        for (int i = 0; i < TESTS_AMOUNT; ++i) {
            switch (method) {
                case "Самый урожайный год для каждого вида чая" -> tpf.findTheMostPlenteousYears(teaPackages);
                case "Перечислить виды чая, собранные в 2018" -> tpf.findTeaTypesHarvestedIn2018(teaPackages);
                default -> tpf.findMaxWeightForEachTeaType(teaPackages);
            }
        }

        long finish = System.nanoTime();
        return (finish - start)/(long)TESTS_AMOUNT;
    }

    private static Supplier<Collection<TeaPackage>> defineCollectionType(String supplier) {
        return switch (supplier) {
            case "LinkedList" -> LinkedList::new;
            case "HashSet" -> HashSet::new;
            default -> ArrayList::new;
        };
    }
}
