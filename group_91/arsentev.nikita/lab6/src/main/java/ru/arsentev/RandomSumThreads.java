package ru.arsentev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.LongAdder;

public class RandomSumThreads {
    public static final LinkedBlockingQueue<Integer> numbersQueue = new LinkedBlockingQueue<>();
    public static AtomicBoolean stop = new AtomicBoolean(false);
    public static void main(String[] args) {
        LongAdder totalSum = new LongAdder();
        List<SumThread> threads = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {
            SumThread sumThread = new SumThread(totalSum);
            threads.add(sumThread);
            sumThread.start();
        }

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("stop")) {
                    stop.set(true);
                    break;
                }
                try {
                    int number = Integer.parseInt(input);
                    numbersQueue.put(number);
                } catch (NumberFormatException e) {
                    System.out.println(input + " not number!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        for (SumThread thread : threads) {
            try {
                thread.join();
                System.out.println(thread.threadId() + " = " + thread.getLocalSum());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        long sum = threads.stream()
                .mapToLong(SumThread::getLocalSum)
                .sum();

        System.out.println("Total sum:" + totalSum);
        System.out.println("Threads sum:" + sum);
        System.out.println("Sums are " + (totalSum.longValue() == sum ? "" : "not ") + "equal");
    }

}
