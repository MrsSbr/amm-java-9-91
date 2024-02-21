package ru.nikitaarsentev.tasks;

import ru.nikitaarsentev.entities.Game;

import java.util.*;
import java.util.stream.Collectors;

public class TeamsVictories {
    public static Map<String, Set<String>> findTeamsVictoriesMethod1(List<Game> results) {
        Map<String, Set<String>> victories = new HashMap<>();
        results.forEach(result -> {
            String winner = result.getWinner();
            if (winner != null) {
                String loser = result.getLoser();
                victories.computeIfAbsent(winner, k -> new HashSet<>()).add(loser);
            }
        });
        return victories;
    }

    public static Map<String, Set<String>> findTeamsVictoriesMethod2(List<Game> results) {
        return results.stream()
                .filter(Game::isGameWithWinner)
                .collect(Collectors.groupingBy(Game::getWinner,
                        Collectors.mapping(Game::getLoser, Collectors.toSet())));
    }
}
