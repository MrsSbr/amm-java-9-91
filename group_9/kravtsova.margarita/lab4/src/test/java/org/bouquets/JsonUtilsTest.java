package org.bouquets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.bouquets.localdate.LocalDateDeserializer;
import org.bouquets.order.BouquetType;
import org.bouquets.order.Order;
import org.bouquets.order.ReceivingType;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilsTest {
    @Test
    void createJsonFile() {
        List<Order> expectedOrders = List.of (new Order (LocalDate.of(2023,1,15),
                                                      BouquetType.JUBILEE,
                                                      List.of("Астра", "Ромашка","Роза","Лилия","Роза","Пион","Астра"),
                                                      800,
                                                      ReceivingType.DELIVERY),
                                              new Order (LocalDate.of(2023,4,13),
                                                      BouquetType.WEDDING,
                                                      List.of("Пион", "Ромашка", "Роза","Ромашка","Роза","Ромашка","Ромашка","Пион","Роза","Пион","Лилия"),
                                                      6000,
                                                      ReceivingType.DELIVERY));
        File newFile = null;
        try {
            newFile = File.createTempFile("createFileTest",".json");
            JsonUtils.createJsonFile(expectedOrders, newFile.toPath());
            Gson gson = new GsonBuilder().setPrettyPrinting()
                                         .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                                         .create();
            Type collectionType = new TypeToken<Collection<Order>>(){}.getType();
            try (JsonReader reader = new JsonReader(new FileReader(newFile.getPath()))){
                List<Order> orders = gson.fromJson(reader, collectionType);
                assertEquals(expectedOrders, orders);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            if (newFile != null) {
                newFile.delete();
            }
        }
    }
    @Test
    void readJsonFile() {
        List<Order> expectedOrders = List.of(new Order( LocalDate.of(2023,11,17),
                                                        BouquetType.NEW_YEAR,
                                                        List.of("Роза",
                                                                "Гортензия",
                                                                "Гипсофила",
                                                                "Гладиолус",
                                                                "Мимоза",
                                                                "Лаванда",
                                                                "Астра"),
                                                        4208,
                                                        ReceivingType.DELIVERY),
                                            new Order(LocalDate.of(2022,11,3),
                                                      BouquetType.JUBILEE,
                                                      List.of("Гипсофила",
                                                              "Гладиолус",
                                                              "Лаванда",
                                                              "Роза",
                                                              "Гладиолус",
                                                              "Пион",
                                                              "Гортензия",
                                                              "Гипсофила"),
                                                     4491,
                                                      ReceivingType.MANUALLY));
        try {
            Path filePath = Paths.get(Thread.currentThread()
                                 .getContextClassLoader()
                                 .getResource("readFileTest.json")
                                 .toURI());
            List<Order> orders = JsonUtils.readJsonFile(filePath);
            assertEquals(expectedOrders,orders);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}