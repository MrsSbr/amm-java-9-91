package Court.performance;

import Court.CourtLog;
import Court.Lawsuit;
import Court.LawsuitListFactory;

import java.util.Collection;
import java.util.function.Supplier;

public class PerformanceTester {
    private static int lawsuitCount;
    private static int testAmount;
    private static LawsuitListFactory factory;
    private CourtLog log;

    static {
        factory = new LawsuitListFactory(lawsuitCount);
        lawsuitCount = 6490;
        testAmount = 10;
    }

    public static void setTestAmount(int testAmount) {
        PerformanceTester.testAmount = testAmount;
    }

    public static void setLawsuitCount(int lawsuitCount) {
        PerformanceTester.lawsuitCount = lawsuitCount;
    }

    public TimeMeasurement testCollection(Supplier<Collection<Lawsuit>> supplier) {
        long creationTime = 0;
        long unsuitedPeopleCountExTime = 0;
        long peopleWithClausesInTenYearsExTime = 0;
        long peopleWithSuitsInThreeYearsEXTime = 0;

        for (int i = 0; i < testAmount; i++) {
            creationTime += getMethodExecutionTime(() -> log = new CourtLog(supplier, factory.getLawsuitList()));
            unsuitedPeopleCountExTime += getMethodExecutionTime(log::getUnsuitedPeopleCount);
            peopleWithClausesInTenYearsExTime += getMethodExecutionTime(log::getPeopleWithSeveralClausesInTenYears);
            peopleWithSuitsInThreeYearsEXTime += getMethodExecutionTime(log::getPeopleWithSeveralSuitsInThreeYears);
        }

        return new TimeMeasurement(creationTime / testAmount,
                unsuitedPeopleCountExTime / testAmount,
                peopleWithClausesInTenYearsExTime / testAmount,
                peopleWithSuitsInThreeYearsEXTime / testAmount);
    }

    private static long getMethodExecutionTime(Runnable method) {
        long timeBeforeExecution = System.nanoTime();
        method.run();
        return System.nanoTime() - timeBeforeExecution;
    }
}
