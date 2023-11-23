package service;

import entity.ExecutionStatisticBySolverService;
import entity.PowerPlant;

import java.util.Collection;
import java.util.function.Supplier;

import static util.TimeExecutionTaskUtil.get;

public class PerformanceBySolverService {
    private static final int COUNT_POWER_PLANTS = 17435;
    private final PowerPlantsService factory = new PowerPlantsService(COUNT_POWER_PLANTS);
    private final Supplier<Collection<PowerPlant>> supplier;
    private SolverService solverService;

    public PerformanceBySolverService(Supplier<Collection<PowerPlant>> supplier) {
        this.supplier = supplier;
    }

    public ExecutionStatisticBySolverService getStatisticsBySolverService() {
        return ExecutionStatisticBySolverService.of(
                getCreationTime(),
                getTimeSearchSpecialPowerPlantType(),
                getTimeSearchProductionCapacityByPowerPlantType(),
                getTimeSearchProductionCapacityLastYear());
    }

    private long getCreationTime() {
        return get(() -> solverService = new SolverService(supplier, factory.getRandomPowerPlantsList()));
    }

    private long getTimeSearchSpecialPowerPlantType() {
        return get(() -> solverService.getSpecialTypePowerPlant());
    }

    private long getTimeSearchProductionCapacityByPowerPlantType() {
        return get(() -> solverService.getAverageProductionCapacityByTypePowerPlants());
    }

    private long getTimeSearchProductionCapacityLastYear() {
        return get(() -> solverService.getSummaryProductionCapacityLastYear());
    }
}
