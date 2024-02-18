package temples;

import org.junit.jupiter.api.Test;
import ru.denismandrusenko.TempleRecord;
import ru.denismandrusenko.TempleRecordReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TempleRecordReaderTest {
    private static final Path ERROR_DATA_FILE = Paths.get("src/test/resources/erroe.txt");
    private static final Path VALID_DATA_FILE = Paths.get("src/main/resources/temples.txt");

    @Test
    void readFromInvalidFile() {
        assertThrows(IOException.class, () -> TempleRecordReader.read(ERROR_DATA_FILE));
    }

    @Test
    void readFromValidFile() throws IOException {
        List<TempleRecord> templeRecords = TempleRecordReader.read(VALID_DATA_FILE);

        assertNotNull(templeRecords);
        assertFalse(templeRecords.isEmpty());
        assertFalse(templeRecords.contains(null));
    }
}