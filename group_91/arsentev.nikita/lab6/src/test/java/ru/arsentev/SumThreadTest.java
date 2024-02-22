package ru.arsentev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.LongAdder;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumThreadTest {
    @BeforeEach
    public void setup() {
        RandomSumThreads.numbersQueue.clear();
        RandomSumThreads.stop.set(false);
    }

    @Test
    public void testSumThreadCalculatesCorrectSum() throws InterruptedException {
        RandomSumThreads.numbersQueue.add(1);
        RandomSumThreads.numbersQueue.add(2);
        RandomSumThreads.numbersQueue.add(3);
        RandomSumThreads.stop.set(true);

        LongAdder totalSum = new LongAdder();
        SumThread sumThread = new SumThread(totalSum);
        sumThread.start();
        sumThread.join();

        assertEquals(6, sumThread.getLocalSum());
    }

    @Test
    public void testSumThreadCompletesWithEmptyList() throws InterruptedException {
        RandomSumThreads.stop.set(true);

        LongAdder totalSum = new LongAdder();
        SumThread sumThread = new SumThread(totalSum);
        sumThread.start();
        sumThread.join();

        assertEquals(0, sumThread.getLocalSum()); // Проверка, что локальная сумма равна 0
    }

    @Test
    public void testSumThreadWhenAddAfterStop() throws InterruptedException {
        RandomSumThreads.numbersQueue.add(1);
        RandomSumThreads.numbersQueue.add(2);
        RandomSumThreads.numbersQueue.add(3);
        RandomSumThreads.stop.set(true);

        LongAdder totalSum = new LongAdder();
        SumThread sumThread = new SumThread(totalSum);
        sumThread.start();
        sumThread.join();
        RandomSumThreads.numbersQueue.add(3);

        assertEquals(6, sumThread.getLocalSum());
    }

}