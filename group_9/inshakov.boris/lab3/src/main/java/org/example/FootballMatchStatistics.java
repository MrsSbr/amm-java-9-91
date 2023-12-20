package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.stream.Stream;

public class FootballMatchStatistics {
    private Collection<String> homeBestPlayers;
    private Collection<String> awayBestPlayers;

    public FootballMatchStatistics(Collection<String> homeCollection, Collection<String> awayCollection) {
        homeBestPlayers = homeCollection;
        awayBestPlayers = awayCollection;
        generateRandomStats();
    }

    private void generateRandomStats() {
        Random random = new Random();
        int uniquePlayers = 1000;
        for (int i = 0; i < 1000; i++) {
            homeBestPlayers.add("Player" + random.nextInt(uniquePlayers));
            awayBestPlayers.add("Player" + random.nextInt(uniquePlayers));
        }
    }


    public String findMostFrequentPlayer() {
        List<String> allPlayers = new ArrayList<>();
        allPlayers.addAll(homeBestPlayers);
        allPlayers.addAll(awayBestPlayers);

        String mostFrequentPlayer = null;
        int mostFrequencies = 0;
        Set<String> uniquePlayers = new HashSet<>(allPlayers);

        for (String player : uniquePlayers) {
            int frequencies = Collections.frequency(allPlayers, player);
            if (frequencies > mostFrequencies) {
                mostFrequencies = frequencies;
                mostFrequentPlayer = player;
            }
        }

        return mostFrequentPlayer;
    }


    public Set<String> findBestAwayPlayers() {
        return new HashSet<>(awayBestPlayers);
    }

    public long countPlayersBestOnlyOnce() {
        List<String> allPlayers = new ArrayList<>();
        allPlayers.addAll(homeBestPlayers);
        allPlayers.addAll(awayBestPlayers);

        Set<String> uniquePlayers = new HashSet<>(allPlayers);
        long count = 0;

        for (String player : uniquePlayers) {
            if (Collections.frequency(allPlayers, player) == 1) {
                count++;
            }
        }

        return count;
    }


    public static void main(String[] args) {
        // Тестируем различные коллекции
        testCollection(new ArrayList<>(), new ArrayList<>());
        testCollection(new LinkedList<>(), new LinkedList<>());
        testCollection(new HashSet<>(), new HashSet<>());
    }

    private static void testCollection(Collection<String> homeCollection, Collection<String> awayCollection) {
        FootballMatchStatistics stats = new FootballMatchStatistics(homeCollection, awayCollection);
        System.out.println("Testing with " + homeCollection.getClass().getSimpleName());
        System.out.println("Player who was best most often: " + stats.findMostFrequentPlayer());
        System.out.println("Players who were best in away matches: " + stats.findBestAwayPlayers());
        System.out.println("Number of players who were best only once: " + stats.countPlayersBestOnlyOnce());
        System.out.println();
    }
}
