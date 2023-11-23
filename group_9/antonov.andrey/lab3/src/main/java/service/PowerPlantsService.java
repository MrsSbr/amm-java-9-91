package service;

import entity.PowerPlant;
import util.GenerateRandomPowerPlantsUtil;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PowerPlantsService {
    private final int count;

    public PowerPlantsService(int count) {
        this.count = count;
    }

    public List<PowerPlant> getRandomPowerPlantsList() {
        return Stream.generate(GenerateRandomPowerPlantsUtil::getPowerPlant)
                .limit(count)
                .collect(toList());
    }
}
