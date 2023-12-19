import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CityStatisticsTest {
    @Test
    public void testPositiveMostPopularAnswerForCitiesStartingWithA() {
        List<CityStatisticsEntry> testData = List.of(
                new CityStatisticsEntry("Абакан", 50, "фырфырфыр"),
                new CityStatisticsEntry("Абакан", 40, "ихихих"),
                new CityStatisticsEntry("Астрахань", 30, "ихихих"),
                new CityStatisticsEntry("Астрахань", 25, "фырфырфыр"),
                new CityStatisticsEntry("Москва", 20, "пипипи")
        );

        String result = CityStatistics.mostPopularAnswerForCitiesStartingWithA(testData);
        assertEquals("фырфырфыр", result);
    }

    @Test
    public void testNegativeMostPopularAnswerForCitiesStartingWithA() {

        List<CityStatisticsEntry> emptyList = new ArrayList<>();
        String resultEmptyList = CityStatistics.mostPopularAnswerForCitiesStartingWithA(emptyList);
        assertEquals("", resultEmptyList);

        List<CityStatisticsEntry> testDataWithoutCitiesStartingWithA = Arrays.asList(
                new CityStatisticsEntry("Москва", 50, "фырфырфыр"),
                new CityStatisticsEntry("Санкт-Петербург", 30, "ихихих"),
                new CityStatisticsEntry("Казань", 20, "пипипи"),
                new CityStatisticsEntry("Москва", 40, "пипипи"),
                new CityStatisticsEntry("Санкт-Петербург", 25, "фырфырфыр")
        );
        String resultWithoutCitiesStartingWithA =
                CityStatistics.mostPopularAnswerForCitiesStartingWithA(testDataWithoutCitiesStartingWithA);
        assertEquals("", resultWithoutCitiesStartingWithA);
    }

    @Test
    public void testPositiveCityWithMostDiverseAnswers() {
        List<CityStatisticsEntry> testData = List.of(
                new CityStatisticsEntry("Абакан", 50, "фырфырфыр"),
                new CityStatisticsEntry("Санкт-Петербург", 30, "ихихих"),
                new CityStatisticsEntry("Санкт-Петербург", 25, "фырфырфыр"),
                new CityStatisticsEntry("Москва", 20, "фырфырфыр"),
                new CityStatisticsEntry("Астрахань", 30, "фырфырфыр"),
                new CityStatisticsEntry("Астрахань", 25, "ихихих"),
                new CityStatisticsEntry("Астрахань", 25, "пипипи")
        );

        String result = CityStatistics.cityWithMostDiverseAnswers(testData);
        assertEquals("Астрахань", result);
    }

    @Test
    public void testNegativeCityWithMostDiverseAnswers() {
        List<CityStatisticsEntry> testData = List.of(
                new CityStatisticsEntry("Абакан", 50, "фырфырфыр"),
                new CityStatisticsEntry("Абакан", 50, "ихихих"),
                new CityStatisticsEntry("Санкт-Петербург", 30, "фырфырфыр"),
                new CityStatisticsEntry("Санкт-Петербург", 25, "фырфырфыр"),
                new CityStatisticsEntry("Москва", 20, "фырфырфыр"),
                new CityStatisticsEntry("Москва", 50, "ихихих"),
                new CityStatisticsEntry("Астрахань", 30, "фырфырфыр"),
                new CityStatisticsEntry("Астрахань", 25, "фырфырфыр"),
                new CityStatisticsEntry("Астрахань", 25, "фырфырфыр"),
                new CityStatisticsEntry("Астрахань", 25, "фырфырфыр")
        );

        String result = CityStatistics.cityWithMostDiverseAnswers(testData);
        assertEquals("", result);
    }

    @Test
    public void testPositiveCitiesWithMatchingAnswersAsMoscow() {
        List<CityStatisticsEntry> testData = List.of(
                new CityStatisticsEntry("Москва", 50, "фырфырфыр"),
                new CityStatisticsEntry("Санкт-Петербург", 30, "фырфырфыр"),
                new CityStatisticsEntry("Казань", 20, "пипипи"),
                new CityStatisticsEntry("Санкт-Петербург", 25, "пипипи"),
                new CityStatisticsEntry("Воронеж", 20, "пипипи")
        );

        List<String> result = CityStatistics.citiesWithMatchingAnswersAsMoscow(testData);
        assertEquals(List.of("Санкт-Петербург"), result);
    }

    @Test
    public void testNegativeCitiesWithMatchingAnswersAsMoscow() {
        List<CityStatisticsEntry> testData = Arrays.asList(
                new CityStatisticsEntry("Москва", 50, "фырфырфыр"),
                new CityStatisticsEntry("Санкт-Петербург", 30, "ихихих"),
                new CityStatisticsEntry("Казань", 20, "пипипи"),
                new CityStatisticsEntry("Санкт-Петербург", 25, "пипипи"),
                new CityStatisticsEntry("Воронеж", 20, "пипипи")
        );

        List<String> result = CityStatistics.citiesWithMatchingAnswersAsMoscow(testData);
        assertEquals(List.of(), result);
    }
}
