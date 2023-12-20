import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import entities.Drinks;
import entities.PreparedDrinkAccounting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.SolverServiceImpl;

class SolverServiceImplTest {
    private static final List<PreparedDrinkAccounting> TEST_LIST = List.of(
            new PreparedDrinkAccounting(Drinks.AMERICANO.getName(),
                    LocalDateTime.of(LocalDate.of(2023, 12, 11), LocalTime.of(8, 12, 12)),
                    45,
                    Drinks.AMERICANO.getPrice()),
            new PreparedDrinkAccounting(Drinks.AMERICANO.getName(),
                    LocalDateTime.of(LocalDate.of(2023, 12, 10), LocalTime.of(9, 12, 12)),
                    35,
                    Drinks.AMERICANO.getPrice()),
            new PreparedDrinkAccounting(Drinks.CORTADO.getName(),
                    LocalDateTime.of(LocalDate.of(2023, 12, 9), LocalTime.of(16, 12, 12)),
                    20,
                    Drinks.CORTADO.getPrice()),
            new PreparedDrinkAccounting(Drinks.CAPPUCCINO.getName(),
                    LocalDateTime.of(LocalDate.of(2023, 12, 8), LocalTime.of(17, 12, 12)),
                    30,
                    Drinks.CAPPUCCINO.getPrice()),
            new PreparedDrinkAccounting(Drinks.ESPRESSO.getName(),
                    LocalDateTime.of(LocalDate.of(2023, 12, 7), LocalTime.of(11, 12, 12)),
                    50,
                    Drinks.ESPRESSO.getPrice())
    );

    private static final Map<String, Double> AVG_TIME_OF_PREP_FOR_EACH_DRINK = Map.of(
            Drinks.AMERICANO.getName(), 40.0,
            Drinks.CORTADO.getName(), 20.0,
            Drinks.CAPPUCCINO.getName(), 30.0,
            Drinks.ESPRESSO.getName(), 50.0
    );

    private static final List<String> MOST_OFTEN_ORDERED_DRINKS = List.of(
            Drinks.AMERICANO.getName()
    );

    private static final Optional<Integer> THE_BUSIEST_HOUR_ON_ROUTINE_DAYS = Optional.of(12);

    private static final Optional<String> DRINK_WITH_BEST_RATIO = Optional.of(Drinks.CORTADO.getName());

    @Test
    void getAvgTimeOfPrepForEachDrinkTest() {
        final var actualResult = new SolverServiceImpl().getAvgTimeOfPrepForEachDrink(TEST_LIST);
        assertEquals(AVG_TIME_OF_PREP_FOR_EACH_DRINK, actualResult);
    }

    @Test
    void getTheBusiestHourOnRoutineDaysTest() {
        final var actualResult = new SolverServiceImpl().getTheBusiestHourOnRoutineDays(TEST_LIST);
        assertEquals(THE_BUSIEST_HOUR_ON_ROUTINE_DAYS, actualResult);
    }

    @Test
    void getMostOftenOrderedDrinksByCondTest() {
        final var actualResult = new SolverServiceImpl().getMostOftenOrderedDrinksByCond(TEST_LIST);
        assertEquals(MOST_OFTEN_ORDERED_DRINKS, actualResult);
    }

    @Test
    void getDrinkWithTheBestRatioTest() {
        final var actualResult = new SolverServiceImpl().getDrinkWithTheBestRatio(TEST_LIST);
        assertEquals(DRINK_WITH_BEST_RATIO, actualResult);
    }

    @Test
    void shouldEmptyResultIfListEmpty() {
        final var solverService = new SolverServiceImpl();
        Assertions.assertTrue(solverService.getTheBusiestHourOnRoutineDays(List.of()).isEmpty());
        Assertions.assertTrue(solverService.getDrinkWithTheBestRatio(List.of()).isEmpty());
        //Assertions.assertTrue(solverService.getMostOftenOrderedDrinksByCond(List.of()).isEmpty());
        Assertions.assertTrue(solverService.getAvgTimeOfPrepForEachDrink(List.of()).isEmpty());
    }

    @Test
    void shouldThrownIAEIfListNull() {
        final var solverService = new SolverServiceImpl();
        Assertions.assertThrows(IllegalArgumentException.class, () -> solverService.getAvgTimeOfPrepForEachDrink(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> solverService.getTheBusiestHourOnRoutineDays(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> solverService.getMostOftenOrderedDrinksByCond(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> solverService.getDrinkWithTheBestRatio(null));
    }
}