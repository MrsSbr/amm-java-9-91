package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileReader {
    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

    public List<DataPlant> readPlantsFromFile(Path path) {
        LOGGER.info("Чтение из файла");
        List<DataPlant> plants;

        try (Stream<String> fileDataStream = Files.lines(path)) {
            plants = (List<DataPlant>) fileDataStream
                    .map(x -> x.split(";"))
                    .map(data -> {
                        LocalDate date = LocalDate.parse(data[0]);
                        String nameFlower = data[1];
                        double amountOfWatering = Double.parseDouble(data[2]);
                        String brandOfFertilizer = data[3];
                        return new DataPlant(date, nameFlower, amountOfWatering, brandOfFertilizer);
                    })
                    .toList();
        } catch (IOException e) {
            LOGGER.error("Неудачная попытка чтения файла\n" + e.getMessage());
            throw new RuntimeException(e);
        }
        LOGGER.info("Чтение успешно завершено. Все данные получены");
        return plants;
    }
}