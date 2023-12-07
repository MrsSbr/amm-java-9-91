package raceresults;

import exceptions.WrongResultFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RaceResultsParserTest {

    static final String RACE_RESULTS = """
            2013-08-12;Horse1;Horse2;Horse3;
            1998-01-31;Horse with spaces in name;Horse1;Horse2;
            1900-01-01;      ;\t;\thorse\t;
            1000-03-15;~~~;,.<>;\\/!@#$%^&*()_+;""";
    static final List<RaceResult> EXPECTED_PARSED_RESULTS = List.of(
            new RaceResult(
                    LocalDate.of(2013, 8, 12),
                    "Horse1", "Horse2", "Horse3"
            ),
            new RaceResult(
                    LocalDate.of(1998, 1, 31),
                    "Horse with spaces in name", "Horse1", "Horse2"
            ),
            new RaceResult(
                    LocalDate.of(1900, 1, 1),
                    "      ", "\t", "\thorse\t"
            ),
            new RaceResult(
                    LocalDate.of(1000, 3, 15),
                    "~~~", ",.<>", "\\/!@#$%^&*()_+"
            )
    );

    static Stream<String> wrongInputFormatShouldThrow() {
        return Stream.of(
                "2013-32-01;Horse1;Horse2;Horse3;\n",
                "2013-01-01;Horse1;Horse2\n",
                "08:30:15;Horse1;Horse2;Horse3;\n",
                "2023-06-23;;;;",
                "\n"
        );
    }

    @Test
    void resultsShouldBeParsedCorrectly() throws IOException {
        var resultsStream = new ByteArrayInputStream(RACE_RESULTS.getBytes());
        var resultsParser = new RaceResultsParser(resultsStream);
        assertThat(resultsParser.parse()).containsExactlyInAnyOrderElementsOf(EXPECTED_PARSED_RESULTS);
    }

    @ParameterizedTest
    @MethodSource
    void wrongInputFormatShouldThrow(String results) {
        var resultsStream = new ByteArrayInputStream(results.getBytes());
        var resultsParser = new RaceResultsParser(resultsStream);
        assertThatExceptionOfType(WrongResultFormatException.class).isThrownBy(resultsParser::parse);
    }

}
