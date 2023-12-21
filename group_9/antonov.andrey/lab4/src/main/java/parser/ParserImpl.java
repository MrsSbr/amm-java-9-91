package parser;

import java.util.List;
import entity.Country;
import entity.OlympicStatistic;
import entity.Sport;
import exception.NotFoundCountryException;
import exception.NotFoundSportException;

//как вообще правильнo именовать, если интерфейс параметризован?:
//1. ParserImpl
//2. OlympicStatisticParserImpl
//3. OlympicStatisticParser
public class ParserImpl implements Parser<OlympicStatistic> {

    private static final String DELIMITER = ";";

    private static final String COUNTRY_NOT_FOUND_MESSAGE = "Country not found!";

    private static final String SPORT_NOT_FOUND_MESSAGE = "Sport not found!";

    @Override
    public OlympicStatistic parseLine(String line) {
        var strings = List.of(line.trim().split(DELIMITER));
        return new OlympicStatistic(
            Country.find(strings.get(0)).orElseThrow(() -> new NotFoundCountryException(COUNTRY_NOT_FOUND_MESSAGE)),
            Sport.find(strings.get(1)).orElseThrow(() -> new NotFoundSportException(SPORT_NOT_FOUND_MESSAGE)),
            strings.get(2),
            Integer.parseInt(strings.get(3))
        );
    }
}
