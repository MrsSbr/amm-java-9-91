import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import entities.Drinks;
import entities.PreparedDrinkAccounting;
import localdatetime.LocalDateTimeDeserializer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonUtilsTest {
    private static final JsonUtils UTILS = new JsonUtils();
    private static File file = null;

    private static final List<PreparedDrinkAccounting> EXPECTED_ACCOUNTINGS = List.of(
            new PreparedDrinkAccounting(Drinks.AMERICANO.getName(),
                    LocalDateTime.of(LocalDate.of(2023, 11, 13), LocalTime.of(14, 40, 50)),
                    40,
                    Drinks.AMERICANO.getPrice()),
            new PreparedDrinkAccounting(Drinks.AMERICANO.getName(),
                    LocalDateTime.of(LocalDate.of(2023, 11, 13), LocalTime.of(13, 40, 50)),
                    34,
                    Drinks.AMERICANO.getPrice()),
            new PreparedDrinkAccounting(Drinks.AMERICANO.getName(),
                    LocalDateTime.of(LocalDate.of(2023, 11, 13), LocalTime.of(15, 40, 50)),
                    56,
                    Drinks.AMERICANO.getPrice()),
            new PreparedDrinkAccounting(Drinks.AMERICANO.getName(),
                    LocalDateTime.of(LocalDate.of(2023, 11, 13), LocalTime.of(16, 40, 50)),
                    34,
                    Drinks.AMERICANO.getPrice())
    );

    @Test
    void createJsonFileTest() {
        try {
            file = File.createTempFile("createFileTest", ".json");
            UTILS.createJsonFile(EXPECTED_ACCOUNTINGS, file.toPath());
            Gson gson = new GsonBuilder().setPrettyPrinting()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTimeDeserializer())
                    .create();
            Type collectionType = new TypeToken<Collection<PreparedDrinkAccounting>>() {
            }.getType();
            try (JsonReader reader = new JsonReader(new FileReader(file.getPath()))) {
                List<PreparedDrinkAccounting> accountings = gson.fromJson(reader, collectionType);
                assertEquals(EXPECTED_ACCOUNTINGS, accountings);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void readJsonFileTest() {
        try {
            Path filePath = Paths.get(Thread.currentThread()
                    .getContextClassLoader()
                    .getResource("readFileTest.json")
                    .toURI());
            final var accountings = UTILS.readJsonFile(filePath);
            assertEquals(EXPECTED_ACCOUNTINGS, accountings);
        } catch (URISyntaxException ex) {
            throw new RuntimeException(ex);
        }
    }

    @AfterAll
    static void deleteFile() {
        if (file != null) {
            file.delete();
        }
    }
}
