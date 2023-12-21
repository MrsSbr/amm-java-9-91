package deals;

import org.junit.jupiter.api.Test;
import ru.nikitadenisov.deals.DealReader;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Path;

public class DealReaderTest {
    private static final Path ERROR_DATA_FILE = Path.of("src", "test", "resources", "error.txt");
    private static final Path VALID_DATA_FILE = Path.of("src", "test", "resources", "deals.txt");

    @Test
    void readFromInvalidFile() {
        assertThrows(Exception.class, () -> DealReader.read(ERROR_DATA_FILE));
    }
}
