package entity;

import lombok.Value;

@Value(staticConstructor = "of")
public class StatisticBySolverService {
    double avgTimeSearchSpecialPowerPlantType;
    double avgTimeSearchProductionCapacityByPowerPlantType;
    double avgTimeSearchProductionCapacityLastYear;
}
