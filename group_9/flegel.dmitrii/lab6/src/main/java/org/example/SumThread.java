package org.example;

import java.util.Scanner;

public class SumThread extends Thread {
    private final SharedSum sharedSum;
    private long localSum;
    private final Scanner scanner;

    public SumThread(SharedSum sharedSum, Scanner scanner) {
        this.sharedSum = sharedSum;
        this.scanner = scanner;
        this.localSum = 0;
    }

    public long getLocalSum() {
        return localSum;
    }

    @Override
    public void run() {
        try {
            long number;
            while (true) {
                synchronized (scanner) {
                    if (scanner.hasNextLong()) {
                        number = scanner.nextLong();
                    } else {
                        break;
                    }
                }
                localSum += number;
                sharedSum.addToSum(number);
            }
        } catch (Exception e) {
            System.err.println("An error occurred in SumThread: " + e.getMessage());
        }
    }

}
