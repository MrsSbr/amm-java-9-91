package entity;

import lombok.Value;

import java.time.LocalDate;

@Value(staticConstructor = "of")
public class PowerPlant {
    LocalDate date;
    TypePowerPlant typePowerPlant;
    int productionCapacity;
}
