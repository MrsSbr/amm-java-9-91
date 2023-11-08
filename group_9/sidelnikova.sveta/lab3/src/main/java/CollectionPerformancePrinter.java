import tasks.CollectionPerformanceAnalyzer;

public class CollectionPerformancePrinter {
    private final CollectionPerformanceAnalyzer analyzer;
    public CollectionPerformancePrinter(CollectionPerformanceAnalyzer analyzer) {
        this.analyzer = analyzer;
    }
    public void printMethodsPerformance(){
        System.out.println("Тип коллекции: " + analyzer.getCollectionName());
        System.out.println("Время работы метода создания коллекции: " +
                analyzer.getCollectionCreatingTotalTime() + " миллисекунд");
        System.out.println("Время работы метода по поиску продающихся напитков по утрам: " +
                analyzer.getMorningDrinksTaskTotalTime() + " миллисекунд");
        System.out.println("Время работы метода по поиску не заказанных ни разу " +
                "за последние 3 месяца напитков: " +
                analyzer.getNotOrderedDrinksLastThreeMonthsTaskTotalTime() + " миллисекунд");
        System.out.println("Время работы метода по подсчету общего количества приготовленных капучино: " +
                analyzer.getCappuccinoOrdersCountTaskTotalTime()+ " миллисекунд");
        System.out.println();
    }
}
