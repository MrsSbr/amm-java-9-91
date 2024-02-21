package ru.arsentev;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RandomSumThreads {
    static final List<Integer> numbersPool = Collections.synchronizedList(new ArrayList<>());
    public static volatile boolean inputFinished = false; // Флаг для индикации завершения ввода

    public static void main(String[] args) {
        AtomicInteger totalSum = new AtomicInteger(0);
        List<SumThread> threads = new ArrayList<>();

        // Создание и запуск потоков
        for (int i = 0; i < 3; i++) {
            SumThread thread = new SumThread(totalSum);
            threads.add(thread);
            thread.start();
        }

        // Чтение чисел с консоли
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("stop")) {
                    inputFinished = true;
                    break;
                }
                try {
                    int number = Integer.parseInt(input);
                    numbersPool.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number or 'stop' to finish.");
                }
            }
        }

        // Ожидание завершения всех потоков
        for (SumThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        for (SumThread thread : threads) {
            System.out.println(thread.threadId() + " = " + thread.getLocalSum());
        }

        int threadsSum = threads.stream()
                .mapToInt(SumThread::getLocalSum)
                .sum();
        System.out.println("Total sum: " + totalSum.get());
        System.out.println("Threads sum: " + threadsSum);
        System.out.println("Sums are " + (totalSum.get() == threadsSum ? "" : "not ") + "equal");
    }
}
