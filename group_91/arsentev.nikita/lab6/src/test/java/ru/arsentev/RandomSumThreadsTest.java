package ru.arsentev;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class RandomSumThreadsTest {
    @Test
    public void testTotalSumCalculation() throws InterruptedException {
        RandomSumThreads.numbersPool.add(4);
        RandomSumThreads.numbersPool.add(5);
        RandomSumThreads.numbersPool.add(5);
        RandomSumThreads.numbersPool.add(5);
        RandomSumThreads.numbersPool.add(5);
        RandomSumThreads.numbersPool.add(5);
        RandomSumThreads.inputFinished = true; // Имитация завершения ввода

        AtomicInteger totalSum = new AtomicInteger(0);
        List<SumThread> threads = new ArrayList<>();

        for (int i = 0; i < 2; i++) { // Создаем и запускаем 2 потока для теста
            SumThread thread = new SumThread(totalSum);
            threads.add(thread);
            thread.start();
        }

        for (SumThread thread : threads) {
            thread.join(); // Дождемся завершения всех потоков
        }

        assertEquals(29, totalSum.get()); // Проверяем общую сумму
    }

}