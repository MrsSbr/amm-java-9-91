package service;

public class PrinterService {
    private final PerformanceBySolverService performanceService;

    public PrinterService(PerformanceBySolverService performanceService) {
        this.performanceService = performanceService;
    }

    public void printStatistic() {
        var statistics = performanceService.getStatisticsBySolverService();
        System.out.println("Cтатистика выполнения");
        System.out.println("Время создания: " + statistics.getTimeCreation());
        System.out.println("Время получения специального списка электростанций: " + statistics.getTimeSearchSpecialPowerPlantType());
        System.out.println("Время получения средней мощности для каждого типа: " + statistics.getTimeSearchProductionCapacityByPowerPlantType());
        System.out.println("Время получения суммарной мощности за последний год: " + statistics.getTimeSearchProductionCapacityLastYear());
    }
}
