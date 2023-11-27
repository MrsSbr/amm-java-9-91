package service;

import entity.PowerPlant;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import util.CollectionPowerPlantUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

class AnalyzerServiceTest {

    private final Supplier<Collection<PowerPlant>> DEFAULT_SUPPLIER = ArrayList::new;
    private static final int DEFAULT_CAPACITY = 1000;

    @Timeout(value = 500, unit = MILLISECONDS)
    @RepeatedTest(5)
    void shouldSuccessFindStatisticTest() {
        var collectionForTest = getCollectionForTest(DEFAULT_CAPACITY);
        var solverService = new SolverService(collectionForTest);
        var analyzerService = new AnalyzerService(solverService);
        var statisticsBySolverService = analyzerService.getStatisticsBySolverService();
    }

     /*
        здесь хочу увеличить размер коллекции в 10 раз, а таймаут такой же оставить, чтобы теперь не успел выполниться,
        но так похоже нельзя
     */
//    @Test
//    @Timeout(value = 500, unit = MILLISECONDS)
//    @RepeatedTest(5)
//    void shouldFailFindStatisticTest() {
//        var collectionForTest = getCollectionForTest(DEFAULT_CAPACITY*10);
//        var solverService = new SolverService(collectionForTest);
//        var analyzerService = new AnalyzerService(solverService);
//        var statisticsBySolverService = analyzerService.getStatisticsBySolverService();
//    }

    private Collection<PowerPlant> getCollectionForTest(int size) {
        return CollectionPowerPlantUtil.generateCollectionBySupplier(DEFAULT_SUPPLIER, size);
    }
}