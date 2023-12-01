package service;

import entity.Pair;
import entity.PowerPlant;
import entity.TypePowerPlant;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static util.LocalDateUtil.dateIsCorrectMonth;

@AllArgsConstructor
@Getter
public class SolverService {
    public static final int PRODUCTION_CAPACITY_FOR_MONTH = 50;
    private static final int ONE_MONTH = 1;
    private static final int THREE_MONTH = 3;
    private static final int TWELVE_MONTH = 12;

    private final Collection<PowerPlant> powerPlants;

    /*Список типов электростанций, которые хотя бы один раз произвели больше 50 МВт/ч за последний месяц*/
    public List<TypePowerPlant> getSpecialTypePowerPlant() {
        return powerPlants.stream()
                .filter(powerPlant -> dateIsCorrectMonth(powerPlant.getDate(), ONE_MONTH))
                .filter(powerPlant -> powerPlant.getProductionCapacity() >= PRODUCTION_CAPACITY_FOR_MONTH)
                .map(PowerPlant::getTypePowerPlant)
                .distinct()
                .toList();
    }

    /*БЕЗ МАП Средняя мощность для каждого типа электростанций за последние 3 месяца*/
    public List<Pair<TypePowerPlant, Double>> getAverageProductionCapacityByTypePowerPlants() {

        var result = new ArrayList<Pair<TypePowerPlant, Double>>();

        //получаем listы с электростанциями по каждому типу(учитывая условие на дату)
        var listAtomicPowerPlant = getListByPowerPlants(TypePowerPlant.ATOMIC);
        var listHydroPowerPlant = getListByPowerPlants(TypePowerPlant.HYDRO);
        var listSolarPowerPlant = getListByPowerPlants(TypePowerPlant.SOLAR);

        //считаем avg по каждому list (по каждому типу электростанций)
        var averageByAtomic = getAverageByPowerPlantType(listAtomicPowerPlant);
        var averageByHydro = getAverageByPowerPlantType(listHydroPowerPlant);
        var averageBySolar = getAverageByPowerPlantType(listSolarPowerPlant);

        result.add(Pair.of(TypePowerPlant.ATOMIC, averageByAtomic));
        result.add(Pair.of(TypePowerPlant.HYDRO, averageByHydro));
        result.add(Pair.of(TypePowerPlant.SOLAR, averageBySolar));

        return result;
    }


    /*Суммарная производимая мощность за последний год*/
    public int getSummaryProductionCapacityLastYear() {
        return powerPlants.stream()
                .filter(powerPlant -> dateIsCorrectMonth(powerPlant.getDate(), TWELVE_MONTH))
                .mapToInt(PowerPlant::getProductionCapacity)
                .sum();
    }

    private double getAverageByPowerPlantType(List<PowerPlant> powerPlants) {
        return powerPlants.stream()
                .mapToInt(PowerPlant::getProductionCapacity)
                .summaryStatistics()
                .getAverage();
    }

    private List<PowerPlant> getListByPowerPlants(TypePowerPlant typePowerPlant) {
        return powerPlants.stream()
                .filter(powerPlant -> dateIsCorrectMonth(powerPlant.getDate(), THREE_MONTH))
                .filter(powerPlant -> powerPlant.getTypePowerPlant().equals(typePowerPlant))
                .toList();
    }
}
