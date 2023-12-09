package GameResources;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GamesStatisticsTest {

    private static final GameStatistics gameStatistics = new GameStatistics();
    private static final List<Game> TEST_GAMES = List.of(
            new Game("Outlast", Genre.HORROR, LocalDate.of(2021, 7, 28), 25, Estimation.GOOD),
            new Game("ELDEN RING", Genre.RPG, LocalDate.of(2022, 3, 25), 150, Estimation.EXCELLENT),
            new Game("Metro Exodus", Genre.SHOOTER, LocalDate.of(2020, 7, 8), 80, Estimation.GOOD),
            new Game("The Witcher 3: Wild Hunt", Genre.RPG, LocalDate.of(2023, 9, 12), 100, Estimation.EXCELLENT),
            new Game("Sid Meier’s Civilization VI", Genre.GLOBAL_STRATEGY, LocalDate.of(2019, 4, 5), 678, Estimation.GOOD),
            new Game("Sons of the Forest", Genre.HORROR, LocalDate.of(2020, 7, 3), 25, Estimation.EXCELLENT),
            new Game("РУСЫ ПРОТИВ ЯЩЕРОВ", Genre.STRATEGY, LocalDate.of(2023, 7, 19), 36, Estimation.GOOD),
            new Game("DOKA 2", Genre.GLOBAL_STRATEGY, LocalDate.of(2021, 8, 15), 13, Estimation.IMPOSSIBLE_TO_PLAY),
            new Game("Dead Island", Genre.HORROR, LocalDate.of(2020, 1, 2), 17, Estimation.BAD),
            new Game("God of War", Genre.SLASHER, LocalDate.of(2023, 5, 10), 45, Estimation.GOOD),
            new Game("The Witcher 3: Wild Hunt", Genre.RPG, LocalDate.of(2023, 1, 11), 110, Estimation.EXCELLENT),
            new Game("Sons of the Forest", Genre.HORROR, LocalDate.of(2021, 7, 3), 35, Estimation.NORMAL)
    );

    private static final Month MONTH_WITH_THE_HIGHEST_GAME_ACTIVITY = Month.APRIL;

    private static final Genre genreWithTheHighestAverageEstimation = Genre.RPG;

    private static final List<String> GAMES_THAT_PLAYED_MORE_THAN_ONCE = List.of(
            "The Witcher 3: Wild Hunt",
            "Sons of the Forest"
    );

    private static final List<Game> EMPTY_GAME_LIST = Collections.emptyList();

    @Test
    void findGenreWithTheHighestAverageEstimation() {
        Genre genre = gameStatistics.genreWithTheHighestAverageEstimation(TEST_GAMES);
        assertEquals(genre, genreWithTheHighestAverageEstimation);
    }

    @Test
    void findMonthWithTheHighestGameActivity() {
        Month month = gameStatistics.monthWithTheHighestInnocentisGameActivity(TEST_GAMES);
        assertEquals(month, MONTH_WITH_THE_HIGHEST_GAME_ACTIVITY);
    }

    @Test
    void findGamesThatPlayedMoreThanOnce() {
        List<String> games = gameStatistics.gamesGamingMoreThanOnce(TEST_GAMES);
        assertIterableEquals(games, GAMES_THAT_PLAYED_MORE_THAN_ONCE);
    }

    @Test
    void findGenreWithTheHighestAverageEstimationInEmptyList() {
        Genre genre = gameStatistics.genreWithTheHighestAverageEstimation(EMPTY_GAME_LIST);
        assertNull(genre);
    }

    @Test
    void findMonthWithTheHighestGameActivityInEmptyList() {
        assertThrows(NoSuchElementException.class, () -> {
            gameStatistics.monthWithTheHighestInnocentisGameActivity(EMPTY_GAME_LIST);
        });
    }

    @Test
    void findGamesThatPlayedMoreThanOnceInEmptyList() {
        List<String> games = gameStatistics.gamesGamingMoreThanOnce(EMPTY_GAME_LIST);
        assertEquals(games.size(), 0);
    }
}
