package org.example.performance;

import org.example.RandomRecordsFactory;
import org.example.CourtCase;
import org.example.Records;

import java.util.Collection;
import java.util.function.Supplier;

public class PerformanceTester {
    private final static int RECORD_COUNT = 5780;
    private final RandomRecordsFactory factory = new RandomRecordsFactory(RECORD_COUNT);
    private final Supplier<Collection<CourtCase>> collectionSupplier;
    private final String collectionName;
    private Records records;

    public PerformanceTester(Supplier<Collection<CourtCase>> collectionSupplier, String collectionName) {
        this.collectionSupplier = collectionSupplier;
        this.collectionName = collectionName;
    }

    public Records getRecords() {
        return records;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public long getConvictedPeopleExecutionTime() {
        return getMethodExecutionTime(records::getConvictedPeople);
    }

    public long getYearWithHighestPercentageAcquittalsExecutionTime() {
        return getMethodExecutionTime(records::getYearWithHighestPercentageAcquittals);
    }

    public long getDefendantAndPlaintiffPeopleExecutionTime() {
        return getMethodExecutionTime(records::getDefendantAndPlaintiffPeople);
    }

    public long getCreationTime() {
        return getMethodExecutionTime(() -> records = new Records(factory.getRecords(collectionSupplier)));
    }

    public ExecutionTime getAverageExecutionTime(int count) {

        long creation = 0;
        long convictedPeople = 0;
        long yearWithHighestPercentageAcquittals = 0;
        long defendantAndPlaintiffPeople = 0;
        for (int i = 0; i < count; i++) {
            creation += getCreationTime();
            convictedPeople += getConvictedPeopleExecutionTime();
            yearWithHighestPercentageAcquittals += getYearWithHighestPercentageAcquittalsExecutionTime();
            defendantAndPlaintiffPeople += getDefendantAndPlaintiffPeopleExecutionTime();
        }
        return ExecutionTimeBuilder
                .anExecutionTime()
                .withCreation(creation / count)
                .withConvictedPeople(convictedPeople / count)
                .withYearWithHighestPercentageAcquittals(yearWithHighestPercentageAcquittals / count)
                .withDefendantAndPlaintiffPeople(defendantAndPlaintiffPeople / count)
                .build();

    }

    private long getMethodExecutionTime(Runnable runnable) {
        long timeBeforeExecution = System.nanoTime();
        runnable.run();
        return System.nanoTime() - timeBeforeExecution;
    }
}
