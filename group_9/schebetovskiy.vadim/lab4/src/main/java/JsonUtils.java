import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import entities.PreparedDrinkAccounting;
import localdatetime.LocalDateTimeDeserializer;
import localdatetime.LocalDateTimeSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtils {
    private final Logger logger = Logger.getLogger(JsonUtils.class.getName());

    public void fillJsonFile(Collection<PreparedDrinkAccounting> accountings, Path filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .create();
        String jsonString = gson.toJson(accountings);
        try (FileWriter writer = new FileWriter(filePath.toFile())) {
            logger.log(Level.INFO, "File writing begin");
            writer.write(jsonString);
            logger.log(Level.INFO, "File written");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        logger.log(Level.INFO, "File close");
    }

    public List<PreparedDrinkAccounting> readJsonFile(Path filePath) {
        File fileJson = filePath.toFile();
        Gson gson = new GsonBuilder().setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .create();
        Type collectionType = new TypeToken<Collection<PreparedDrinkAccounting>>() {
        }.getType();
        try {
            JsonReader reader = new JsonReader(new FileReader(fileJson.getPath()));
            logger.log(Level.INFO, "File reading begin");
            List<PreparedDrinkAccounting> accountings = gson.fromJson(reader, collectionType);
            logger.log(Level.INFO, "File read");
            return accountings;
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE, "File Not Found");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
