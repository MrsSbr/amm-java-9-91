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
        OlympicStatistic.of(RUSSIA, SWIMMING, "Антонов", 3),
        OlympicStatistic.of(RUSSIA, SWIMMING, "Антонов", 2),
        OlympicStatistic.of(USA, RUNNING, "Смит", 2),
        OlympicStatistic.of(UKRAINE, SWIMMING, "Иванов", 3),
        OlympicStatistic.of(BELARUS, SKI, "Петров", 10),
        OlympicStatistic.of(USA, RUNNING, "Тейлор", 3),
        OlympicStatistic.of(USA, RUNNING, "Джеймс", 1),
        OlympicStatistic.of(USA, SKI, "Мур", 2)

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

    private static final SolverService SOLVER_SERVICE = new SolverServiceImpl(TEST_LIST);

    @Test
    void getTop3BestCountriesTest() {
        final var actualResult = SOLVER_SERVICE.getTop3BestCountries();
        assertEquals(3, actualResult.size());
        assertEquals(COUNTRY_FIRST_PLACE, actualResult.get(0));
        assertEquals(COUNTRY_SECOND_PLACE, actualResult.get(1));
        assertEquals(COUNTRY_THIRD_PLACE, actualResult.get(2));
    }

    @Test
    void getAthletesBySportTest() {
        final var actualResult = SOLVER_SERVICE.getAthletesBySport();

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
        final var bestAthlete = SOLVER_SERVICE.getBestAthlete();
        bestAthlete.ifPresentOrElse(
            (result) -> assertEquals(THE_BEST_ATHLETE, result),
            Assertions::fail
        );
    }
}