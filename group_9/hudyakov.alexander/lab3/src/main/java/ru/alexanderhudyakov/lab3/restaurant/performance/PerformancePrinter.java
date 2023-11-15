package ru.alexanderhudyakov.lab3.restaurant.performance;

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
        System.out.printf("Поиск уникальных:\t%d\n", time.getUniqueDishes());
        System.out.printf("Подсчёт суммы:\t%d\n", time.getTotalIncome());
        System.out.printf("Поиск максимумов:\t%d\n", time.getMostExpensiveDishes());
    }
}
