package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ImplementationTasksWithPlants {
    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

    //Для каждого цветка найти среднюю чистоту полива.
    public Map<String, Double> averagePurityOfIrrigation(List<DataPlant> listDataPlants) {
        LOGGER.info("Выполнение averagePurityOfIrrigation");
        Map<String, Double> pairPlantIrrigation = new HashMap<>();
        Map<String, Integer> pairPlantCount = new HashMap<>();
        listDataPlants.forEach(x -> {
            if (pairPlantIrrigation.containsKey(x.nameFlower())) {
                pairPlantCount.put(x.nameFlower(), pairPlantCount.get(x.nameFlower()) + 1);
                pairPlantIrrigation.put(x.nameFlower(), pairPlantIrrigation.get(x.nameFlower()) + x.amountOfWatering());
            } else {
                pairPlantIrrigation.put(x.nameFlower(), x.amountOfWatering());
                pairPlantCount.put(x.nameFlower(), 1);
            }
        });
        pairPlantIrrigation.forEach((key, value) -> pairPlantIrrigation.put(key, value / pairPlantCount.get(key)));
        return pairPlantIrrigation;
    }

    //Для каждого удобрения найти цветы, им удобренные.
    public Map<String, HashSet<String>> findNamesPlantByTypeFertilizer(List<DataPlant> listDataPlants) {
        LOGGER.info("Выполнение findNamesPlantByTypeFertilizer");
        Map<String, HashSet<String>> pairFertilizerListPlants = new HashMap<>();
        listDataPlants.stream()
                .filter(DataPlant::isFertilized)
                .forEach(x -> {
                    HashSet<String> listPlants = new HashSet<>();
                    if (pairFertilizerListPlants.containsKey(x.brandOfFertilizer())) {
                        listPlants = pairFertilizerListPlants.get(x.brandOfFertilizer());
                    }
                    listPlants.add(x.nameFlower());
                    pairFertilizerListPlants.put(x.brandOfFertilizer(), listPlants);
                });
        return pairFertilizerListPlants;
    }

    //Найти цветок, в который вылили больше всего воды.
    public String findPlantWithMaxWater(List<DataPlant> listDataPlants) {
        LOGGER.info("Выполнение findPlantWithMaxWater");
        Map<String, Double> pairPlantAllWater = new HashMap<>();
        listDataPlants.forEach(x -> {
            if (pairPlantAllWater.containsKey(x.nameFlower())) {
                double value = pairPlantAllWater.get(x.nameFlower()) + x.amountOfWatering();
                pairPlantAllWater.put(x.nameFlower(), value);
            } else {
                pairPlantAllWater.put(x.nameFlower(), x.amountOfWatering());
            }
        });
        return pairPlantAllWater.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(() -> new NoSuchElementException("Нет даннфх о поливе"))
                .getKey();
    }

}
