package perfomance;

public class PerfomancePrinter {
    private final PerformanceAnalyzer performanceAnalyzer;

    public PerfomancePrinter(PerformanceAnalyzer performanceAnalyzer) {
        this.performanceAnalyzer = performanceAnalyzer;
    }

    public PerformanceAnalyzer getPerformanceAnalyzer() {
        return performanceAnalyzer;
    }

    public void print() {
        ExecutionTime time = performanceAnalyzer.AVGtotalExecutionTime(10);
        System.out.println(performanceAnalyzer.getCollectionName());
        System.out.println("\nВремя поиска кол-ва дней, после которых на следующий день пошёл дождь : "
                + performanceAnalyzer.getTheLastMonthInWhichThereWereNoAnimalSacrificesTime() + " миллисекунд");
        System.out.println("\nВремя поиска последнего месяца, когда не приносили в жертву животное: "
                + performanceAnalyzer.getTheLastMonthInWhichThereWereNoAnimalSacrificesTime() + " миллисекунд");
        System.out.println("\nВремя сравнения эффективности жертвоприношения людей и животных: "
                + performanceAnalyzer.getCompareTheEffectivenessOfHumanSacrificesComparedToAnimalsTime() + " миллисекунд\n\n");
    }
}
