package org.example.summator;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Summator {
    public static void main(String[] args) {
        AtomicInteger totalAmount = new AtomicInteger(0);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner = new Scanner(line);

        Reader reader1 = new Reader(scanner, totalAmount);
        Reader reader2 = new Reader(scanner, totalAmount);
        Reader reader3 = new Reader(scanner, totalAmount);
        Reader reader4 = new Reader(scanner, totalAmount);

        reader1.start();
        reader2.start();
        reader3.start();
        reader4.start();
        try {
            reader1.join();
            reader2.join();
            reader3.join();
            reader4.join();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        scanner.close();
        System.out.println("Сумма первого читателя: " + reader1.getLocalAmount());
        System.out.println("Сумма второго читателя: " + reader2.getLocalAmount());
        System.out.println("Сумма третьего читателя: " + reader3.getLocalAmount());
        System.out.println("Сумма червертого читателя: " + reader4.getLocalAmount());
        int sum = reader1.getLocalAmount() + reader2.getLocalAmount() +
                reader3.getLocalAmount() + reader4.getLocalAmount();
        System.out.println("Сумма сумм потоков: " + sum);
        System.out.println("Общая сумма чисел: " + totalAmount);
    }
}