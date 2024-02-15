package ru.nikitaarsentev.tasks;

import ru.nikitaarsentev.entities.Game;
import ru.nikitaarsentev.entities.Way;

import java.util.List;
import java.util.Map;

public class StaticOfTeamWithWay {
    public static Map<String, Integer> findCountMissedGoals(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::getScoreGuest, Game::getScoreHome);
    }

    public static Map<String, Integer> findCountMissedGoalsInGuest(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::get0, Game::getScoreHome);
    }

    public static Map<String, Integer> findCountMissedGoalsInHome(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::getScoreGuest, Game::get0);
    }

    public static Map<String, Integer> findCountScoredGoals(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::getScoreHome, Game::getScoreGuest);
    }

    public static Map<String, Integer> findCountScoredGoalsInGuest(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::get0, Game::getScoreGuest);
    }

    public static Map<String, Integer> findCountScoredGoalsInHome(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::getScoreHome, Game::get0);
    }

    public static Map<String, Integer> findPoints(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::getPointHomeTeam, Game::getPointGuestTeam);
    }

    public static Map<String, Integer> findPointsInGuest(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::get0, Game::getPointGuestTeam);
    }

    public static Map<String, Integer> findPointsInHome(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::getPointHomeTeam, Game::get0);
    }

    public static Map<String, Integer> findCountWin(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::isHomeTeamWinInt, Game::isGuestTeamWinInt);
    }

    public static Map<String, Integer> findCountWinInGuest(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::get0, Game::isGuestTeamWinInt);
    }

    public static Map<String, Integer> findCountWinInHome(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::isHomeTeamWinInt, Game::get0);
    }

    public static Map<String, Integer> findCountLose(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::isGuestTeamWinInt, Game::isHomeTeamWinInt);
    }

    public static Map<String, Integer> findCountLoseInGuest(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::get0, Game::isHomeTeamWinInt);
    }

    public static Map<String, Integer> findCountLoseInHome(List<Game> results, Way way) {
        return SomethingForTeam.findSomethingForTeam(way, results, Game::isGuestTeamWinInt, Game::get0);
    }
}
