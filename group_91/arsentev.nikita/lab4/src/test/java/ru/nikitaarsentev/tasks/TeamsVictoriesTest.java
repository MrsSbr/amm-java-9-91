package ru.nikitaarsentev.tasks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.nikitaarsentev.entities.Game;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TeamsVictoriesTest {
    private Game game1, game2, game3;

    @BeforeEach
    void setUp() {
        game1 = Mockito.mock(Game.class);
        game2 = Mockito.mock(Game.class);
        game3 = Mockito.mock(Game.class);

        when(game1.isGameWithWinner()).thenReturn(true);
        when(game1.getWinner()).thenReturn("TeamA");
        when(game1.getLoser()).thenReturn("TeamB");

        when(game2.isGameWithWinner()).thenReturn(true);
        when(game2.getWinner()).thenReturn("TeamC");
        when(game2.getLoser()).thenReturn("TeamA");

        when(game3.isGameWithWinner()).thenReturn(false);
    }

    @Test
    void findTeamsVictoriesMethod1Test() {
        List<Game> results = Arrays.asList(game1, game2, game3);
        Map<String, Set<String>> expected = Map.of(
                "TeamA", Set.of("TeamB"),
                "TeamC", Set.of("TeamA")
        );

        Map<String, Set<String>> victories = TeamsVictories.findTeamsVictoriesMethod1(results);
        assertEquals(expected, victories);
    }

    @Test
    void findTeamsVictoriesMethod2Test() {
        List<Game> results = Arrays.asList(game1, game2, game3);
        Map<String, Set<String>> expected = Map.of(
                "TeamA", Set.of("TeamB"),
                "TeamC", Set.of("TeamA")
        );

        Map<String, Set<String>> victories = TeamsVictories.findTeamsVictoriesMethod2(results);
        assertEquals(expected, victories);
    }

}