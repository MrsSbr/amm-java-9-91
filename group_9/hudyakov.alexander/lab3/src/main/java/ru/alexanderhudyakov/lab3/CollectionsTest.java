package ru.alexanderhudyakov.lab3;

import ru.alexanderhudyakov.lab3.restaurant.Dish;
import ru.alexanderhudyakov.lab3.restaurant.performance.PerformancePrinter;
import ru.alexanderhudyakov.lab3.restaurant.performance.PerformanceTester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.Supplier;

public class CollectionsTest {
    public static void main(String[] args) {
        testCollection(ArrayList::new, "ArrayList");
        testCollection(LinkedList::new, "LinkedList");
        testCollection(Vector::new, "Vector");
        testCollection(HashSet::new, "HashSet");
        testCollection(LinkedHashSet::new, "LinkedHashSet");
        testCollection(() -> new TreeSet<>((d1, d2) -> {
            if (d1 == d2) return 0;
            if (d1.getPrice() < d2.getPrice()) return -1;
            return 1;
        }), "TreeSet");

    }

    private static void testCollection(Supplier<Collection<Dish>> collectionSupplier, String collectionName) {
        PerformanceTester tester = new PerformanceTester(collectionSupplier, collectionName);
        PerformancePrinter printer = new PerformancePrinter(tester, System.out);
        printer.print();
    }
}