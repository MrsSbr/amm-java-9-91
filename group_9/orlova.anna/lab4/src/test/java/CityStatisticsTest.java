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

        CityStatistics cityStatisticsCalculations = new CityStatistics();
        String result = cityStatisticsCalculations.mostPopularAnswerForCitiesStartingWithA(testData);
        assertEquals("фырфырфыр", result);
    }

    @Test
    public void testNegativeMostPopularAnswerForCitiesStartingWithA() {

        List<CityStatisticsEntry> emptyList = new ArrayList<>();
        CityStatistics cityStatisticsCalculations = new CityStatistics();
        String resultEmptyList = cityStatisticsCalculations.mostPopularAnswerForCitiesStartingWithA(emptyList);
        assertEquals("", resultEmptyList);

        List<CityStatisticsEntry> testDataWithoutCitiesStartingWithA = Arrays.asList(
                new CityStatisticsEntry("Москва", 50, "фырфырфыр"),
                new CityStatisticsEntry("Санкт-Петербург", 30, "ихихих"),
                new CityStatisticsEntry("Казань", 20, "пипипи"),
                new CityStatisticsEntry("Москва", 40, "пипипи"),
                new CityStatisticsEntry("Санкт-Петербург", 25, "фырфырфыр")
        );

        String resultWithoutCitiesStartingWithA =
                cityStatisticsCalculations.mostPopularAnswerForCitiesStartingWithA(testDataWithoutCitiesStartingWithA);
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

        CityStatistics cityStatisticsCalculations = new CityStatistics();
        String result = cityStatisticsCalculations.cityWithMostDiverseAnswers(testData);
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

        CityStatistics cityStatisticsCalculations = new CityStatistics();
        String result = cityStatisticsCalculations.cityWithMostDiverseAnswers(testData);
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

        CityStatistics cityStatisticsCalculations = new CityStatistics();
        List<String> result = cityStatisticsCalculations.citiesWithMatchingAnswersAsMoscow(testData);
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

        CityStatistics cityStatisticsCalculations = new CityStatistics();
        List<String> result = cityStatisticsCalculations.citiesWithMatchingAnswersAsMoscow(testData);
        assertEquals(List.of(), result);
    }
}
