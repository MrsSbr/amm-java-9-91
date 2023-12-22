import org.example.plants.PlantSaleEntry;
import org.example.plants.PlantSaleEntryReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;



public class PlantSaleReaderTest {
    private static final Path ERROR_DATA_FILE = Path.of("src", "test", "java", "invalid_plant_sales.txt");
    private static final Path VALID_DATA_FILE = Path.of("src", "test", "java", "plants.txt");

    @Test
    void readFromValidFile() throws IOException {
        List<PlantSaleEntry> plantSaleEntries = PlantSaleEntryReader.read(VALID_DATA_FILE);

        assertNotNull(plantSaleEntries);
        assertFalse(plantSaleEntries.isEmpty());
        assertFalse(plantSaleEntries.contains(null));
    }

    @Test
    void readFromInvalidFile() {
        assertThrows(Exception.class, () ->  PlantSaleEntryReader.read(ERROR_DATA_FILE));
    }


}
