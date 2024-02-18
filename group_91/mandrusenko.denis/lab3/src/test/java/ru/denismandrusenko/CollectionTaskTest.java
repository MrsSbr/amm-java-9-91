package ru.denismandrusenko;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionTaskTest {
    private final List<BoardGame> games = List.of(
            new BoardGame("Monopoly", Genre.STRATEGY, 2500,
                    LocalDate.of(2019, 9, 13)),
            new BoardGame("Scrabble", Genre.PUZZLE, 1100,
                    LocalDate.of(2020, 5, 9)),
            new BoardGame("Risk", Genre.STRATEGY, 1890,
                    LocalDate.of(2019, 12, 13)),
            new BoardGame("Chess", Genre.STRATEGY, 1200,
                    LocalDate.of(2021, 1, 3)),
            new BoardGame("Catan", Genre.ROLEPLAY, 2400,
                    LocalDate.of(2023, 6, 15)),
            new BoardGame("Ticket to Ride", Genre.STRATEGY, 2990,
                    LocalDate.of(2021, 6, 6)),
            new BoardGame("Clue", Genre.STRATEGY, 2000,
                    LocalDate.of(2018, 8, 20)),
            new BoardGame("Codenames", Genre.CARD, 1250,
                    LocalDate.of(2019, 1, 24)),
            new BoardGame("Pandemic", Genre.STRATEGY, 2100,
                    LocalDate.of(2020, 5, 13)),
            new BoardGame("The Settlers of Catan", Genre.STRATEGY, 1790,
                    LocalDate.of(2022, 7, 8)),
            new BoardGame("Uno", Genre.CARD, 1500,
                    LocalDate.of(2022, 2, 22)),
            new BoardGame("Dominion", Genre.CARD, 2690,
                    LocalDate.of(2021, 10, 28)),
            new BoardGame("Taboo", Genre.ROLEPLAY, 1400,
                    LocalDate.of(2019, 11, 11))
    );

    @Test
    void testGetBestSellingGamesByGenre() {
        BoardGameTask task = new BoardGameTask(games);
        List<BoardGame> bestSellingGames = task.getBestSellingGamesByGenre();

        assertNotNull(bestSellingGames);
        assertFalse(bestSellingGames.isEmpty());
    }

    @Test
    void testGetMonthWithHighestRevenue() {
        BoardGameTask task = new BoardGameTask(games);
        assertDoesNotThrow(() -> {
            task.getMonthWithHighestRevenue();
        });
    }


    @Test
    void testGetGameNameWithSalesButNotRecently() {
        BoardGameTask task = new BoardGameTask(games);
        assertDoesNotThrow(() -> {
            task.getGameNameWithSalesButNotRecently();
        });
    }

    @Test
    void testGetBestSellingGamesByGenreEmptyCollection() {
        List<BoardGame> emptyGames = Collections.emptyList();
        BoardGameTask task = new BoardGameTask(emptyGames);
        List<BoardGame> bestSellingGames = task.getBestSellingGamesByGenre();

        assertNotNull(bestSellingGames);
        assertTrue(bestSellingGames.isEmpty());
    }

    @Test
    void testGetMonthWithHighestRevenueEmptyCollection() {
        List<BoardGame> emptyGames = Collections.emptyList();
        BoardGameTask task = new BoardGameTask(emptyGames);
        try {
            task.getMonthWithHighestRevenue();
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    @Test
    void testGetGameNameWithSalesButNotRecentlyEmptyCollection() {
        List<BoardGame> emptyGames = Collections.emptyList();
        BoardGameTask task = new BoardGameTask(emptyGames);
        try {
            task.getGameNameWithSalesButNotRecently();
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    @Test
    void testGetGameNameWithSalesButNotRecentlyAllRecentSales() {
        List<BoardGame> recentGames = Arrays.asList(
                new BoardGame("Game1", Genre.STRATEGY, 2000,
                        LocalDate.now()),
                new BoardGame("Game2", Genre.CARD, 1500,
                        LocalDate.now().minusMonths(1)),
                new BoardGame("Game3", Genre.ROLEPLAY, 1800,
                        LocalDate.now().minusMonths(2))
        );
        BoardGameTask task = new BoardGameTask(recentGames);
        try {
            task.getGameNameWithSalesButNotRecently();
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }

    @Test
    void testGetGameNameWithSalesButNotRecentlyNoSales() {
        List<BoardGame> noSalesGames = Arrays.asList(
                new BoardGame("Game1", Genre.STRATEGY, 0,
                        LocalDate.now().minusMonths(4)),
                new BoardGame("Game2", Genre.CARD, 0,
                        LocalDate.now().minusMonths(3)),
                new BoardGame("Game3", Genre.ROLEPLAY, 0,
                        LocalDate.now().minusMonths(2))
        );
        BoardGameTask task = new BoardGameTask(noSalesGames);
        try {
            task.getGameNameWithSalesButNotRecently();
        } catch (NoSuchElementException e) {
            assertNotNull(e);
        }
    }
}