package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class LogReader {
    private static final Logger logger = LogManager.getLogger(LogReader.class);

    public List<Log> read(String fileName) throws URISyntaxException {
        logger.info("Начало чтения логов из файла");

        URI uri = ClassLoader.getSystemResource(fileName).toURI();
        List<Log> logs;

        try(Stream<String> stream = Files.lines(Path.of(uri))) {
            logs = stream
                    .map(log -> log.split(";"))
                    .map(parts -> {
                        LocalDate date = LocalDate.parse(parts[0]);
                        String resource = parts[1];
                        String ip = parts[2];
                        HttpStatusCode code = HttpStatusCode.valueOf(Integer.parseInt(parts[3]));

                        return new Log(date, resource, ip, code);
                    })
                    .toList();
        } catch (IOException exception) {
            logger.error("Ошибка при чтении файла!\n" + exception.getMessage());
            throw new RuntimeException(exception);
        }

        logger.info("Чтение логов завершено");
        return logs;
    }
}