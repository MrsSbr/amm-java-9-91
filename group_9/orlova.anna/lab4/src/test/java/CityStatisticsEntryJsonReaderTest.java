import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CityStatisticsEntryJsonReaderTest {

    @Test
    public void testReadJsonFile() throws URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                .getResource("test.json")).toURI());

        List<CityStatisticsEntry> expected = List.of(
                new CityStatisticsEntry("city1", 1, "answer1"),
                new CityStatisticsEntry("city2", 2, "answer2"),
                new CityStatisticsEntry("city3", 3, "answer3")
        );

        List<CityStatisticsEntry> actual = CityStatisticsEntryJsonReader.readJsonFile(path);

        assertArrayEquals(actual.toArray(), expected.toArray());
    }

    @Test
    public void testReadJsonFileNegative() throws URISyntaxException {
        Path path = Paths.get("nonexistent_file.json");

        assertThrows(RuntimeException.class, () -> CityStatisticsEntryJsonReader.readJsonFile(path));
    }
}
