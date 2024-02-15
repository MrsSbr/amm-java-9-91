package ru.nikitaarsentev.tasks;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.nikitaarsentev.entities.Game;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class TopTeamsTest {

    private static List<Game> mockResults;

    @BeforeAll
    static void setUp() {
        Game game1 = Mockito.mock(Game.class);
        Game game2 = Mockito.mock(Game.class);
        Game game3 = Mockito.mock(Game.class);

        // Настройка моковых объектов
        when(game1.getHomeTeam()).thenReturn("TeamA");
        when(game1.getGuestTeam()).thenReturn("TeamB");
        when(game1.getPointHomeTeam()).thenReturn(3);
        when(game1.getPointGuestTeam()).thenReturn(0);

        when(game2.getHomeTeam()).thenReturn("TeamC");
        when(game2.getGuestTeam()).thenReturn("TeamA");
        when(game2.getPointHomeTeam()).thenReturn(0);
        when(game2.getPointGuestTeam()).thenReturn(3);

        when(game3.getHomeTeam()).thenReturn("TeamB");
        when(game3.getGuestTeam()).thenReturn("TeamC");
        when(game3.getPointHomeTeam()).thenReturn(0);
        when(game3.getPointGuestTeam()).thenReturn(3);

        mockResults = Arrays.asList(game1, game2, game3);
    }

    @Test
    void testFindFirstTopTeamsHelp() {
        Map<String, Integer> notSortedTable = Map.of(
                "TeamA", 10,
                "TeamB", 15,
                "TeamC", 5,
                "TeamD", 20
        );

        List<String> topTeams = TopTeams.findFirstTopTeamsHelp(notSortedTable, 2);
        assertEquals(List.of("TeamD", "TeamB"), topTeams);
    }

    @Test
    void testFindTableHelp() {
        Map<String, Integer> notSortedTable = Map.of(
                "TeamA", 10,
                "TeamB", 15,
                "TeamC", 5,
                "TeamD", 20
        );

        Map<String, Integer> expectedTable = new LinkedHashMap<>();
        expectedTable.put("TeamD", 20);
        expectedTable.put("TeamB", 15);
        expectedTable.put("TeamA", 10);
        expectedTable.put("TeamC", 5);

        Map<String, Integer> sortedTable = TopTeams.findTableHelp(notSortedTable);
        assertEquals(expectedTable, sortedTable);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 6})
    void testFindFirstTopTeamsInvalidCount(int countTops) {
        assertThrows(IllegalArgumentException.class, () -> TopTeams.findFirstTopTeams(mockResults, countTops));
    }

    @ParameterizedTest
    @CsvSource({
            "3, TeamA TeamC TeamB",
            "1, TeamA"
    })
    void testFindFirstTopTeamsValidCount(int countTops, String expectedTeams) {
        List<String> expected = Arrays.asList(expectedTeams.split(" "));
        List<String> topTeams = TopTeams.findFirstTopTeams(mockResults, countTops);
        assertEquals(expected, topTeams);
    }

    @Test
    void testFindTable() {
        Map<String, Integer> table = TopTeams.findTable(mockResults); // mockResults - мокированный список игр
        Map<String, Integer> expectedTable = Map.of("TeamA", 6, "TeamC", 3, "TeamB", 0);
        assertEquals(expectedTable, table);
    }
}