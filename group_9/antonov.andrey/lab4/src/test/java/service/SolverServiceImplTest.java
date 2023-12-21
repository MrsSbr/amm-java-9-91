package service;

import java.util.List;
import static entity.Country.BELARUS;
import static entity.Country.RUSSIA;
import static entity.Country.UKRAINE;
import static entity.Country.USA;
import static entity.Sport.RUNNING;
import static entity.Sport.SKI;
import static entity.Sport.SWIMMING;
import static org.junit.jupiter.api.Assertions.assertEquals;
import entity.Country;
import entity.OlympicStatistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolverServiceImplTest {
    private static final List<OlympicStatistic> TEST_LIST = List.of(
        new OlympicStatistic(RUSSIA, SWIMMING, "Антонов", 3),
        new OlympicStatistic(RUSSIA, SWIMMING, "Антонов", 2),
        new OlympicStatistic(USA, RUNNING, "Смит", 2),
        new OlympicStatistic(UKRAINE, SWIMMING, "Иванов", 3),
        new OlympicStatistic(BELARUS, SKI, "Петров", 10),
        new OlympicStatistic(USA, RUNNING, "Тейлор", 3),
        new OlympicStatistic(USA, RUNNING, "Джеймс", 1),
        new OlympicStatistic(USA, SKI, "Мур", 2)
    );

    private static final List<String> BEST_ATHLETES_RUNNING = List.of(
        "Джеймс",
        "Смит",
        "Тейлор"
    );

    private static final List<String> BEST_ATHLETES_SWIMMING = List.of(
        "Антонов",
        "Иванов"
    );

    private static final List<String> BEST_ATHLETES_SKI = List.of(
        "Мур"
    );

    private static final String THE_BEST_ATHLETE = "Антонов";

    private static final Country COUNTRY_FIRST_PLACE = USA;

    private static final Country COUNTRY_SECOND_PLACE = RUSSIA;

    private static final Country COUNTRY_THIRD_PLACE = UKRAINE;


    @Test
    void getTop3BestCountriesTest() {
        final var actualResult = new SolverServiceImpl().getTop3BestCountries(TEST_LIST);
        assertEquals(3, actualResult.size());
        assertEquals(COUNTRY_FIRST_PLACE, actualResult.get(0));
        assertEquals(COUNTRY_SECOND_PLACE, actualResult.get(1));
        assertEquals(COUNTRY_THIRD_PLACE, actualResult.get(2));
    }

    @Test
    void getAthletesBySportTest() {
        final var actualResult = new SolverServiceImpl().getAthletesBySport(TEST_LIST);

        assertEquals(3, actualResult.size());

        final var theBestAthletesByRunning = actualResult.get(RUNNING);
        final var theBestAthletesBySwimming = actualResult.get(SWIMMING);
        final var theBestAthletesBySki = actualResult.get(SKI);

        assertEquals(BEST_ATHLETES_RUNNING, theBestAthletesByRunning);
        assertEquals(BEST_ATHLETES_SWIMMING, theBestAthletesBySwimming);
        assertEquals(BEST_ATHLETES_SKI, theBestAthletesBySki);
    }

    @Test
    void getBestAthleteTest() {
        final var bestAthlete = new SolverServiceImpl().getBestAthlete(TEST_LIST);
        bestAthlete.ifPresentOrElse(
            (result) -> assertEquals(THE_BEST_ATHLETE, result),
            Assertions::fail
        );
    }

    @Test
    void shouldEmptyResultIfListEmpty() {
        final var solverService = new SolverServiceImpl();
        Assertions.assertTrue(solverService.getBestAthlete(List.of()).isEmpty());
        Assertions.assertTrue(solverService.getAthletesBySport(List.of()).isEmpty());
        Assertions.assertTrue(solverService.getTop3BestCountries(List.of()).isEmpty());
    }

    @Test
    void shouldThrownIAEIfListNull() {
        final var solverService = new SolverServiceImpl();
        Assertions.assertThrows(IllegalArgumentException.class, () -> solverService.getAthletesBySport(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> solverService.getTop3BestCountries(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> solverService.getBestAthlete(null));
    }
}