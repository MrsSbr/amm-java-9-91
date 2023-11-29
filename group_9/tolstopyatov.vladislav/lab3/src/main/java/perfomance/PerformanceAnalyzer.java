package perfomance;

import SacrificesOfThePriests.AccountingForSacrifice;
import SacrificesOfThePriests.RandomAccountingOfTheSacrificesFactory;
import SacrificesOfThePriests.TlalocStatistics;

import java.time.Month;
import java.util.Collection;
import java.util.function.Supplier;

public class PerformanceAnalyzer {
    private static final int ACCOUNTING_FOR_SACRIFICE_COUNT = 7243;
    private final RandomAccountingOfTheSacrificesFactory factory = new RandomAccountingOfTheSacrificesFactory(ACCOUNTING_FOR_SACRIFICE_COUNT);
    private final Supplier<Collection<AccountingForSacrifice>> collectionSupplier;
    private final String collectionName;
    private TlalocStatistics tlalocStatistics;

    public PerformanceAnalyzer(Supplier<Collection<AccountingForSacrifice>> collectionSupplier, String collectionName) {
        this.collectionSupplier = collectionSupplier;
        this.collectionName = collectionName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public TlalocStatistics getTlalocStatistics() {
        return tlalocStatistics;
    }

    public long getCreationTime() {
        // считается время без учета работы рандома
        long startTime = System.currentTimeMillis();

        tlalocStatistics = new TlalocStatistics(collectionSupplier, factory.getAccountingForSacrificeList());

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getTheNumberOfSacrificesAfterWhichRainFellTheNextDayTime() {
        long startTime = System.currentTimeMillis();

        int result = tlalocStatistics.theNumberOfSacrificesAfterWhichRainFellTheNextDay();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getTheLastMonthInWhichThereWereNoAnimalSacrificesTime() {
        long startTime = System.currentTimeMillis();

        Month result = tlalocStatistics.theLastMonthInWhichThereWereNoAnimalSacrifices();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public long getCompareTheEffectivenessOfHumanSacrificesComparedToAnimalsTime() {
        long startTime = System.currentTimeMillis();

        boolean result = tlalocStatistics.isTheHumanSacrificesIsMoreEffectiveThanAnimal();

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public ExecutionTime AVGtotalExecutionTime(int testCount) {
        long creation = 0;
        long theNumberOfSacrificesAfterWhichRainFellTheNextDay = 0;
        long theLastMonthInWhichThereWereNoAnimalSacrifices = 0;
        long compareTheEffectivenessOfHumanSacrificesComparedToAnimals = 0;
        for (int i = 0; i < testCount; i++) {
            creation += getCreationTime();
            theNumberOfSacrificesAfterWhichRainFellTheNextDay += getTheNumberOfSacrificesAfterWhichRainFellTheNextDayTime();
            theLastMonthInWhichThereWereNoAnimalSacrifices += getTheLastMonthInWhichThereWereNoAnimalSacrificesTime();
            compareTheEffectivenessOfHumanSacrificesComparedToAnimals += getCompareTheEffectivenessOfHumanSacrificesComparedToAnimalsTime();
        }
        return new ExecutionTime(creation / testCount,
                theNumberOfSacrificesAfterWhichRainFellTheNextDay / testCount,
                theLastMonthInWhichThereWereNoAnimalSacrifices / testCount,
                compareTheEffectivenessOfHumanSacrificesComparedToAnimals / testCount);
    }

}
