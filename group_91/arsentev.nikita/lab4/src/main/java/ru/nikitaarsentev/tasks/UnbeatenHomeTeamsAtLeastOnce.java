package ru.nikitaarsentev.tasks;

import ru.nikitaarsentev.entities.Game;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class UnbeatenHomeTeamsAtLeastOnce {
    public static Set<String> findUnbeatenHomeTeamsAtLeastOnce(List<Game> results) {
        return results.stream()
                .filter(Game::isCleanSheetHomeTeam)
                .map(Game::getHomeTeam)
                .collect(toSet());
    }
}
