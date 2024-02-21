package ru.nikitaarsentev.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void testGameCreationValidInput() {
        Game game = new Game("TeamA;TeamB;2:1");
        assertEquals("TeamA", game.getHomeTeam());
        assertEquals("TeamB", game.getGuestTeam());
        assertEquals(2, game.getScoreHome());
        assertEquals(1, game.getScoreGuest());
    }

    @ParameterizedTest
    @ValueSource(strings = {"TeamA;TeamB;", ";;1:0", "TeamA;TeamB;2:"})
    void testGameCreationInvalidInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> new Game(input));
    }

    @ParameterizedTest
    @CsvSource({
            "TeamA, TeamB, 2:1, 3, 0", // Home team wins
            "TeamC, TeamD, 1:1, 1, 1", // Draw
            "TeamE, TeamF, 0:3, 0, 3"  // Guest team wins
    })
    void testGetPoints(String homeTeam, String guestTeam, String score, int expectedHomePoints, int expectedGuestPoints) {
        Game game = new Game(homeTeam + ";" + guestTeam + ";" + score);
        assertEquals(expectedHomePoints, game.getPointHomeTeam());
        assertEquals(expectedGuestPoints, game.getPointGuestTeam());
    }

    @ParameterizedTest
    @CsvSource({
            "TeamA, TeamB, 2:0, true", // Home team clean sheet
            "TeamC, TeamD, 1:2, false" // Home team concedes
    })
    void testIsCleanSheetHomeTeam(String homeTeam, String guestTeam, String score, boolean expected) {
        Game game = new Game(homeTeam + ";" + guestTeam + ";" + score);
        assertEquals(expected, game.isCleanSheetHomeTeam());
    }

    @ParameterizedTest
    @CsvSource({
            "TeamA, TeamB, 2:1, TeamA", // Home team wins
            "TeamC, TeamD, 1:3, TeamD", // Guest team wins
            "TeamE, TeamF, 0:0, "       // Draw, no winner
    })
    void testGetWinner(String homeTeam, String guestTeam, String score, String expectedWinner) {
        Game game = new Game(homeTeam + ";" + guestTeam + ";" + score);
        assertEquals(expectedWinner, game.getWinner());
    }

    @ParameterizedTest
    @CsvSource({
            "TeamA, TeamB, 2:1, 1",  // Home team wins
            "TeamC, TeamD, 0:2, 0"   // Home team loses
    })
    void testIsHomeTeamWinInt(String homeTeam, String guestTeam, String score, int expected) {
        Game game = new Game(homeTeam + ";" + guestTeam + ";" + score);
        assertEquals(expected, game.isHomeTeamWinInt());
    }

    @ParameterizedTest
    @CsvSource({
            "TeamA, TeamB, 3:0, true",  // Home team wins
            "TeamC, TeamD, 1:1, false"  // Draw
    })
    void testIsHomeTeamWinBool(String homeTeam, String guestTeam, String score, boolean expected) {
        Game game = new Game(homeTeam + ";" + guestTeam + ";" + score);
        assertEquals(expected, game.isHomeTeamWinBool());
    }

    @ParameterizedTest
    @CsvSource({
            "TeamA, TeamB, 1:2, 1",  // Guest team wins
            "TeamC, TeamD, 2:2, 0"   // Draw
    })
    void testIsGuestTeamWinInt(String homeTeam, String guestTeam, String score, int expected) {
        Game game = new Game(homeTeam + ";" + guestTeam + ";" + score);
        assertEquals(expected, game.isGuestTeamWinInt());
    }

    @ParameterizedTest
    @CsvSource({
            "TeamA, TeamB, 0:3, true",  // Guest team wins
            "TeamC, TeamD, 2:2, false"  // Draw
    })
    void testIsGuestTeamWinBool(String homeTeam, String guestTeam, String score, boolean expected) {
        Game game = new Game(homeTeam + ";" + guestTeam + ";" + score);
        assertEquals(expected, game.isGuestTeamWinBool());
    }

    @ParameterizedTest
    @CsvSource({
            "TeamA, TeamB, 2:1, true",  // Home team wins
            "TeamC, TeamD, 1:1, false"  // Draw
    })
    void testIsGameWithWinner(String homeTeam, String guestTeam, String score, boolean expected) {
        Game game = new Game(homeTeam + ";" + guestTeam + ";" + score);
        assertEquals(expected, game.isGameWithWinner());
    }

    @ParameterizedTest
    @CsvSource({
            "TeamA, TeamB, 1:2, TeamA",  // Guest team wins
            "TeamC, TeamD, 2:3, TeamC",  // Guest team wins
            "TeamE, TeamF, 1:1, "        // Draw, no loser
    })
    void testGetLoser(String homeTeam, String guestTeam, String score, String expectedLoser) {
        Game game = new Game(homeTeam + ";" + guestTeam + ";" + score);
        assertEquals(expectedLoser, game.getLoser());
    }
}