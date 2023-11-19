import SacrificesOfThePriests.AccountingForSacrifice;
import perfomance.PerfomanceAnalyzer;
import perfomance.PerfomancePrinter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Vector;
import java.util.function.Supplier;


public class CollectionsTest {
    public static void main(String[] args) {
        testCollection(ArrayList::new, "ArrayList");
        testCollection(LinkedList::new, "LinkedList");
        testCollection(Vector::new, "Vector");
        testCollection(HashSet::new, "HashSet");
        testCollection(LinkedHashSet::new, "LinkedHashSet");

    }

    private static void testCollection(Supplier<Collection<AccountingForSacrifice>> collectionSupplier, String collectionName) {
        PerfomanceAnalyzer analyzer = new PerfomanceAnalyzer(collectionSupplier, collectionName);
        PerfomancePrinter printer = new PerfomancePrinter(analyzer);
        printer.print();
    }
}