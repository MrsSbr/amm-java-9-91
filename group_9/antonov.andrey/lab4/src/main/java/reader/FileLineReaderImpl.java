package reader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import entity.OlympicStatistic;
import lombok.SneakyThrows;
import parser.Parser;

//как вообще правильнo именовать, если интерфейс параметризован?:
//1. FileLineReaderImpl
//2. OlympicStatisticFileLineReader
//3. OlympicStatisticFileLineReaderImpl
public class FileLineReaderImpl implements FileLineReader<OlympicStatistic> {
    @Override
    @SneakyThrows
    public List<OlympicStatistic> readAllLines(final Path path, final Parser<OlympicStatistic> parser) {
        final List<OlympicStatistic> result = new ArrayList<>();
        Files.readAllLines(path)
            .forEach(line -> result.add(parser.parseLine(line)));
        return result;
    }
}
