package org.bouquets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.bouquets.localdate.LocalDateDeserializer;
import org.bouquets.order.BouquetType;
import org.bouquets.order.FlowersType;
import org.bouquets.order.Order;
import org.bouquets.order.ReceivingType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


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
    private final JsonUtils utils = new JsonUtils();
    private static File file = null;
    @Test
    void createJsonFile() {
        List<Order> expectedOrders = List.of (new Order (LocalDate.of(2023,1,15),
                                                         BouquetType.JUBILEE,
                                                         List.of(FlowersType.ASTER, FlowersType.CHAMOMILE,FlowersType.ROSE,
                                                              FlowersType.LILY,FlowersType.ROSE,FlowersType.PEONY,FlowersType.ASTER),
                                                         800,
                                                         ReceivingType.DELIVERY),
                                              new Order (LocalDate.of(2023,4,13),
                                                         BouquetType.WEDDING,
                                                         List.of(FlowersType.PEONY, FlowersType.CHAMOMILE, FlowersType.ROSE,
                                                              FlowersType.CHAMOMILE,FlowersType.ROSE,FlowersType.CHAMOMILE,
                                                              FlowersType.CHAMOMILE,FlowersType.PEONY,FlowersType.ROSE,
                                                              FlowersType.PEONY,FlowersType.LILY),
                                                         6000,
                                                         ReceivingType.DELIVERY));
        try {
            file = File.createTempFile("createFileTest",".json");
            utils.createJsonFile(expectedOrders, file.toPath());
            Gson gson = new GsonBuilder().setPrettyPrinting()
                                         .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
                                         .create();
            Type collectionType = new TypeToken<Collection<Order>>(){}.getType();
            try (JsonReader reader = new JsonReader(new FileReader(file.getPath()))) {
                List<Order> orders = gson.fromJson(reader, collectionType);
                assertEquals(expectedOrders, orders);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
     void readJsonFile() {
        List<Order> expectedOrders = List.of(new Order(LocalDate.of(2023,11,17),
                                                       BouquetType.NEW_YEAR,
                                                       List.of(FlowersType.ROSE, FlowersType.HYDRANGEA, FlowersType.GYPSOFHILA,
                                                               FlowersType.GLADIOLUS, FlowersType.MIMOSA,
                                                               FlowersType.LEVENDER, FlowersType.ASTER),
                                                       4208,
                                                       ReceivingType.DELIVERY),
                                              new Order(LocalDate.of(2022,11,3),
                                                        BouquetType.JUBILEE,
                                                        List.of(FlowersType.GYPSOFHILA, FlowersType.GLADIOLUS, FlowersType.LEVENDER,
                                                                FlowersType.ROSE, FlowersType.GLADIOLUS, FlowersType.PEONY,
                                                                FlowersType.HYDRANGEA, FlowersType.GYPSOFHILA),
                                                        4491,
                                                        ReceivingType.MANUALLY));
        try {
            Path filePath = Paths.get(Thread.currentThread()
                                 .getContextClassLoader()
                                 .getResource("readFileTest.json")
                                 .toURI());
            List<Order> orders = utils.readJsonFile(filePath);
            assertEquals(expectedOrders,orders);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterAll
     static void deleteFile() {
        if (file != null) {
            file.delete();
        }
     }
}