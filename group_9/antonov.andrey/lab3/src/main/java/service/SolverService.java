package service;

import entity.PowerPlant;
import entity.TypePowerPlant;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;
import static java.util.Collections.unmodifiableCollection;
import static java.util.stream.Collectors.toList;

public class SolverService {
    public static final int SPECIAL_PRODUCTION_CAPACITY = 50;
    private static final long COUNT_MONTH_FOR_STATISTIC = 3;
    public static final int COUNT_MONTH_IN_YEAR = 12;
    private final Collection<PowerPlant> powerPlants;

    public SolverService(Supplier<Collection<PowerPlant>> collectionSupplier, Collection<PowerPlant> powerPlantsCollection) {
        var collect = powerPlantsCollection.stream()
                .collect(collectionSupplier, Collection<PowerPlant>::add, Collection<PowerPlant>::addAll);
        this.powerPlants = unmodifiableCollection(collect);
    }

    /*Список типов электростанций, которые хотя бы один раз произвели больше 50 МВт/ч за последний месяц*/
    public List<TypePowerPlant> getSpecialTypePowerPlant() {
        return powerPlants.stream()
                .filter(powerPlant -> DAYS.between(powerPlant.getDate(), LocalDate.now()) <= LocalDate.now().lengthOfMonth())
                .filter(powerPlant -> powerPlant.getProductionCapacity() >= SPECIAL_PRODUCTION_CAPACITY)
                .map(PowerPlant::getTypePowerPlant)
                .distinct()
                .collect(toList());
    }

    /*Средняя мощность для каждого типа электростанций за последние 3 месяца*/
    public Map<TypePowerPlant, Double> getAverageProductionCapacityByTypePowerPlants() {
        return powerPlants.stream()
                .filter(powerPlant -> MONTHS.between(powerPlant.getDate(), LocalDate.now()) <= COUNT_MONTH_FOR_STATISTIC)
                .collect(Collectors.groupingBy(PowerPlant::getTypePowerPlant, Collectors.averagingLong(PowerPlant::getProductionCapacity)));
    }

    /*Суммарная производимая мощность за последний год*/
    public int getSummaryProductionCapacityLastYear() {
        return powerPlants.stream()
                .filter(powerPlant -> MONTHS.between(powerPlant.getDate(), LocalDate.now()) <= COUNT_MONTH_IN_YEAR)
                .mapToInt(PowerPlant::getProductionCapacity)
                .sum();
    }
}
