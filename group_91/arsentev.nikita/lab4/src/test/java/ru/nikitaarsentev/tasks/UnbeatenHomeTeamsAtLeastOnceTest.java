package ru.nikitaarsentev.tasks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.nikitaarsentev.entities.Game;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UnbeatenHomeTeamsAtLeastOnceTest {
    @Test
    void testFindUnbeatenHomeTeamsAtLeastOnce() {
        Game game1 = Mockito.mock(Game.class);
        Game game2 = Mockito.mock(Game.class);
        Game game3 = Mockito.mock(Game.class);

        when(game1.isCleanSheetHomeTeam()).thenReturn(true);
        when(game1.getHomeTeam()).thenReturn("Arsenal");
        when(game2.isCleanSheetHomeTeam()).thenReturn(false);
        when(game2.getHomeTeam()).thenReturn("Arsenal");
        when(game3.isCleanSheetHomeTeam()).thenReturn(true);
        when(game3.getHomeTeam()).thenReturn("Liverpool");

        List<Game> results = Arrays.asList(game1, game2, game3);
        Set<String> unbeatenTeams = UnbeatenHomeTeamsAtLeastOnce.findUnbeatenHomeTeamsAtLeastOnce(results);

        assertEquals(Set.of("Arsenal", "Liverpool"), unbeatenTeams);
    }
}