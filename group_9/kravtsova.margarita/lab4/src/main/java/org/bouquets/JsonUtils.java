package org.bouquets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.bouquets.localdate.LocalDateDeserializer;
import org.bouquets.localdate.LocalDateSerializer;
import org.bouquets.order.Order;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonUtils {
    private final Logger logger = Logger.getLogger(JsonUtils.class.getName());
    public File createJsonFile(Collection<Order> orders, Path filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting()
                                     .registerTypeAdapter(LocalDate.class, new LocalDateSerializer())
                                     .create();
        String jsonString = gson.toJson(orders);
        File fileJson = filePath.toFile();
        try (FileWriter writer = new FileWriter(fileJson)) {
            logger.log(Level.INFO, "File writing begin");
            writer.write(jsonString);
            logger.log(Level.INFO, "File written");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        logger.log(Level.INFO,"File close");
        return fileJson;
    }
    public List<Order> readJsonFile(Path filePath) {
        File fileJson = filePath.toFile();
        Gson gson = new GsonBuilder().setPrettyPrinting()
                                     .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                                     .create();
        Type collectionType = new TypeToken<Collection<Order>>(){}.getType();
        try {
            JsonReader reader = new JsonReader(new FileReader(fileJson.getPath()));
            logger.log(Level.INFO,"File reading begin");
            List<Order> orders = gson.fromJson(reader, collectionType);
            logger.log(Level.INFO,"File read");
            return orders;
        } catch (FileNotFoundException ex) {
            logger.log(Level.SEVERE,"File Not Found");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
