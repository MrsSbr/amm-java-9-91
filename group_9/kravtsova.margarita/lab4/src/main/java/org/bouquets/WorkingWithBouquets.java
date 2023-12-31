package org.bouquets;

import org.bouquets.order.Order;
import org.bouquets.order.OrderAnalysis;
import org.bouquets.order.OrderFactory;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithBouquets {
    private static final JsonUtils utils = new JsonUtils();
    public static void main(String[] args) {
        OrderFactory orderFactory = new OrderFactory();
        File fileJson = createJsonFile(Stream.generate(orderFactory::createOrder)
                                             .limit(100)
                                             .collect(Collectors.toList()), "orders.json");
        List<Order> orders = readJsonFile(fileJson.getName());
        System.out.println(orders + "\n");
        OrderAnalysis orderAnalysis = new OrderAnalysis();
        System.out.println("Месяцы, в которые заказывают букеты, состоящие из наиболее разнообразных цветов:\n" +
                 orderAnalysis.monthMostDiverseFlowers(orders) + "\n");
        System.out.println("Заработок флориста по каждому типу букетов за последний год\n" +
                 orderAnalysis.floristEarnings(orders) + "\n");
        System.out.println("Способы получения цветов:\n" + orderAnalysis.receivingFlowers(orders) + "\n");
    }
    private static List<Order> readJsonFile(String fileName) {
        try {
            Path filePath = Paths.get(Thread.currentThread()
                                            .getContextClassLoader()
                                            .getResource(fileName)
                                            .toURI());
            return utils.readJsonFile(filePath);
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        } catch (URISyntaxException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    private static File createJsonFile(List<Order> orders, String fileName) {
        try {
            Path filePath = Paths.get(Thread.currentThread()
                                            .getContextClassLoader()
                                            .getResource(fileName)
                                            .toURI());
            return utils.createJsonFile(orders, filePath);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}