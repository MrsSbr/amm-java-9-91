package edu.deals;

import edu.deals.exceptions.DealParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public final class DealsParser {
    private static final String DELIMITER = ";";

    private DealsParser() {
    }

    public static List<Deal> parseFile(Path filePath) throws IOException, DealParseException {
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            return reader.lines()
                    .map(DealsParser::parseDeal)
                    .toList();
        }
    }

    private static Deal parseDeal(String line) throws DealParseException {
        try {
            String[] parts = line.split(DELIMITER);
            return new Deal(parts[0], parts[1], Double.parseDouble(parts[2]), LocalDate.parse(parts[3]));
        } catch (Exception e) {
            throw new DealParseException("The line cannot be parsed: \"" + line + "\"", line, e);
        }
    }
}
