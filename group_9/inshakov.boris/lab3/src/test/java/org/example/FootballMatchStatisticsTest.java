package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class FootballMatchStatisticsTest {
    private FootballMatchStatistics statsWithArrayList;
    private FootballMatchStatistics statsWithLinkedList;
    private FootballMatchStatistics statsWithHashSet;

    @BeforeEach
    public void setUp() {
        statsWithArrayList = new FootballMatchStatistics(new ArrayList<>(), new ArrayList<>());
        statsWithLinkedList = new FootballMatchStatistics(new LinkedList<>(), new LinkedList<>());
        statsWithHashSet = new FootballMatchStatistics(new HashSet<>(), new HashSet<>());
    }

    private void testCountPlayersBestOnlyOnce(FootballMatchStatistics stats) {
        long playersBestOnlyOnce = stats.countPlayersBestOnlyOnce();
        assertTrue(playersBestOnlyOnce >= 0, "Number of players best only once should be non-negative");
    }

    @Test
    public void testCountPlayersBestOnlyOnceArrayList() {
        testCountPlayersBestOnlyOnce(statsWithArrayList);
    }

    @Test
    public void testCountPlayersBestOnlyOnceLinkedList() {
        testCountPlayersBestOnlyOnce(statsWithLinkedList);
    }

    @Test
    public void testCountPlayersBestOnlyOnceHashSet() {
        testCountPlayersBestOnlyOnce(statsWithHashSet);
    }

    // Implementations of other test methods
    @Test
    public void testFindMostFrequentPlayerArrayList() {
        String mostFrequentPlayer = statsWithArrayList.findMostFrequentPlayer();
        assertNotNull(mostFrequentPlayer, "Most frequent player should not be null with ArrayList");
    }

    @Test
    public void testFindMostFrequentPlayerLinkedList() {
        String mostFrequentPlayer = statsWithLinkedList.findMostFrequentPlayer();
        assertNotNull(mostFrequentPlayer, "Most frequent player should not be null with LinkedList");
    }

    @Test
    public void testFindMostFrequentPlayerHashSet() {
        String mostFrequentPlayer = statsWithHashSet.findMostFrequentPlayer();
        assertNotNull(mostFrequentPlayer, "Most frequent player should not be null with HashSet");
    }

    @Test
    public void testFindBestAwayPlayersArrayList() {
        Set<String> bestAwayPlayers = statsWithArrayList.findBestAwayPlayers();
        assertFalse(bestAwayPlayers.isEmpty(), "Best away players set should not be empty with ArrayList");
    }

    @Test
    public void testFindBestAwayPlayersLinkedList() {
        Set<String> bestAwayPlayers = statsWithLinkedList.findBestAwayPlayers();
        assertFalse(bestAwayPlayers.isEmpty(), "Best away players set should not be empty with LinkedList");
    }

    @Test
    public void testFindBestAwayPlayersHashSet() {
        Set<String> bestAwayPlayers = statsWithHashSet.findBestAwayPlayers();
        assertFalse(bestAwayPlayers.isEmpty(), "Best away players set should not be empty with HashSet");
    }
    @Test
    public void testPerformanceArrayList() {
        long startTime = System.nanoTime();
        // Предположим, что это методы, производительность которых мы хотим проверить.
        statsWithArrayList.findMostFrequentPlayer();
        statsWithArrayList.findBestAwayPlayers();
        statsWithArrayList.countPlayersBestOnlyOnce();
        long endTime = System.nanoTime();
        System.out.println("ArrayList performance: " + (endTime - startTime) + " nanoseconds.");
    }

    @Test
    public void testPerformanceLinkedList() {
        long startTime = System.nanoTime();
        // Аналогичные вызовы для LinkedList.
        statsWithLinkedList.findMostFrequentPlayer();
        statsWithLinkedList.findBestAwayPlayers();
        statsWithLinkedList.countPlayersBestOnlyOnce();
        long endTime = System.nanoTime();
        System.out.println("LinkedList performance: " + (endTime - startTime) + " nanoseconds.");
    }

    @Test
    public void testPerformanceHashSet() {
        long startTime = System.nanoTime();
        // Аналогичные вызовы для HashSet.
        statsWithHashSet.findMostFrequentPlayer();
        statsWithHashSet.findBestAwayPlayers();
        statsWithHashSet.countPlayersBestOnlyOnce();
        long endTime = System.nanoTime();
        System.out.println("HashSet performance: " + (endTime - startTime) + " nanoseconds.");
    }

}