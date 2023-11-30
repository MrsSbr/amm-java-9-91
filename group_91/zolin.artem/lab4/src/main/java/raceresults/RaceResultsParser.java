package raceresults;

import exceptions.WrongResultFormatException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

public class RaceResultsParser {

    private final InputStream resultsStream;

    public RaceResultsParser(InputStream resultsStream) {
        this.resultsStream = resultsStream;
    }

    public List<RaceResult> parse() throws IOException {
        try (
            var reader = new InputStreamReader(resultsStream);
            var bufferedReader = new BufferedReader(reader)
        ) {
            return bufferedReader.lines()
                    .map(this::parseRaceResult)
                    .toList();
        }
    }

    private RaceResult parseRaceResult(String line) {
        try {
            var split = line.split(";");
            return new RaceResult(
                    LocalDate.parse(split[0]),
                    split[1],
                    split[2],
                    split[3]
            );
        } catch (DateTimeException | IndexOutOfBoundsException e) {
            throw new WrongResultFormatException(line, "unable to parse line: " + line, e);
        }
    }

}
