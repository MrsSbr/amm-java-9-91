package ru.nikitaarsentev.tasks;

import ru.nikitaarsentev.entities.Game;
import ru.nikitaarsentev.entities.Way;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.util.Comparator.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class TopTeams {
    protected static List<String> findFirstTopTeamsHelp(Map<String, Integer> notSortedTable, int countTops) {
        return notSortedTable.entrySet().stream()
                .sorted(comparingByValue(reverseOrder()))
                .limit(countTops)
                .map(Entry::getKey)
                .collect(toList());
    }

    protected static Map<String, Integer> findTableHelp(Map<String, Integer> notSortedTable) {
        return notSortedTable.entrySet().stream()
                .sorted(comparingByValue(reverseOrder()))
                .collect(toMap(Entry::getKey,
                        Entry::getValue,
                        (a, b) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
    }

    public static List<String> findFirstTopTeams(List<Game> results, int countTops, Way way) {
        if (countTops < 0 || countTops > results.size()) {
            throw new IllegalArgumentException(("Invalid format: " + countTops));
        }
        return findFirstTopTeamsHelp(StaticOfTeamWithWay.findPoints(results, way), countTops);
    }

    public static List<String> findFirstTopTeams(List<Game> results, int countTops) {
        if (countTops < 0 || countTops > results.size()) {
            throw new IllegalArgumentException(("Invalid format: " + countTops));
        }
        return findFirstTopTeamsHelp(StaticOfTeam.findPoints(results), countTops);
    }

    public static Map<String, Integer> findTable(List<Game> results, Way way) {
        return findTableHelp(StaticOfTeamWithWay.findPoints(results, way));
    }

    public static Map<String, Integer> findTable(List<Game> results) {
        return findTableHelp(StaticOfTeam.findPoints(results));
    }
}
