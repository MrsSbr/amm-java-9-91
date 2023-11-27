import service.AnalyzerService;
import service.SolverService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import static java.lang.System.lineSeparator;
import static util.CollectionPowerPlantUtil.generateCollectionBySupplier;
import static util.CollectionPowerPlantUtil.getTypeCollection;
import static util.PrinterUtil.printStatisticByPerformanceService;

public class CollectionTestRunner {
    private static final int DEFAULT_COLLECTION_SIZE = 17345;

    public static void main(String[] args) {
        var powerPlants1 = generateCollectionBySupplier(ArrayList::new, DEFAULT_COLLECTION_SIZE);
        var powerPlants2 = generateCollectionBySupplier(LinkedList::new, DEFAULT_COLLECTION_SIZE);
        var powerPlants3 = generateCollectionBySupplier(HashSet::new, DEFAULT_COLLECTION_SIZE);

        var solverService1 = new SolverService(powerPlants1);
        var solverService2 = new SolverService(powerPlants2);
        var solverService3 = new SolverService(powerPlants3);

        var analyzerService1 = new AnalyzerService(solverService1);
        var analyzerService2 = new AnalyzerService(solverService2);
        var analyzerService3 = new AnalyzerService(solverService3);

        printStatisticByAnalyzerServices(analyzerService1, analyzerService2, analyzerService3);
    }

    private static void printStatisticByAnalyzerServices(AnalyzerService... analyzerServices) {
        for (var analyzerService : analyzerServices) {
            var collection = analyzerService.getSolverService().getPowerPlants();
            printStatisticByPerformanceService(analyzerService, getTypeCollection(collection));
            System.out.println(lineSeparator());
        }
    }
}
