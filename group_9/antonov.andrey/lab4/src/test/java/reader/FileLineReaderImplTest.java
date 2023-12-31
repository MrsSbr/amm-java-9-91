package reader;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import static entity.Country.BELARUS;
import static entity.Country.RUSSIA;
import static entity.Country.UKRAINE;
import static entity.Country.USA;
import static entity.Sport.RUNNING;
import static entity.Sport.SKI;
import static entity.Sport.SWIMMING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import entity.OlympicStatistic;
import exception.ParseException;
import org.junit.jupiter.api.Test;
import parser.Parser;
import parser.ParserImpl;

class FileLineReaderImplTest {

    private static final FileLineReader<OlympicStatistic> FILE_LINE_READER = new FileLineReaderImpl();

    private static final Parser<OlympicStatistic> PARSER = new ParserImpl();

    private static final String RIGHT_FILE_NAME = "rightData.txt";

    private static final String WRONG_FILE_NAME = "wrongData.txt";

    private static final String NON_EXISTENT_FILE_NAME = "nonExistentFile.txt";

    private static final List<OlympicStatistic> TEST_LIST = List.of(
        new OlympicStatistic(RUSSIA, RUNNING, "Антонов", 3),
        new OlympicStatistic(USA, RUNNING, "Смит", 2),
        new OlympicStatistic(UKRAINE, SWIMMING, "Антонов", 3),
        new OlympicStatistic(BELARUS, SKI, "Петров", 10)
    );


    @Test
    void readAllLinesSuccess() {
        try {
            final var path = Paths.get(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource(RIGHT_FILE_NAME)).toURI());
            final var actualResult = FILE_LINE_READER.readAllLines(path, PARSER);
            assertEquals(TEST_LIST, actualResult);
        } catch (URISyntaxException uriSyntaxException) {
            fail();
        }
    }

    @Test
    void shouldThrownParseExceptionIfResourceFileIsNull() {
        assertThrows(ParseException.class,
            () -> {
                final var path = Paths.get(
                    Objects.requireNonNull(this.getClass().getClassLoader().getResource(WRONG_FILE_NAME)).toURI());
                FILE_LINE_READER.readAllLines(path, PARSER);
            });
    }

    @Test
    void shouldThrownNpeIfResourceFileIsNull() {
        assertThrows(NullPointerException.class,
            () -> Paths.get(
                Objects.requireNonNull(this.getClass().getClassLoader().getResource(NON_EXISTENT_FILE_NAME)).toURI()));
    }
}