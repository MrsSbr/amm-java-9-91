package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class MyFileReader {
    public List<String> readOrdersFromFile(Path path) {
        try (Stream<String> streamFromFiles = Files.lines(path)) {
            return streamFromFiles.toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
