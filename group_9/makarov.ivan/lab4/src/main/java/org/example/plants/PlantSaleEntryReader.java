package org.example.plants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlantSaleEntryReader {
    private static final Logger LOGGER = Logger.getLogger(PlantSaleEntryReader.class.getSimpleName());

    public static List<PlantSaleEntry> read(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath)) {
            return lines.map(PlantSaleEntryReader::readPlantSaleEntry)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.severe("Ошибка чтения файла: " + e.getMessage());
            throw e;
        }
    }

    private static PlantSaleEntry readPlantSaleEntry(String line) {
        String[] parts = line.split(";");

        if (parts.length == 5) {
            try {
                String plantName = parts[0];
                String plantType = parts[1];
                String potSize = parts[2];
                double price = Double.parseDouble(parts[3]);
                LocalDate saleDate = LocalDate.parse(parts[4]);

                return new PlantSaleEntry(plantName, plantType, potSize, price, saleDate.toString());
            } catch (NumberFormatException | DateTimeException e) {
                LOGGER.warning("Ошибка при парсинге данных: " + e.getMessage());
                throw new IllegalArgumentException();
            }
        } else {
            LOGGER.warning("Неверный формат данных: " + line);
            throw new IllegalArgumentException();
        }
    }
}