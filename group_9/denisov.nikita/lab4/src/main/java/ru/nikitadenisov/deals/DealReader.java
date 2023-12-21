package ru.nikitadenisov.deals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DealReader {
    private static final Logger LOGGER = Logger.getLogger(DealReader.class.getSimpleName());

    public static List<Deal> read(Path filePath) throws IOException {
        try (Stream<String> lines = Files.lines(filePath)) {
            return lines.map(DealReader::readDeal)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.severe("Ошибка чтения файла: " + e.getMessage());

            throw e;
        }
    }

    private static Deal readDeal(String line) {
        String[] parts = line.split(";");

        if (parts.length == 4) {
            try {
                String manager = parts[0];
                String buyer = parts[1];
                double dealAmount = Double.parseDouble(parts[2]);
                LocalDate serviceDate = LocalDate.parse(parts[3]);

                return new Deal(manager, buyer, dealAmount, serviceDate);
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
