package service;


import entity.TypeToCapacity;
import entity.PowerPlant;
import entity.TypePowerPlant;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolverServiceTest {

    private static final Collection<PowerPlant> POWER_PLANTS_TEST = List.of(
            PowerPlant.of(LocalDate.of(2010, 10, 5), TypePowerPlant.HYDRO, 25),
            PowerPlant.of(LocalDate.of(2010, 5, 1), TypePowerPlant.ATOMIC, 25),
            PowerPlant.of(LocalDate.of(2023, 5, 2), TypePowerPlant.HYDRO, 55),
            PowerPlant.of(LocalDate.of(2015, 4, 3), TypePowerPlant.SOLAR, 14),
            PowerPlant.of(LocalDate.of(2023, 11, 12), TypePowerPlant.SOLAR, 60),
            PowerPlant.of(LocalDate.of(2023, 9, 17), TypePowerPlant.ATOMIC, 105),
            PowerPlant.of(LocalDate.of(2023, 10, 18), TypePowerPlant.HYDRO, 55),
            PowerPlant.of(LocalDate.of(2023, 9, 19), TypePowerPlant.SOLAR, 53));

    private static final List<TypeToCapacity<TypePowerPlant, Double>> LIST_AVG_BY_POWER_PLANTS = List.of(
            TypeToCapacity.of(TypePowerPlant.ATOMIC, 105.0),
            TypeToCapacity.of(TypePowerPlant.HYDRO, 55.0),
            TypeToCapacity.of(TypePowerPlant.SOLAR, 56.5)
    );

    private static final List<TypePowerPlant> TYPE_POWER_PLANT_LIST = List.of(TypePowerPlant.SOLAR, TypePowerPlant.HYDRO);
    private static final int SUM_PRODUCTION_CAPACITY_LAST_YEAR = 55 + 60 + 105 + 55 + 53;


    @Test
    void getSpecialTypePowerPlantTest() {
        var solverService = new SolverService(POWER_PLANTS_TEST);
        var actualResult = solverService.getSpecialTypePowerPlant();
        assertEquals(TYPE_POWER_PLANT_LIST, actualResult);
    }

    @Test
    void getAverageProductionCapacityTest() {
        var solverService = new SolverService(POWER_PLANTS_TEST);
        var actualResult = solverService.getAverageProductionCapacityByTypePowerPlants();
        assertEquals(LIST_AVG_BY_POWER_PLANTS, actualResult);
    }

    @Test
    void getSummaryProductionTest() {
        var solverService = new SolverService(POWER_PLANTS_TEST);
        var actualResult = solverService.getSummaryProductionCapacityLastYear();
        assertEquals(actualResult, SUM_PRODUCTION_CAPACITY_LAST_YEAR);
    }

    @Test
    void getSummaryProductionIfCollectionEmpty() {
        var solverService = new SolverService(EMPTY_LIST);
        var actualResult = solverService.getSummaryProductionCapacityLastYear();
        assertEquals(0, actualResult);
    }

    @Test
    void shouldThrownNpeIfNullCollection() {
        var solverService = new SolverService(null);
        assertThrows(NullPointerException.class, solverService::getSpecialTypePowerPlant);
    }
}