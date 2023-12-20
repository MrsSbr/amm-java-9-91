package org.example;

public class NumberProcessor {
    private int totalSum = 0;

    public synchronized void processNumber(int number) {
        totalSum += number;
    }

    public int getTotalSum() {
        return totalSum;
    }
}
