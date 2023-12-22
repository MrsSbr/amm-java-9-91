package ru.nikitadenisov.deals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DealReader {
    private static final Logger logger = Logger.getLogger(DealReader.class.getSimpleName());

    public static List<Deal> read(Path filePath) throws IOException {
        logger.info("Чтение файла.");

        List<String> lines = Files.readAllLines(filePath);

        return lines.stream()
                .map(DealReader::readDeal)
                .collect(Collectors.toList());
    }

    private static Deal readDeal(String line) throws NumberFormatException, DateTimeParseException {
        String[] parts = line.split(";");
        String manager = parts[0];
        String buyer = parts[1];
        double dealAmount = Double.parseDouble(parts[2]);
        LocalDate serviceDate = LocalDate.parse(parts[3]);

        return new Deal(manager, buyer, dealAmount, serviceDate);
    }
}
