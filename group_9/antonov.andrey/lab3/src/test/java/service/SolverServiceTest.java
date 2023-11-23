package service;

import entity.PowerPlant;
import entity.TypePowerPlant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class SolverServiceTest {
    //   Список типов электростанций(для тестового списка), которые хотя бы один раз произвели больше 50 МВт/чза последний месяц
    private static final List<TypePowerPlant> TYPE_POWER_PLANT_LIST = List.of(TypePowerPlant.SOLAR);
    // Средняя мощность для каждого типа электростанций за последние 3 месяца(для тестового списка)
    private static final Map<TypePowerPlant, Double> TYPE_POWER_PLANT_DOUBLE_MAP = Map.of(
            TypePowerPlant.SOLAR, 60.0
    );
    //суммарная мощность за последний год(для тестового списка)
    private static final int SUM_PRODUCTION_CAPACITY_LAST_YEAR = 55 + 60;
    private final Collection<PowerPlant> POWER_PLANTS_TEST = List.of(
            PowerPlant.of(LocalDate.of(2010, 10, 5), TypePowerPlant.HYDRO, 25),
            PowerPlant.of(LocalDate.of(2010, 5, 1), TypePowerPlant.ATOMIC, 25),
            PowerPlant.of(LocalDate.of(2023, 5, 2), TypePowerPlant.HYDRO, 55),
            PowerPlant.of(LocalDate.of(2015, 4, 3), TypePowerPlant.SOLAR, 14),
            PowerPlant.of(LocalDate.of(2023, 11, 12), TypePowerPlant.SOLAR, 60));

    static Stream<Supplier<Collection<PowerPlant>>> getTypeCollection() {
        return Stream.of(ArrayList::new,
                LinkedList::new,
                HashSet::new);
    }

    @ParameterizedTest
    @MethodSource("getTypeCollection")
    void getSpecialTypePowerPlantTest(Supplier<Collection<PowerPlant>> supplier) {
        var solverService = new SolverService(supplier, POWER_PLANTS_TEST);
        var powerPlant = solverService.getSpecialTypePowerPlant();
        assertThat(powerPlant).isEqualTo(TYPE_POWER_PLANT_LIST);
    }

    @ParameterizedTest
    @MethodSource("getTypeCollection")
    void getAverageProductionCapacityByTypePowerPlantsTest(Supplier<Collection<PowerPlant>> supplier) {
        var solverService = new SolverService(supplier, POWER_PLANTS_TEST);
        var powerPlantDoubleMap = solverService.getAverageProductionCapacityByTypePowerPlants();
        assertThat(powerPlantDoubleMap).isEqualTo(TYPE_POWER_PLANT_DOUBLE_MAP);
    }

    @ParameterizedTest
    @MethodSource("getTypeCollection")
    void getSummaryProductionCapacityLastYearTest(Supplier<Collection<PowerPlant>> supplier) {
        var solverService = new SolverService(supplier, POWER_PLANTS_TEST);
        var productionCapacityLastYear = solverService.getSummaryProductionCapacityLastYear();
        assertThat(productionCapacityLastYear).isEqualTo(SUM_PRODUCTION_CAPACITY_LAST_YEAR);
    }
}
