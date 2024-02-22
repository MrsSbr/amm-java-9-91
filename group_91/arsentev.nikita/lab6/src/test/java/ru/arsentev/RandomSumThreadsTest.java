package ru.arsentev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RandomSumThreadsTest {
    @Test
    public void testTotalSumCalculation() throws InterruptedException {
        RandomSumThreads.numbersQueue.add(4);
        RandomSumThreads.numbersQueue.add(5);
        RandomSumThreads.numbersQueue.add(5);
        RandomSumThreads.numbersQueue.add(5);
        RandomSumThreads.numbersQueue.add(5);
        RandomSumThreads.numbersQueue.add(5);

        LongAdder totalSum = new LongAdder();
        List<SumThread> threads = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            SumThread thread = new SumThread(totalSum);
            threads.add(thread);
            thread.start();
        }

        threads.forEach(Thread::interrupt);

        for (SumThread thread : threads) {
            thread.join();
        }

        assertEquals(29, totalSum.longValue());
    }

}