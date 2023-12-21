import coffee.CoffeeRecord;
import coffee.CoffeeSort;
import coffee.InvalidCoffeeSortFormatException;
import coffee.InvalidProcessingTypeFormatException;
import coffee.ProcessingType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class CoffeeRecordReader {
    private final InputStream inputStream;

    private static final Logger logger = LogManager.getLogger();

    public CoffeeRecordReader(InputStream inputStream) {
        this.inputStream = inputStream;

    }

    public List<CoffeeRecord> read() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader.lines()
                    .map(this::parseCoffeeRecord)
                    .filter((Objects::nonNull))
                    .toList();
        }
    }

    private CoffeeRecord parseCoffeeRecord(String string) {
        String[] parsedStrings = string.split(";");
        if (parsedStrings.length == 5) {
            try {
                CoffeeSort sort = CoffeeSort.fromValue(parsedStrings[0]);
                String country = parsedStrings[1];
                String farm = parsedStrings[2];
                ProcessingType processingType = ProcessingType.fromValue(parsedStrings[3]);
                double height = Double.parseDouble(parsedStrings[4]);
                return new CoffeeRecord(sort, country, farm, processingType, height);
            } catch (InvalidProcessingTypeFormatException | InvalidCoffeeSortFormatException e) {
                logger.error(e.getMessage());
                return null;
            }
        }
        logger.error("Неверный формат строки.");
        return null;
    }
}
