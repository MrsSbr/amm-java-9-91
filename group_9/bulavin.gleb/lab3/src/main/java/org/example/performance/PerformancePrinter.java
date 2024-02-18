package org.example.performance;

public class PerformancePrinter {
    private final PerformanceTester performanceTester;

    public PerformancePrinter(PerformanceTester performanceTester) {
        this.performanceTester = performanceTester;
    }

    public PerformanceTester getPerformanceTester() {
        return performanceTester;
    }

    public void print() {
        ExecutionTime time = performanceTester.getAverageExecutionTime(20);
        System.out.println(performanceTester.getCollectionName());
        System.out.printf("Время создания:\t%d\n", time.getCreation());
        System.out.printf("Осуждённые люди:\t%d\n", time.getConvictedPeople());
        System.out.printf("Год с высшим процентом оправдательных приговоров:\t%d\n", time.getYearWithHighestPercentageAcquittals());
        System.out.printf("Поиск истцов и ответчиков:\t%d\n", time.getDefendantAndPlaintiffPeople());
    }
}

