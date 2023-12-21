import moonshine.Moonshine;
import moonshine.MoonshineReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

public class ReaderTests {
    private static final Path INVALID_INFO_FILE_PATH = Path.of("src/test/resources/invalidfile.txt");
    private static final Path EMPTY_FILE_PATH = Path.of("src/test/resources/emptyfile.txt");

    @Test
    void readFromFileWithInvalidPath() {
        MoonshineReader reader = new MoonshineReader();
        Assertions.assertThrows(RuntimeException.class, () -> reader.readMoonshines(Path.of("")));
    }

    @Test
    void readFromFileWithInvalidInfo() {
        MoonshineReader reader = new MoonshineReader();
        Assertions.assertThrows(RuntimeException.class, () -> reader.readMoonshines(INVALID_INFO_FILE_PATH));
    }

    @Test
    void readFromEmptyFile() {
        MoonshineReader reader = new MoonshineReader();
        List<Moonshine> emptyMoonshines = reader.readMoonshines(EMPTY_FILE_PATH);
        Assertions.assertEquals(0, emptyMoonshines.size());
    }
}
