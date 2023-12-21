import org.example.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTest {
    private static final Path PATH = Path.of("zinoveva.olga/lab4/src/main/resources/plants.txt");
    private final FileReader fileReader = new FileReader();

    @Test
    public void goodTestFileOpen() throws IOException {
        Path path = Files.createTempFile("test_plant", ".txt");
        assertDoesNotThrow(() -> fileReader.readPlantsFromFile(path));
    }

    @Test
    public void badTestFileOpen() {
        assertThrows(RuntimeException.class, () -> fileReader.readPlantsFromFile(PATH));
    }
}