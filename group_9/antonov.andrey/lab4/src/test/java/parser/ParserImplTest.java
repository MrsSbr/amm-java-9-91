package parser;


import java.util.stream.Stream;
import static entity.Country.BELARUS;
import static entity.Country.RUSSIA;
import static entity.Country.UKRAINE;
import static entity.Country.USA;
import static entity.Sport.RUNNING;
import static entity.Sport.SKI;
import static entity.Sport.SWIMMING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import entity.OlympicStatistic;
import exception.NotFoundCountryException;
import exception.NotFoundSportException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParserImplTest {

    private static final Parser<OlympicStatistic> PARSER = new ParserImpl();


    private static Stream<Arguments> getRightLinesForParsing() {
        return Stream.of(
            Arguments.of("Сша;Плавание;Антонов;1", OlympicStatistic.of(USA, SWIMMING, "Антонов", 1)),
            Arguments.of("Россия;Бег;Иванов;3", OlympicStatistic.of(RUSSIA, RUNNING, "Иванов", 3)),
            Arguments.of("Украина;Лыжи;Петров;5", OlympicStatistic.of(UKRAINE, SKI, "Петров", 5)),
            Arguments.of("Беларусь;Бег;Сидоров;1", OlympicStatistic.of(BELARUS, RUNNING, "Сидоров", 1))
        );
    }

    private static Stream<Arguments> getWrongLinesForParsingByCountry() {
        return Stream.of(
            Arguments.of("Бразилия;Плавание;Антонов;1"),
            Arguments.of("россия;Бег;Иванов;3"),
            Arguments.of("Ук р а ина;Лыжи;Петров;5"),
            Arguments.of("Беларусия;Бег;Сидоров;1"));
    }

    private static Stream<Arguments> getWrongLinesForParsingBySport() {
        return Stream.of(
            Arguments.of("Сша;Футбол;Антонов;1", OlympicStatistic.of(USA, SWIMMING, "Антонов", 1)),
            Arguments.of("Россия;Хоккей;Иванов;3", OlympicStatistic.of(RUSSIA, RUNNING, "Иванов", 3)),
            Arguments.of("Украина;Баскетбол;Петров;5", OlympicStatistic.of(UKRAINE, SKI, "Петров", 5)),
            Arguments.of("Беларусь;Метание;Сидоров;1", OlympicStatistic.of(BELARUS, RUNNING, "Сидоров", 1))
        );
    }

    @ParameterizedTest
    @MethodSource("getRightLinesForParsing")
    void parseLineSuccessful(String line, OlympicStatistic expectedResult) {
        final var actualResult = PARSER.parseLine(line);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("getWrongLinesForParsingBySport")
    void shouldThrownNotFoundSportException(String line) {
        Assertions.assertThrows(NotFoundSportException.class, () -> PARSER.parseLine(line));
    }

    @ParameterizedTest
    @MethodSource("getWrongLinesForParsingByCountry")
    void shouldThrowNotFoundCountryException(String line) {
        Assertions.assertThrows(NotFoundCountryException.class, () -> PARSER.parseLine(line));
    }
}