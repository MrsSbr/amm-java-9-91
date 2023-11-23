package entity;

import lombok.Value;

@Value(staticConstructor = "of")
public class ExecutionStatisticBySolverService {
    long timeCreation;
    long timeSearchSpecialPowerPlantType;
    long timeSearchProductionCapacityByPowerPlantType;
    long timeSearchProductionCapacityLastYear;
}
