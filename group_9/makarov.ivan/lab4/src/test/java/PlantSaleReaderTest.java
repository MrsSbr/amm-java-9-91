import org.example.plants.PlantSaleEntryReader;
import org.example.plants.PlantSaleEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlantSaleReaderTest {
    private static final Path ERROR_DATA_FILE = Path.of("src", "test", "java",  "invalid_plant_sales.txt");

    @Test
    void readFromInvalidFile() {
        assertThrows(IllegalArgumentException.class, () -> PlantSaleEntryReader.read(ERROR_DATA_FILE));
    }



}
