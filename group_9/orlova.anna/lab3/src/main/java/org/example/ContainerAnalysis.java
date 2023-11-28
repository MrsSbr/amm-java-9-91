package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayDeque;
import java.util.function.Supplier;


public class ContainerAnalysis {

    public static void main(String[] args) {
        List<String> text = TextProcesser.parseText();

        Collection<String> linkedList = createStringCollection(LinkedList::new, text);
        Collection<String> arrayList = createStringCollection(ArrayList::new, text);
        Collection<String> arrayDeque = createStringCollection(ArrayDeque::new, text);

        performanceCheck(linkedList);
        performanceCheck(arrayList);
        performanceCheck(arrayDeque);
    }

    public static void performanceCheck(Collection<String> collection) {

        final int countTest = 10;
        TextStatistics statistics = new TextStatistics(collection);
        List<Long> timeMethods = new ArrayList<>(List.of(0L, 0L, 0L));

        for (int i = 0; i < countTest; ++i) {

            long time = System.nanoTime();
            statistics.getUniqueWords();
            timeMethods.set(0, timeMethods.get(0) + System.nanoTime() - time);

            time = System.nanoTime();
            statistics.getMostFrequentWords();
            timeMethods.set(1, timeMethods.get(1) + System.nanoTime() - time);

            time = System.nanoTime();
            statistics.countWordsContaining("s");
            timeMethods.set(2, timeMethods.get(2) + System.nanoTime() - time);

        }

        System.out.println("Время работы контейнера " + collection.getClass().getSimpleName() + " в методе " +
                statistics.getClass().getMethods()[0].getName() + " составило " + timeMethods.get(0) / countTest
                + " наносекунд");
        System.out.println("Время работы контейнера " + collection.getClass().getSimpleName() + " в методе " +
                statistics.getClass().getMethods()[1].getName() + " составило " + timeMethods.get(1) / countTest
                + " наносекунд");
        System.out.println("Время работы контейнера " + collection.getClass().getSimpleName() + " в методе " +
                statistics.getClass().getMethods()[2].getName() + " составило " + timeMethods.get(2) / countTest
                + " наносекунд");
        System.out.println();
    }

    public static Collection<String> createStringCollection(Supplier<Collection<String>> factory,
                                                            List<String> sourceList) {
        return sourceList.stream()
                .collect(factory, Collection::add, Collection::addAll);
    }
}