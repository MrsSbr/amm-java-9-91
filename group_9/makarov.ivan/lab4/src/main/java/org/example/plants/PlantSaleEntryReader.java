package org.example.plants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PlantSaleEntryReader {
    private static final Logger logger = Logger.getLogger(PlantSaleEntryReader.class.getSimpleName());

    public static List<PlantSaleEntry> read(Path filePath) throws IOException {
        logger.info("Чтение файла.");

        List<String> lines = Files.readAllLines(filePath);

        return lines.stream()
                .map(PlantSaleEntryReader::readPlantSaleEntry)
                .collect(Collectors.toList());

    }

    private static PlantSaleEntry readPlantSaleEntry(String line) {
        String[] parts = line.split(";");


        String plantName = parts[0];
        String plantType = parts[1];
        String potSize = parts[2];
        double price = Double.parseDouble(parts[3]);
        LocalDate saleDate = LocalDate.parse(parts[4]);

        return new PlantSaleEntry(plantName, plantType, potSize, price, saleDate.toString());
    }
}