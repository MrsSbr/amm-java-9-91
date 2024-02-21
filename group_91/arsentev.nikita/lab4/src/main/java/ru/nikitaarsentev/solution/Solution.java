package ru.nikitaarsentev.solution;

import ru.nikitaarsentev.createfile.FileWithGames;
import ru.nikitaarsentev.entities.Game;
import ru.nikitaarsentev.entities.Way;
import ru.nikitaarsentev.tasks.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Solution {
    public static void main(String[] args) {
        final String path = "football-game.txt";
        final int countTops = 3;
        final int countGames = 10;
        try {
            FileWithGames.generateRandomGames(countGames, path);
            List<String> lines = Files.readAllLines(Paths.get(path));
            List<Game> results = lines.stream()
                    .map(Game::new)
                    .collect(toList());
            System.out.println("Table(FOR_EACH):" + TopTeams.findTable(results, Way.FOR_EACH));
            System.out.println("Table:" + TopTeams.findTable(results));
            System.out.println("Top(FLAT_MAP)" + countTops + "Teams: " + TopTeams.findFirstTopTeams(results, countTops, Way.FLAT_MAP));
            System.out.println("Top" + countTops + "Teams: " + TopTeams.findFirstTopTeams(results, countTops));
            System.out.println("Unbeaten Home Teams At Least Once: " + UnbeatenHomeTeamsAtLeastOnce.findUnbeatenHomeTeamsAtLeastOnce(results));
            System.out.println("Unbeaten Teams In All Home Game(FOR_EACH): " + UnbeatenTeamsInAllHomeGame.findUnbeatenHomeTeamsInAllHomeGame(results, Way.FOR_EACH));
            System.out.println("Unbeaten Teams In All Home Game: " + UnbeatenTeamsInAllHomeGame.findUnbeatenHomeTeamsInAllHomeGame(results));
            System.out.println("Count Missed Goals(FLAT_MAP)" + StaticOfTeamWithWay.findCountMissedGoals(results, Way.FLAT_MAP));
            System.out.println("Count Missed Goals" + StaticOfTeam.findCountMissedGoals(results));
            System.out.println("Count Missed Goals In Home(FLAT_MAP)" + StaticOfTeamWithWay.findCountMissedGoalsInHome(results, Way.FLAT_MAP));
            System.out.println("Count Missed Goals In Home" + StaticOfTeam.findCountMissedGoalsInHome(results));
            System.out.println("Count Missed Goals In Guest(FOR_EACH)" + StaticOfTeamWithWay.findCountMissedGoalsInGuest(results, Way.FOR_EACH));
            System.out.println("Count Missed Goals In Guest" + StaticOfTeam.findCountMissedGoalsInGuest(results));
            System.out.println("Count Scored Goals(FOR_EACH)" + StaticOfTeamWithWay.findCountScoredGoals(results, Way.FOR_EACH));
            System.out.println("Count Scored Goals" + StaticOfTeam.findCountScoredGoals(results));
            System.out.println("Count Scored Goals In Home(FOR_EACH)" + StaticOfTeamWithWay.findCountScoredGoalsInHome(results, Way.FOR_EACH));
            System.out.println("Count Scored Goals In Home" + StaticOfTeam.findCountScoredGoalsInHome(results));
            System.out.println("Count Scored Goals In Guest(FLAT_MAP)" + StaticOfTeamWithWay.findCountScoredGoalsInGuest(results, Way.FLAT_MAP));
            System.out.println("Count Scored Goals In Guest" + StaticOfTeam.findCountScoredGoalsInGuest(results));
            System.out.println("Teams Victories(1): " + TeamsVictories.findTeamsVictoriesMethod1(results));
            System.out.println("Teams Victories(2): " + TeamsVictories.findTeamsVictoriesMethod2(results));
            System.out.println("Count Win(FOR_EACH)" + StaticOfTeamWithWay.findCountWin(results, Way.FOR_EACH));
            System.out.println("Count Win" + StaticOfTeam.findCountWin(results));
            System.out.println("Count Win In Home(FLAT_MAP)" + StaticOfTeamWithWay.findCountWinInHome(results, Way.FLAT_MAP));
            System.out.println("Count Win In Home" + StaticOfTeam.findCountWinInHome(results));
            System.out.println("Count Win In Guest(FOR_EACH)" + StaticOfTeamWithWay.findCountWinInGuest(results, Way.FOR_EACH));
            System.out.println("Count Win In Guest" + StaticOfTeam.findCountWinInGuest(results));
            System.out.println("Count Lose(FLAT_MAP)" + StaticOfTeamWithWay.findCountLose(results, Way.FLAT_MAP));
            System.out.println("Count Lose" + StaticOfTeam.findCountLose(results));
            System.out.println("Count Lose In Home(FLAT_MAP)" + StaticOfTeamWithWay.findCountLoseInHome(results, Way.FLAT_MAP));
            System.out.println("Count Lose In Home" + StaticOfTeam.findCountLoseInHome(results));
            System.out.println("Count Lose In Guest(FOR_EACH)" + StaticOfTeamWithWay.findCountLoseInGuest(results, Way.FOR_EACH));
            System.out.println("Count Lose In Guest" + StaticOfTeam.findCountLoseInGuest(results));
            System.out.println("Count Points In Home(FOR_EACH)" + StaticOfTeamWithWay.findPointsInHome(results, Way.FOR_EACH));
            System.out.println("Count Points In Home" + StaticOfTeam.findPointsInHome(results));
            System.out.println("Count Points In Guest(FLAT_MAP)" + StaticOfTeamWithWay.findPointsInGuest(results, Way.FLAT_MAP));
            System.out.println("Count Points In Guest" + StaticOfTeam.findPointsInGuest(results));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
