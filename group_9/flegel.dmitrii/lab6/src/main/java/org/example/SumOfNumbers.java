package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumOfNumbers {
    private static final int NUM_THREADS = 10;

    public static void main(String[] args) {
        SharedSum sharedSum = new SharedSum();
        List<SumThread> threads = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < NUM_THREADS; i++) {
            SumThread thread = new SumThread(sharedSum, scanner);
            threads.add(thread);
            thread.start();
        }

        try {
            for (SumThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }

        System.out.println("Final Total Sum: " + sharedSum.getTotalSum());

        long sumOfLocalSums = 0;
        for (SumThread thread : threads) {
            sumOfLocalSums += thread.getLocalSum();
            System.out.println("Thread " + thread.threadId() + " local sum: " + thread.getLocalSum());
        }

        if (sharedSum.getTotalSum() == sumOfLocalSums) {
            System.out.println("Verification passed: Total Sum matches the sum of Local Sums.");
        } else {
            System.out.println("Verification failed: Total Sum does not match the sum of Local Sums.");
        }
    }
}
