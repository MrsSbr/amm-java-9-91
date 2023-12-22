package org.example;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileHelperTest {

    @Test
    public void testReadAllLines() throws IOException {
        // Replace "test_file.txt" with the path to your test file
        Path filePath = Path.of("test_file.txt");

        List<String> expectedLines = Arrays.asList(
                "Line 1",
                "Line 2",
                "Line 3"
        );

        // Writing test content to the file
        Files.write(filePath, expectedLines);

        List<String> actualLines = FileHelper.readAllLines(filePath);

        assertEquals(expectedLines, actualLines);
    }

    @Test
    public void testReadAllLinesWithNonexistentFile() {
        // Replace "nonexistent_file.txt" with a path that doesn't exist
        Path filePath = Path.of("nonexistent_file.txt");

        assertThrows(IOException.class, () -> FileHelper.readAllLines(filePath));
    }

}
