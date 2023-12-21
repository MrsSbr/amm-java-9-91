package org.example.summator;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Reader extends Thread {
    private Integer localAmount;
    private AtomicInteger totalAmount;
    private final Scanner scanner;

    public Reader(Scanner scanner, AtomicInteger totalAmount) {
        this.scanner = scanner;
        this.totalAmount = totalAmount;
        localAmount = 0;
    }

    public Integer getLocalAmount() {
        return localAmount;
    }

    public AtomicInteger getTotalAmount() {
        return totalAmount;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setLocalAmount(Integer localAmount) {
        this.localAmount = localAmount;
    }

    public void setTotalAmount(AtomicInteger totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public void run() {
        int value;
        while (true) {
            synchronized (scanner) {
                if (scanner.hasNextInt()) {
                    value = scanner.nextInt();
                } else {
                    break;
                }
            }
            localAmount += value;
            totalAmount.addAndGet(value);
        }
    }
}
