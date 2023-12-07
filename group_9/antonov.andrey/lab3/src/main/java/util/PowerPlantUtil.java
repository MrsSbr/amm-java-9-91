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
            PowerPlant.of(LocalDate.of(2022, 10, 4), TypePowerPlant.ATOMIC, 13),
            PowerPlant.of(LocalDate.of(2023, 1, 5), TypePowerPlant.HYDRO, 56),
            PowerPlant.of(LocalDate.of(2022, 1, 6), TypePowerPlant.SOLAR, 100),
            PowerPlant.of(LocalDate.of(2018, 3, 7), TypePowerPlant.ATOMIC, 91),
            PowerPlant.of(LocalDate.of(2023, 3, 8), TypePowerPlant.HYDRO, 45),
            PowerPlant.of(LocalDate.of(2017, 5, 9), TypePowerPlant.SOLAR, 55),
            PowerPlant.of(LocalDate.of(2015, 6, 10), TypePowerPlant.ATOMIC, 100),
            PowerPlant.of(LocalDate.of(2023, 6, 11), TypePowerPlant.HYDRO, 125),
            PowerPlant.of(LocalDate.of(2023, 9, 16), TypePowerPlant.ATOMIC, 125),
            PowerPlant.of(LocalDate.of(2023, 10, 14), TypePowerPlant.HYDRO, 125),
            PowerPlant.of(LocalDate.of(2023, 9, 13), TypePowerPlant.SOLAR, 125),
            PowerPlant.of(LocalDate.of(2023, 10, 15), TypePowerPlant.SOLAR, 125),
            PowerPlant.of(LocalDate.of(2023, 6, 17), TypePowerPlant.HYDRO, 110),
            PowerPlant.of(LocalDate.of(2023, 9, 17), TypePowerPlant.ATOMIC, 105),
            PowerPlant.of(LocalDate.of(2023, 10, 18), TypePowerPlant.HYDRO, 55),
            PowerPlant.of(LocalDate.of(2023, 9, 19), TypePowerPlant.SOLAR, 53),
            PowerPlant.of(LocalDate.of(2023, 10, 20), TypePowerPlant.SOLAR, 121)
    );

    public static PowerPlant getRandomPowerPlant() {
        return POWER_PLANTS.get(RandomUtil.getNext(POWER_PLANTS.size()));
    }
}
