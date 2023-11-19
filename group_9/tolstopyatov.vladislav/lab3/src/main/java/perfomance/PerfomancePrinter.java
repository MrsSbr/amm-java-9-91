package perfomance;

public class PerfomancePrinter {
    private final PerfomanceAnalyzer performanceAnalyzer;

    public PerfomancePrinter(PerfomanceAnalyzer performanceAnalyzer) {
        this.performanceAnalyzer = performanceAnalyzer;
    }

    public PerfomanceAnalyzer getPerformanceAnalyzer() {
        return performanceAnalyzer;
    }

    public void print() {
        ExecutionTime time = performanceAnalyzer.AVGtotalExecutionTime(10);
        System.out.println(performanceAnalyzer.getCollectionName());
        System.out.println("\nВремя создания: " + performanceAnalyzer.getCreationTime() + " миллисекунд");
        System.out.println("\nВремя поиска кол-ва дней, после которых на следующий день пошёл дождь : " + performanceAnalyzer.getCreationTime() + " миллисекунд");
        System.out.println("\nВремя поиска последнего месяца, когда не приносили в жертву животное: " + performanceAnalyzer.getCreationTime() + " миллисекунд");
        System.out.println("\nВремя сравнения эффективности жертвоприношения людей и животных: " + performanceAnalyzer.getCreationTime() + " миллисекунд\n\n");
    }
}
