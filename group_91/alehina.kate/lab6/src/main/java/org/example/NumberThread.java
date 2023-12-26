package org.example;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class NumberThread extends Thread {
    AtomicInteger totalSum = new AtomicInteger(0);
    private final Scanner scanner;
    private int threadSum;

    public NumberThread(AtomicInteger totalSum, Scanner scanner) {
        this.totalSum = totalSum;
        this.scanner = scanner;
        threadSum = 0;
    }

    public int getThreadSum() {
        return threadSum;
    }

    @Override
    public void run() {
        int input;

        while(true) {
            synchronized (scanner) {
                input = scanner.nextInt();
            }
            if (input == 0) {
                break;
            }
            threadSum = threadSum + input;
            totalSum.addAndGet(input);;
        }
    }
}
