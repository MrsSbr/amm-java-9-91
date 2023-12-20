package org.example;

import java.util.Scanner;

public class Summator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        NumberProcessor numberProcessor = new NumberProcessor();

        System.out.println("Введите количество потоков: ");
        int countThreds = scanner.nextInt();
        NumberThread[] threads = new NumberThread[countThreds];

        System.out.println("Введите числа (для окончания одного из потоков введите 0):");

        for (int i  = 0; i < countThreds; i++) {
            threads[i] = new NumberThread(numberProcessor, scanner);
            threads[i].start();
        }

        try {
            for (int i  = 0; i < countThreds; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Потоки остановлены");
        }
        scanner.close();

        int sumThreads = 0;

        for (int i  = 0; i < countThreds; i++) {
            int sum = threads[i].getThreadSum();
            System.out.println("Сумма потока " + i + ": " + sum);
            sumThreads += sum;
        }

        System.out.println("Сумма сумм всех потоков: " + sumThreads);
        System.out.println("Общая сумма: " + numberProcessor.getTotalSum());
    }
}