package service;


import entity.PowerPlant;
import entity.TypePowerPlant;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolverServiceTest {

    private static final List<TypePowerPlant> TYPE_POWER_PLANT_LIST = List.of(TypePowerPlant.SOLAR);

    // Средняя мощность для каждого типа электростанций за последние 3 месяца(для тестового списка)
    private static final Map<TypePowerPlant, Double> TYPE_POWER_PLANT_DOUBLE_MAP = Map.of(
            TypePowerPlant.SOLAR, 60.0
    );

    //суммарная мощность за последний год(для тестового списка)
    private static final int SUM_PRODUCTION_CAPACITY_LAST_YEAR = 105;

    private final Collection<PowerPlant> POWER_PLANTS_TEST = List.of(
            PowerPlant.of(LocalDate.of(2010, 10, 5), TypePowerPlant.HYDRO, 25),
            PowerPlant.of(LocalDate.of(2010, 5, 1), TypePowerPlant.ATOMIC, 25),
            PowerPlant.of(LocalDate.of(2023, 5, 2), TypePowerPlant.HYDRO, 55),
            PowerPlant.of(LocalDate.of(2015, 4, 3), TypePowerPlant.SOLAR, 14),
            PowerPlant.of(LocalDate.of(2023, 11, 12), TypePowerPlant.SOLAR, 60));

    @Test
    void getSuccessSpecialTypePowerPlantTest() {
        var solverService = new SolverService(POWER_PLANTS_TEST);
        var actualResult = solverService.getSpecialTypePowerPlant();
        assertEquals(TYPE_POWER_PLANT_LIST, actualResult);
    }

    @Test
    void getSuccessAverageProductionCapacityTest() {
        var solverService = new SolverService(POWER_PLANTS_TEST);
        var actualResult = solverService.getAverageProductionCapacityByTypePowerPlants();
        assertEquals(TYPE_POWER_PLANT_DOUBLE_MAP, actualResult);
    }

    @Test
    void getSuccessSummaryProductionTest() {
        var solverService = new SolverService(POWER_PLANTS_TEST);
        var actualResult = solverService.getSummaryProductionCapacityLastYear();
        assertEquals(actualResult, SUM_PRODUCTION_CAPACITY_LAST_YEAR);
    }

    @Test
    void getSuccessSummaryProductionForEmptyCollectionTest() {
        var solverService = new SolverService(EMPTY_LIST);
        var actualResult = solverService.getSummaryProductionCapacityLastYear();
        assertEquals(0, actualResult);
    }
}