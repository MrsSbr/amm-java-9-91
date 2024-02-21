package ru.nikitaarsentev.tasks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.nikitaarsentev.entities.Game;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StaticOfTeamTest {
    @Test
    void findPointsTest() {
        Game game1 = Mockito.mock(Game.class);
        Game game2 = Mockito.mock(Game.class);

        when(game1.getHomeTeam()).thenReturn("TeamA");
        when(game1.getGuestTeam()).thenReturn("TeamB");
        when(game1.getPointHomeTeam()).thenReturn(3);
        when(game1.getPointGuestTeam()).thenReturn(0);

        when(game2.getHomeTeam()).thenReturn("TeamC");
        when(game2.getGuestTeam()).thenReturn("TeamA");
        when(game2.getPointHomeTeam()).thenReturn(1);
        when(game2.getPointGuestTeam()).thenReturn(1);

        List<Game> results = Arrays.asList(game1, game2);
        Map<String, Integer> points = StaticOfTeam.findPoints(results);
        Map<String, Integer> pointsInHome = StaticOfTeam.findPointsInHome(results);
        Map<String, Integer> pointsInGuest = StaticOfTeam.findPointsInGuest(results);

        assertEquals(Map.of("TeamA", 4, "TeamB", 0, "TeamC", 1), points);
        assertEquals(Map.of("TeamA", 3, "TeamC", 1), pointsInHome);
        assertEquals(Map.of("TeamA", 1, "TeamB", 0), pointsInGuest);
    }

    @Test
    void findCountWinTest() {
        Game game1 = Mockito.mock(Game.class);
        Game game2 = Mockito.mock(Game.class);

        when(game1.getHomeTeam()).thenReturn("TeamA");
        when(game1.getGuestTeam()).thenReturn("TeamB");
        when(game1.isHomeTeamWinBool()).thenReturn(true);

        when(game2.getGuestTeam()).thenReturn("TeamB");
        when(game2.getHomeTeam()).thenReturn("TeamA");
        when(game2.isGuestTeamWinBool()).thenReturn(true);

        List<Game> results = Arrays.asList(game1, game2);
        Map<String, Long> wins = StaticOfTeam.findCountWin(results);
        Map<String, Long> winsInHome = StaticOfTeam.findCountWinInHome(results);
        Map<String, Long> winsInGuest = StaticOfTeam.findCountWinInGuest(results);

        assertEquals(Map.of("TeamA", 1L, "TeamB", 1L), wins);
        assertEquals(Map.of("TeamA", 1L), winsInHome);
        assertEquals(Map.of("TeamB", 1L), winsInGuest);
    }

}