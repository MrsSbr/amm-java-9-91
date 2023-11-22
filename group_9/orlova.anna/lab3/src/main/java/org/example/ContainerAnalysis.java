package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.function.Supplier;


public class ContainerAnalysis {

    public static void main(String[] args) {

        List<Supplier<Collection<String>>> suppliersCollections = List.of(
                LinkedList::new,
                ArrayList::new,
                ArrayDeque::new
        );

        List<String> namesCollections = List.of("LinkedList", "ArrayList", "ArrayDeque");
        List<String> namesMethods = List.of("getUniqueWords", "getMostFrequentWords", "countWordsContaining");
        List<String> text = TextProcesser.parseText();

        int indexCollection = 0;

        for (Supplier<Collection<String>> supplier : suppliersCollections) {

            TextStatistics statistics = new TextStatistics(supplier, text);
            List<Long> timeMethods = new ArrayList<>(List.of(0L, 0L, 0L));

            long time = System.nanoTime();
            statistics.getUniqueWords();
            timeMethods.set(0, timeMethods.get(0) + System.nanoTime() - time);
            time = System.nanoTime();
            statistics.getMostFrequentWords();
            timeMethods.set(1, timeMethods.get(1) + System.nanoTime() - time);
            time = System.nanoTime();
            statistics.countWordsContaining("s");
            timeMethods.set(2, timeMethods.get(2) + System.nanoTime() - time);

            System.out.println("Время работы контейнера " + namesCollections.get(indexCollection) + " в методе " +
                    namesMethods.get(0) + " составило " + timeMethods.get(0) + " наносекунд");
            System.out.println("Время работы контейнера " + namesCollections.get(indexCollection) + " в методе " +
                    namesMethods.get(1) + " составило " + timeMethods.get(1) + " наносекунд");
            System.out.println("Время работы контейнера " + namesCollections.get(indexCollection) + " в методе " +
                    namesMethods.get(2) + " составило " + timeMethods.get(2) + " наносекунд");
            System.out.println();
            indexCollection++;
        }
    }
}