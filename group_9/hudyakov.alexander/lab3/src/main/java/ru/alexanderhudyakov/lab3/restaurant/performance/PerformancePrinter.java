package ru.alexanderhudyakov.lab3.restaurant.performance;

import java.io.PrintStream;

public class PerformancePrinter {
    private final PerformanceTester performanceTester;
    private PrintStream out;

    public PerformancePrinter(PerformanceTester performanceTester, PrintStream out) {
        this.performanceTester = performanceTester;
        this.out = out;
    }

    public PerformanceTester getPerformanceTester() {
        return performanceTester;
    }

    public PrintStream getOut() {
        return out;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }

    public void print() {
        ExecutionTime time = performanceTester.getAverageExecutionTime(20);
        out.println(performanceTester.getCollectionName());
        out.printf("Время создания:\t%d\n", time.getCreation());
        out.printf("Поиск уникальных:\t%d\n", time.getUniqueDishes());
        out.printf("Подсчёт суммы:\t%d\n", time.getTotalIncome());
        out.printf("Поиск максимумов:\t%d\n", time.getMostExpensiveDishes());
    }
}
