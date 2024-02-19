import org.example.HttpStatusCode;
import org.example.Log;
import org.example.LogStatistics;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogStatisticsTest {
    private static final LogStatistics logStatistics = new LogStatistics();
    private static final Collection<Log> logs = List.of(
            new Log(LocalDate.now(), "https://google.com", "192.168.1.1", HttpStatusCode.OK),
            new Log(LocalDate.now(), "https://google.com", "192.168.1.2", HttpStatusCode.NOT_FOUND),
            new Log(LocalDate.now(), "https://google.com", "192.168.1.2", HttpStatusCode.BAD_GATEWAY),
            new Log(LocalDate.now(), "https://google.com", "192.168.1.2", HttpStatusCode.NOT_FOUND),
            new Log(LocalDate.now(), "https://google.com", "192.168.1.2", HttpStatusCode.FORBIDDEN),
            new Log(LocalDate.now(), "https://github.com", "192.168.1.2", HttpStatusCode.OK),
            new Log(LocalDate.now(), "https://github.com", "192.168.1.2", HttpStatusCode.NOT_FOUND),
            new Log(LocalDate.now(), "https://facebook.com", "192.168.1.2", HttpStatusCode.FORBIDDEN),
            new Log(LocalDate.now(), "https://facebook.com", "192.168.1.2", HttpStatusCode.NOT_FOUND)
    );

    @Test
    public void testGetCodeStatistics() {
        Map<HttpStatusCode, Long> expected = Map.of(
                HttpStatusCode.OK, 2L,
                HttpStatusCode.NOT_FOUND, 4L,
                HttpStatusCode.BAD_GATEWAY, 1L,
                HttpStatusCode.FORBIDDEN, 2L
        );

        Map<HttpStatusCode, Long> actual = logStatistics.getCodeStatistics(logs);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetResourceStatistics() {
        Map<String, Long> expected = Map.of(
                "https://google.com", 5L,
                "https://github.com", 2L,
                "https://facebook.com", 2L
        );

        Map<String, Long> actual = logStatistics.getResourceStatistics(logs);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetMostUnstableResource() {
        String expected = "https://google.com";

        String actual = logStatistics.getMostUnstableResource(logs);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetResourceWithHighestSuccessRatio() {
        String expected = "https://github.com";

        String actual = logStatistics.getResourceWithHighestSuccessRatio(logs);

        assertEquals(expected, actual);
    }
}