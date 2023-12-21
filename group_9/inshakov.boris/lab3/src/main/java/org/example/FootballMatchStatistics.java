package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FootballMatchStatistics {
    private Collection<String> homeBestPlayers;
    private Collection<String> awayBestPlayers;

    public FootballMatchStatistics(Collection<String> homeCollection, Collection<String> awayCollection) {
        this.homeBestPlayers = homeCollection;
        this.awayBestPlayers = awayCollection;
        generateRandomStats();
    }

    private void generateRandomStats() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            homeBestPlayers.add("Player" + random.nextInt(1000));
            awayBestPlayers.add("Player" + random.nextInt(1000));
        }
    }

    public String findMostFrequentPlayer(Collection<String> homePlayers, Collection<String> awayPlayers) {
        return Stream.concat(homePlayers.stream(), awayPlayers.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Set<String> findBestAwayPlayers() {
        return new HashSet<>(awayBestPlayers);
    }

    public long countPlayersBestOnlyOnce() {
        return Stream.concat(homeBestPlayers.stream(), awayBestPlayers.stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .count();
    }

    public static void main(String[] args) {
        testCollection(new ArrayList<>(), new ArrayList<>());
        testCollection(new LinkedList<>(), new LinkedList<>());
        testCollection(new HashSet<>(), new HashSet<>());
    }

    private static void testCollection(Collection<String> homeCollection, Collection<String> awayCollection) {
        FootballMatchStatistics stats = new FootballMatchStatistics(homeCollection, awayCollection);
        System.out.println("Testing with " + homeCollection.getClass().getSimpleName());
        System.out.println("Player who was best most often: " + stats.findMostFrequentPlayer(homeCollection, awayCollection));
        System.out.println("Players who were best in away matches: " + stats.findBestAwayPlayers());
        System.out.println("Number of players who were best only once: " + stats.countPlayersBestOnlyOnce());
        System.out.println();
    }
}
