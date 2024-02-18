package ru.denismandrusenko;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TempleRecordReader {
    private static final Logger logger = Logger.getLogger(TempleRecordReader.class.getSimpleName());

    public static List<TempleRecord> read(Path filePath) throws IOException {
        logger.info("Чтение файла.");

        List<String> lines = Files.readAllLines(filePath);

        return lines.stream()
                .map(TempleRecordReader::readTempleRecord)
                .collect(Collectors.toList());
    }

    private static TempleRecord readTempleRecord(String line) throws NumberFormatException, DateTimeParseException {
        String[] parts = line.split(";");
        String temple = parts[0].trim();
        String god = parts[1].trim();
        String donor = parts[2].trim();
        int donationAmount = Integer.parseInt(parts[3].trim());

        return new TempleRecord(temple, god, donor, donationAmount);
    }
}