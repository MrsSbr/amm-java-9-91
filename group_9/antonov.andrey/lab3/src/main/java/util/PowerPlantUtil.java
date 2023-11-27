package util;

import entity.PowerPlant;
import entity.TypePowerPlant;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.List;

@UtilityClass
public class PowerPlantUtil {
    private static final List<PowerPlant> POWER_PLANTS = List.of(
            PowerPlant.of(LocalDate.of(2010, 10, 5), TypePowerPlant.HYDRO, 25),
            PowerPlant.of(LocalDate.of(2010, 5, 1), TypePowerPlant.ATOMIC, 25),
            PowerPlant.of(LocalDate.of(2023, 6, 2), TypePowerPlant.HYDRO, 55),
            PowerPlant.of(LocalDate.of(2015, 4, 3), TypePowerPlant.SOLAR, 14),
            PowerPlant.of(LocalDate.of(2022, 10, 4), TypePowerPlant.ATOMIC, 135),
            PowerPlant.of(LocalDate.of(2023, 1, 5), TypePowerPlant.HYDRO, 55),
            PowerPlant.of(LocalDate.of(2022, 1, 6), TypePowerPlant.SOLAR, 100),
            PowerPlant.of(LocalDate.of(2018, 3, 7), TypePowerPlant.ATOMIC, 95),
            PowerPlant.of(LocalDate.of(2023, 3, 8), TypePowerPlant.HYDRO, 45),
            PowerPlant.of(LocalDate.of(2017, 5, 9), TypePowerPlant.SOLAR, 55),
            PowerPlant.of(LocalDate.of(2015, 6, 10), TypePowerPlant.ATOMIC, 100),
            PowerPlant.of(LocalDate.of(2023, 6, 11), TypePowerPlant.HYDRO, 125)
    );

    public static PowerPlant getRandomPowerPlant() {
        return POWER_PLANTS.get(RandomUtil.getNext(POWER_PLANTS.size()));
    }
}
