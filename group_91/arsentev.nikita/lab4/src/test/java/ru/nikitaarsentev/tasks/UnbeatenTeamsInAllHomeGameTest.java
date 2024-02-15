package ru.nikitaarsentev.tasks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.nikitaarsentev.entities.Game;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UnbeatenTeamsInAllHomeGameTest {
    @Test
    void testFindUnbeatenHomeTeamsInAllHomeGame() {
        Game game1 = Mockito.mock(Game.class);
        Game game2 = Mockito.mock(Game.class);

        when(game1.getHomeTeam()).thenReturn("Arsenal");
        when(game1.getScoreGuest()).thenReturn(0);
        when(game2.getHomeTeam()).thenReturn("Arsenal");
        when(game2.getScoreGuest()).thenReturn(1);

        List<Game> games = Arrays.asList(game1, game2);
        List<String> unbeatenTeams = UnbeatenTeamsInAllHomeGame.findUnbeatenHomeTeamsInAllHomeGame(games);

        assertEquals(List.of(), unbeatenTeams);
    }

}