package org.example.football;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FootballTeam {
    private List<FootballPlayer> players;

    public FootballTeam(int numPlayers) {
        players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(new FootballPlayer(i));
        }
    }

    public void collectFanVotes(int numFans) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        for (int fan = 1; fan <= numFans; fan++) {
            System.out.println("Fan " + fan + ":");
            for (int vote = 0; vote < 3; vote++) {
                int playerNumber = random.nextInt(players.size()) + 1;
                System.out.println("Enter vote " + (vote + 1) + " (player number 1-22): " + playerNumber);
                players.get(playerNumber - 1).addVote();
            }
            System.out.println();
        }
    }

    public void displayResults() {
        List<Integer> mostPopularPlayers = findMostPopularPlayers();
        List<Integer> playersWithNoVotes = findPlayersWithNoVotes();
        List<Integer> votedPlayers = findVotedPlayers();

        System.out.println("Most popular player(s): " + mostPopularPlayers);
        System.out.println("Players with no votes: " + playersWithNoVotes);
        System.out.println("Players who received votes: " + votedPlayers);
    }

    public List<Integer> findMostPopularPlayers() {
        int maxVotes = players.stream().mapToInt(FootballPlayer::getVotes).max().orElse(0);
        return players.stream()
                .filter(player -> player.getVotes() == maxVotes)
                .map(FootballPlayer::getNumber)
                .toList();
    }

    public List<Integer> findPlayersWithNoVotes() {
        return players.stream()
                .filter(player -> player.getVotes() == 0)
                .map(FootballPlayer::getNumber)
                .toList();
    }

    public List<Integer> findVotedPlayers() {
        return players.stream()
                .filter(player -> player.getVotes() > 0)
                .map(FootballPlayer::getNumber)
                .toList();
    }

}
