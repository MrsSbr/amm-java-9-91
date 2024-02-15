package ru.nikitaarsentev.tasks;

import ru.nikitaarsentev.entities.Game;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StaticOfTeam {
    public static Map<String, Integer> findCountMissedGoals(List<Game> results) {
        Map<String, Integer> homeMissedGoals = findCountMissedGoalsInHome(results);
        Map<String, Integer> guestMissedGoals = findCountMissedGoalsInGuest(results);
        homeMissedGoals.forEach((key, value) -> guestMissedGoals.merge(key, value, Integer::sum));
        return guestMissedGoals;
    }

    public static Map<String, Integer> findCountMissedGoalsInHome(List<Game> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Game::getHomeTeam, Collectors.summingInt(Game::getScoreGuest)));
    }

    public static Map<String, Integer> findCountMissedGoalsInGuest(List<Game> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Game::getGuestTeam, Collectors.summingInt(Game::getScoreHome)));
    }

    public static Map<String, Integer> findCountScoredGoals(List<Game> results) {
        Map<String, Integer> homeScoreGoals = findCountScoredGoalsInHome(results);
        Map<String, Integer> guestScoreGoals = findCountScoredGoalsInGuest(results);
        homeScoreGoals.forEach((key, value) -> guestScoreGoals.merge(key, value, Integer::sum));
        return guestScoreGoals;
    }

    public static Map<String, Integer> findCountScoredGoalsInGuest(List<Game> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Game::getGuestTeam, Collectors.summingInt(Game::getScoreGuest)));
    }

    public static Map<String, Integer> findCountScoredGoalsInHome(List<Game> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Game::getHomeTeam, Collectors.summingInt(Game::getScoreHome)));
    }

    public static Map<String, Integer> findPoints(List<Game> results) {
        Map<String, Integer> homePoints = findPointsInHome(results);
        Map<String, Integer> guestPoints = findPointsInGuest(results);
        homePoints.forEach((key, value) -> guestPoints.merge(key, value, Integer::sum));
        return guestPoints;
    }

    public static Map<String, Integer> findPointsInGuest(List<Game> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Game::getGuestTeam, Collectors.summingInt(Game::getPointGuestTeam)));
    }

    public static Map<String, Integer> findPointsInHome(List<Game> results) {
        return results.stream()
                .collect(Collectors.groupingBy(Game::getHomeTeam, Collectors.summingInt(Game::getPointHomeTeam)));
    }

    public static Map<String, Long> findCountWin(List<Game> results) {
        Map<String, Long> homeWins = findCountWinInHome(results);
        Map<String, Long> guestWins = findCountWinInGuest(results);
        homeWins.forEach((key, value) -> guestWins.merge(key, value, Long::sum));
        return guestWins;
    }

    public static Map<String, Long> findCountWinInGuest(List<Game> results) {
        return results.stream()
                .filter(Game::isGuestTeamWinBool)
                .collect(Collectors.groupingBy(Game::getGuestTeam, Collectors.counting()));
    }

    public static Map<String, Long> findCountWinInHome(List<Game> results) {
        return results.stream()
                .filter(Game::isHomeTeamWinBool)
                .collect(Collectors.groupingBy(Game::getHomeTeam, Collectors.counting()));
    }

    public static Map<String, Long> findCountLose(List<Game> results) {
        Map<String, Long> homeLoses = findCountLoseInHome(results);
        Map<String, Long> guestLoses = findCountLoseInGuest(results);
        homeLoses.forEach((key, value) -> guestLoses.merge(key, value, Long::sum));
        return guestLoses;
    }

    public static Map<String, Long> findCountLoseInGuest(List<Game> results) {
        return results.stream()
                .filter(Game::isGuestTeamWinBool)
                .collect(Collectors.groupingBy(Game::getGuestTeam, Collectors.counting()));
    }

    public static Map<String, Long> findCountLoseInHome(List<Game> results) {
        return results.stream()
                .filter(Game::isGuestTeamWinBool)
                .collect(Collectors.groupingBy(Game::getHomeTeam, Collectors.counting()));
    }
}
