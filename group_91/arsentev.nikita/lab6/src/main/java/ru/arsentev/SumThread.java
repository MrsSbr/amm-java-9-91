package ru.arsentev;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

class SumThread extends Thread {
    private final LongAdder totalSum;
    private long localSum;

    public SumThread(LongAdder totalSum) {
        this.totalSum = totalSum;
        localSum = 0;
    }

    @Override
    public void run() {
        while (!RandomSumThreads.stop.get() || !RandomSumThreads.numbersQueue.isEmpty()) {
            try {
                Integer number = RandomSumThreads.numbersQueue.poll(100, TimeUnit.MILLISECONDS);
                if(number != null) {
                    localSum += number;
                    totalSum.add(number);
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public long getLocalSum() {
        return localSum;
    }
}