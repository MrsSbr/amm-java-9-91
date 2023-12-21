package org.example;

import java.util.concurrent.atomic.AtomicLong;

public class SharedSum {
    private final AtomicLong totalSum = new AtomicLong(0);

    public void addToSum(long value) {
        totalSum.addAndGet(value);
    }

    public long getTotalSum() {
        return totalSum.get();
    }
}
