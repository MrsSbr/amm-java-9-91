package deals;

import org.junit.jupiter.api.Test;
import ru.nikitadenisov.deals.Deal;
import ru.nikitadenisov.deals.DealReader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DealReaderTest {
    private static final Path ERROR_DATA_FILE = Path.of("src", "test", "java", "resources", "error.txt");
    private static final Path VALID_DATA_FILE = Path.of("src", "test", "java", "resources", "deals.txt");

    @Test
    void readFromInvalidFile() {
        assertThrows(Exception.class, () -> DealReader.read(ERROR_DATA_FILE));
    }

    @Test
    void readFromValidFile() throws IOException {
        List<Deal> deals = DealReader.read(VALID_DATA_FILE);

        assertNotNull(deals);
        assertFalse(deals.isEmpty());
        assertFalse(deals.contains(null));
    }
}
