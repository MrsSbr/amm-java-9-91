package ru.nikitaarsentev.tasks;

import ru.nikitaarsentev.entities.Game;
import ru.nikitaarsentev.entities.Way;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class UnbeatenTeamsInAllHomeGame {
    public static List<String> findUnbeatenHomeTeamsInAllHomeGame(List<Game> games) {
        return games.stream()
                .collect(groupingBy(Game::getHomeTeam, summingInt(Game::getScoreGuest)))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    public static Set<String> findUnbeatenHomeTeamsInAllHomeGame(List<Game> results, Way way) {
        Set<String> set = results.stream()
                .map(Game::getHomeTeam)
                .collect(toSet());

        set.retainAll(StaticOfTeamWithWay.findCountMissedGoalsInHome(results, way)
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 0)
                .map(Map.Entry::getKey)
                .collect(toSet()));
        return set;
    }
}
