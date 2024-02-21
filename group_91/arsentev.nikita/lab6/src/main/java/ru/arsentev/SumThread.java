package ru.arsentev;

import java.util.concurrent.atomic.AtomicInteger;

import static ru.arsentev.RandomSumThreads.numbersPool;

class SumThread extends Thread {
    private final AtomicInteger totalSum;
    private int localSum = 0;

    public SumThread(AtomicInteger totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public void run() {
        while (!RandomSumThreads.inputFinished.get() || !numbersPool.isEmpty()) {
            Integer number = null;
            synchronized (numbersPool) {
                if (!numbersPool.isEmpty()) {
                    number = numbersPool.remove(0); // Извлечение числа из пула
                }
            }
            if (number != null) {
                localSum += number;
                totalSum.addAndGet(number);
            }
        }
        System.out.println("Local sum for thread " + this.threadId() + ": " + localSum);
    }

    public int getLocalSum() {
        return localSum;
    }
}