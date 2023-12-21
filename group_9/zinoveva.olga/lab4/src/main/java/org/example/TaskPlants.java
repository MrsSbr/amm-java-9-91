package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class TaskPlants {

    public static final Logger LOGGER = LogManager.getLogger(TaskPlants.class);
    private static final Path PATH = Path.of("plants.txt");

    public static void main(String[] args) {
        LOGGER.info("Запуск выполнения программы");
        FileReader fileReader = new FileReader();
        List<DataPlant> diaryWithDataPlants = fileReader.readPlantsFromFile(PATH);
        ImplementationTasksWithPlants itwp = new ImplementationTasksWithPlants();
        int checkbox = 1;
        while (checkbox != 4) {
            WorkingWhithUser.menuInstructions();
            checkbox = WorkingWhithUser.inputIntInRange(1, 4);
            switch (checkbox) {
                case 1: {
                    LOGGER.info("Вызов averagePurityOfIrrigation");
                    Map<String, Double> result = itwp.averagePurityOfIrrigation(diaryWithDataPlants);
                    result.forEach((plant, avgIrrigation) -> System.out.println("Цветок: " + plant + " -> " + avgIrrigation + " л"));
                }
                case 2: {
                    LOGGER.info("Вызов findNamesPlantByTypeFertilizer");
                    Map<String, HashSet<String>> result = itwp.findNamesPlantByTypeFertilizer(diaryWithDataPlants);
                    result.forEach((fertilizer, plants) -> System.out.println("Удобрение: " + fertilizer + " -> " + plants.toString()));
                }
                case 3: {
                    LOGGER.info("Вызов findPlantWithMaxWater");
                    String result = itwp.findPlantWithMaxWater(diaryWithDataPlants);
                    System.out.println("Цветок, в который вылили больше всего воды: " + result);
                }
                default:
                    System.out.println("Конец работы");
            }
        }
        LOGGER.info("Завершение выполнения программы");
    }
}
