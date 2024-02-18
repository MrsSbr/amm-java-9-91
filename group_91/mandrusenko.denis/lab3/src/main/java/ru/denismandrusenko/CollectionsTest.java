package ru.denismandrusenko;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CollectionsTest {
    public static void main(String[] args) {
        Collection<BoardGame> arrayList = createCollection(ArrayList::new);
        Collection<BoardGame> linkedList = createCollection(LinkedList::new);
        Collection<BoardGame> vector = createCollection(Vector::new);

        performance(arrayList);
        performance(linkedList);
        performance(vector);
    }

    private static <T extends Collection<BoardGame>> T createCollection(Supplier<T> factory) {
        return Stream.generate(BoardGameFactory::generateBoardGame)
                .limit(1200)
                .collect(factory, Collection::add, Collection::addAll);
    }

    private static void performance(Collection<BoardGame> collection) {
        BoardGameTask task = new BoardGameTask(collection);

        int number = 1000;
        long finalTime = 0;
        long startTime;
        long endTime;

        for (int i = 0; i < number; ++i) {
            startTime = System.nanoTime();

            task.getBestSellingGamesByGenre();
            task.getMonthWithHighestRevenue();
            task.getGameNameWithSalesButNotRecently();

            endTime = System.nanoTime();

            finalTime += endTime - startTime;
        }

        double nanosecondsToMilliseconds = 1e6;
        double timeToMilliseconds = finalTime / (number * nanosecondsToMilliseconds);

        System.out.println(collection.getClass().getSimpleName() + ": " + timeToMilliseconds + " миллисекунд.");
    }
}
