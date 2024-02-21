package ru.arsentev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumThreadTest {
    @BeforeEach
    public void setup() {
        RandomSumThreads.numbersPool.clear(); // Очищаем пул перед каждым тестом
        RandomSumThreads.inputFinished = false; // Убедимся, что флаг ввода сброшен
    }

    @Test
    public void testSumThreadCalculatesCorrectSum() throws InterruptedException {
        RandomSumThreads.numbersPool.add(1);
        RandomSumThreads.numbersPool.add(2);
        RandomSumThreads.numbersPool.add(3);
        RandomSumThreads.inputFinished = true; // Имитация завершения ввода

        AtomicInteger totalSum = new AtomicInteger(0);
        SumThread sumThread = new SumThread(totalSum);
        sumThread.start();
        sumThread.join(); // Дождемся завершения потока

        assertEquals(6, sumThread.getLocalSum()); // Проверяем, что сумма чисел корректна
    }
    @Test
    public void testSumThreadCompletesWithEmptyList() throws InterruptedException {
        RandomSumThreads.inputFinished = true; // Имитация завершения ввода

        AtomicInteger totalSum = new AtomicInteger(0);
        SumThread sumThread = new SumThread(totalSum);
        sumThread.start();
        sumThread.join(); // Дождемся завершения потока

        assertEquals(0, sumThread.getLocalSum()); // Проверка, что локальная сумма равна 0
    }

}