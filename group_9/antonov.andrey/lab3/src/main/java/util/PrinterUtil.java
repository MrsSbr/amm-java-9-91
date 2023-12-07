package util;

import lombok.experimental.UtilityClass;
import service.AnalyzerServiceImpl;

@UtilityClass
public class PrinterUtil {
    public static void printStatisticByPerformanceService(AnalyzerServiceImpl analyzerService, String message) {
        var statistics = analyzerService.getStatisticsBySolverService();
        System.out.println("Средняя статистика выполнения для: " + message);
        System.out.println("Время получения специального списка электростанций: " + statistics.getAvgTimeSearchSpecialPowerPlantType());
        System.out.println("Время получения средней мощности для каждого типа: " + statistics.getAvgTimeSearchProductionCapacityByPowerPlantType());
        System.out.println("Время получения суммарной мощности за последний год: " + statistics.getAvgTimeSearchProductionCapacityLastYear());
    }
}
