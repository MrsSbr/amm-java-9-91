package org.example;
import java.util.*;

public class PerformanceTester {

    public static void testCollectionPerformance(List<Integer> votes) {
        long startTime = System.currentTimeMillis();
        testArrayListPerformance(votes);
        System.out.println("ArrayList performance: " + (System.currentTimeMillis() - startTime) + " ms");

        startTime = System.currentTimeMillis();
        testLinkedListPerformance(votes);
        System.out.println("LinkedList performance: " + (System.currentTimeMillis() - startTime) + " ms");

        startTime = System.currentTimeMillis();
        testHashSetPerformance(votes);
        System.out.println("HashSet performance: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    private static void testListPerformance(List<Integer> votes, List<Integer> list) {
        list.addAll(votes);
        Collections.sort(list);
    }

    private static void testArrayListPerformance(List<Integer> votes) {
        testListPerformance(votes, new ArrayList<>());
    }

    private static void testLinkedListPerformance(List<Integer> votes) {
        testListPerformance(votes, new LinkedList<>());
    }

    private static void testHashSetPerformance(List<Integer> votes) {
        List<Integer> votesList = new ArrayList<>(votes);
        Set<Integer> hashSet = new HashSet<>(votesList);
    }
}
