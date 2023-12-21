package ru.nikitadenisov.deals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DealReader {
    private static final Logger LOGGER = Logger.getLogger(DealReader.class.getSimpleName());

    public static List<Deal> read(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath)) {
            return lines.map(DealReader::readDeal)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.severe("Ошибка чтения файла: " + e.getMessage());

            return null;
        }
    }

    private static Deal readDeal(String line) {
        String[] parts = line.split(";");

        if (parts.length == 4) {
            String manager = parts[0];
            String buyer = parts[1];
            double dealAmount = Double.parseDouble(parts[2]);
            LocalDate serviceDate = LocalDate.parse(parts[3]);

            return new Deal(manager, buyer, dealAmount, serviceDate);
        } else {
            LOGGER.warning("Неверный формат данных: " + line);

            return null;
        }
    }
}
