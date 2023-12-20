package moonshine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class MoonshineReader {
    private final Logger logger = Logger.getLogger(MoonshineReader.class.getName());

    public List<Moonshine> readMoonshines(Path path) {
        logger.log(Level.INFO, "Чтение файла " + path);
        List<Moonshine> moonshines;

        try (Stream<String> moonshineStrings = Files.lines(path)) {
            moonshines = moonshineStrings
                    .map(line -> line.split(";"))
                    .map(values -> new Moonshine(
                            LocalDate.parse(values[0].trim()),
                            values[1].trim(),
                            parseIngredients(values[2]),
                            Double.parseDouble(values[3].trim()),
                            Double.parseDouble(values[4].trim())
                    ))
                    .toList();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка при чтении файла "
                    + path + ": " + e.getMessage());
            throw new RuntimeException(e);
        }

        logger.log(Level.FINE, "Файл " + path + " прочитан");
        return moonshines;
    }

    private List<Ingredient> parseIngredients(String ingredientsString) {
        return Arrays.stream(ingredientsString.trim().split(","))
                .map(ingredient -> Ingredient.valueOf(ingredient.trim()))
                .toList();
    }
}
