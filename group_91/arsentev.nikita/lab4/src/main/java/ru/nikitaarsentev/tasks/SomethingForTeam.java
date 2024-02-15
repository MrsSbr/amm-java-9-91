package ru.nikitaarsentev.tasks;

import ru.nikitaarsentev.entities.Game;
import ru.nikitaarsentev.entities.GameFunction;
import ru.nikitaarsentev.entities.Way;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SomethingForTeam {
    protected static Map<String, Integer> findSomethingForTeamFlatMap(List<Game> results,
                                                                    GameFunction gameFunctionForHomeTeam,
                                                                    GameFunction gameFunctionForGuestTeam) {
        return results.stream()
                .flatMap(game -> Stream.of(
                        Map.entry(game.getHomeTeam(), gameFunctionForHomeTeam.calculate(game)),
                        Map.entry(game.getGuestTeam(), gameFunctionForGuestTeam.calculate(game))
                ))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ));
    }

    protected static Map<String, Integer> findSomethingForTeamForEach(List<Game> results,
                                                                    GameFunction gameFunctionForHomeTeam,
                                                                    GameFunction gameFunctionForGuestTeam) {
        Map<String, Integer> teamsInOrder = new HashMap<>();
        results.forEach(result -> {
            teamsInOrder.merge(result.getHomeTeam(), gameFunctionForHomeTeam.calculate(result), Integer::sum);
            teamsInOrder.merge(result.getGuestTeam(), gameFunctionForGuestTeam.calculate(result), Integer::sum);
        });
        return teamsInOrder;
    }

    public static Map<String, Integer> findSomethingForTeam(Way way,
                                                            List<Game> results,
                                                            GameFunction gameFunctionForHomeTeam,
                                                            GameFunction gameFunctionForGuestTeam) {
        return switch (way) {
            case FOR_EACH -> findSomethingForTeamForEach(results, gameFunctionForHomeTeam, gameFunctionForGuestTeam);
            case FLAT_MAP -> findSomethingForTeamFlatMap(results, gameFunctionForHomeTeam, gameFunctionForGuestTeam);
        };
    }
}
