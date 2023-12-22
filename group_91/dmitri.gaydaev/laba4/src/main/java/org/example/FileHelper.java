package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileHelper {
    public static List<String> readAllLines(Path filePath) throws IOException {
        return Files.readAllLines(filePath);
    }
}