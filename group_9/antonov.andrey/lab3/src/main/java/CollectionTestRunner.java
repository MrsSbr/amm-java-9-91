import entity.PowerPlant;
import service.PerformanceBySolverService;
import service.PrinterService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.function.Supplier;

public class CollectionTestRunner {
    public static void main(String[] args) {
        testCollection(ArrayList::new);
        testCollection(LinkedList::new);
        testCollection(HashSet::new);
    }

    private static void testCollection(Supplier<Collection<PowerPlant>> collectionSupplier) {
        var performanceService = new PerformanceBySolverService(collectionSupplier);
        var performancePrinterService = new PrinterService(performanceService);
        performancePrinterService.printStatistic();
    }
}
