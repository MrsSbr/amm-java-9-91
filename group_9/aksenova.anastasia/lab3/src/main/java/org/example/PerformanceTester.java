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

    private static void testArrayListPerformance(List<Integer> votes) {
        List<Integer> arrayList = new ArrayList<>(votes);
        arrayList.sort(Integer::compare);
    }

    private static void testLinkedListPerformance(List<Integer> votes) {
        List<Integer> linkedList = new LinkedList<>(votes);
        linkedList.sort(Integer::compare);
    }

    private static void testHashSetPerformance(List<Integer> votes) {
        Set<Integer> hashSet = new HashSet<>(votes);
    }
}
