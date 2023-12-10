package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class MyFileReader {

    private static final Logger logger = LogManager.getLogger(MyFileReader.class);

    public List<Order> readOrdersFromFile(Path path) {
        logger.info("Начало чтения заказов из файла");
        List<Order> orders;

        try (Stream<String> streamFromFiles = Files.lines(path)) {
            orders = streamFromFiles
                    .map(line -> line.split(";"))
                    .map(parts -> {
                        LocalDate date = LocalDate.parse(parts[0]);
                        String name = parts[1];
                        double weight = Double.parseDouble(parts[2]);
                        BigDecimal cost = new BigDecimal(parts[3]);

                        return new Order(date, name, weight, cost);
                    })
                    .toList();
        } catch (IOException e) {
            logger.error("Ошибка при чтении файла!\n" + e.getMessage());
            throw new RuntimeException(e);
        }

        logger.info("Заказы успешно прочитаны");
        return orders;
    }
}
