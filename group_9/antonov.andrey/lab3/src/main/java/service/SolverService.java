package service;

import entity.PowerPlant;
import entity.TypePowerPlant;
import lombok.Getter;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static util.LocalDateUtil.dateIsCorrectMonth;

public class SolverService {

    public static final int PRODUCTION_CAPACITY_FOR_MONTH = 50;
    private static final int ONE_MONTH = 1;
    private static final int THREE_MONTH = 3;
    private static final int TWELVE_MONTH = 12;

    @Getter //для автоматического получения типа коллекции при печати(так не нужен)
    private final Collection<PowerPlant> powerPlants;
    
    public SolverService(Collection<PowerPlant> powerPlants) {
        this.powerPlants = powerPlants;
    }

    /*Список типов электростанций, которые хотя бы один раз произвели больше 50 МВт/ч за последний месяц*/
    public List<TypePowerPlant> getSpecialTypePowerPlant() {
        return powerPlants.stream()
                .filter(powerPlant -> dateIsCorrectMonth(powerPlant.getDate(), ONE_MONTH))
                .filter(powerPlant -> powerPlant.getProductionCapacity() >= PRODUCTION_CAPACITY_FOR_MONTH)
                .map(PowerPlant::getTypePowerPlant)
                .distinct()
                .collect(toList());
    }

    /*Средняя мощность для каждого типа электростанций за последние 3 месяца*/
    public Map<TypePowerPlant, Double> getAverageProductionCapacityByTypePowerPlants() {
        return powerPlants.stream()
                .filter(powerPlant -> dateIsCorrectMonth(powerPlant.getDate(), THREE_MONTH))
                .collect(groupingBy(PowerPlant::getTypePowerPlant, Collectors.averagingLong(PowerPlant::getProductionCapacity)));
    }

    /*Суммарная производимая мощность за последний год*/
    public int getSummaryProductionCapacityLastYear() {
        return powerPlants.stream()
                .filter(powerPlant -> dateIsCorrectMonth(powerPlant.getDate(), TWELVE_MONTH))
                .mapToInt(PowerPlant::getProductionCapacity)
                .sum();
    }
}
