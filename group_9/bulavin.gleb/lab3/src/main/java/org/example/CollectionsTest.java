package org.example;


import org.example.performance.PerformancePrinter;
import org.example.performance.PerformanceTester;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Supplier;

public class CollectionsTest {
    public static void main(String[] args) {
        testCollection(ArrayList::new, "ArrayList");
        testCollection(LinkedList::new, "LinkedList");
        testCollection(HashSet::new, "HashSet");

    }

    private static void testCollection(Supplier<Collection<CourtCase>> collectionSupplier, String collectionName) {
        PerformanceTester tester = new PerformanceTester(collectionSupplier, collectionName);
        PerformancePrinter printer = new PerformancePrinter(tester);
        printer.print();
    }
}