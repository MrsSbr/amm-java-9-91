package ru.ponitkovdaniil;

import ru.ponitkovdaniil.delivery.DeliveryAnalysis;
import ru.ponitkovdaniil.delivery.DeliveryDataGenerator;
import ru.ponitkovdaniil.delivery.DeliveryRecord;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CollectionsTest {
    public static void main(String[] args) {
        Collection<DeliveryRecord> arrayList = createCollection(ArrayList::new, 1272);
        Collection<DeliveryRecord> linkedList = createCollection(LinkedList::new, 1272);
        Collection<DeliveryRecord> vector = createCollection(Vector::new, 1272);

        performance(arrayList);
        performance(linkedList);
        performance(vector);
    }

    private static <T extends Collection<DeliveryRecord>> T createCollection(Supplier<T> factory, int size) {
        return Stream.generate(DeliveryDataGenerator::generateData)
                .limit(size)
                .collect(factory, Collection::add, Collection::addAll);
    }

    private static void performance(Collection<DeliveryRecord> collection) {
        DeliveryAnalysis deliveryAnalysis = new DeliveryAnalysis(collection);

        int number = 1000;
        long finalTime = 0;
        long startTime;
        long endTime;

        for (int i = 0; i < number; ++i) {
            startTime = System.nanoTime();

            deliveryAnalysis.calculateAverageDeliveryTime();
            deliveryAnalysis.findMaxOrderDaysLastMonth();
            deliveryAnalysis.findMaxOrderDaysLastMonth();

            endTime = System.nanoTime();

            finalTime += endTime - startTime;
        }

        double nanosecondsToMilliseconds = 1e6;
        double timeToMilliseconds = finalTime / (number * nanosecondsToMilliseconds);

        System.out.println(collection.getClass().getSimpleName() + ": " + timeToMilliseconds + " миллисекунд.");
    }
}
