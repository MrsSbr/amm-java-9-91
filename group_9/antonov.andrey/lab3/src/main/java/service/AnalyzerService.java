package service;

import entity.StatisticBySolverService;
import lombok.Getter;

import static util.TimeExecutionUtil.getExecutionTime;

public class AnalyzerService {
    private static final int DEFAULT_COUNT_TESTS = 555;
    @Getter
    private final SolverService solverService;

    public AnalyzerService(SolverService solverService) {
        this.solverService = solverService;
    }

    public StatisticBySolverService getStatisticsBySolverService() {
        long timeSearchSpecialPowerPlantType = 0;
        long timeSearchProductionCapacityByPowerPlantType = 0;
        long timeSearchProductionCapacityLastYear = 0;

        for (int i = 1; i <= DEFAULT_COUNT_TESTS; i++) {
            timeSearchSpecialPowerPlantType += getTimeSearchSpecialPowerPlantType();
            timeSearchProductionCapacityByPowerPlantType += getTimeSearchProductionCapacityByPowerPlantType();
            timeSearchProductionCapacityLastYear += getTimeSearchProductionCapacityLastYear();
        }

        return StatisticBySolverService.of(
                (double) timeSearchSpecialPowerPlantType / DEFAULT_COUNT_TESTS,
                (double) timeSearchProductionCapacityByPowerPlantType / DEFAULT_COUNT_TESTS,
                (double) timeSearchProductionCapacityLastYear / DEFAULT_COUNT_TESTS);
    }

    private long getTimeSearchSpecialPowerPlantType() {
        return getExecutionTime(solverService::getSpecialTypePowerPlant);
    }

    private long getTimeSearchProductionCapacityByPowerPlantType() {
        return getExecutionTime(solverService::getAverageProductionCapacityByTypePowerPlants);
    }

    private long getTimeSearchProductionCapacityLastYear() {
        return getExecutionTime(solverService::getSummaryProductionCapacityLastYear);
    }
}
