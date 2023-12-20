package org.example;

import java.util.Scanner;

public class NumberThread extends Thread {
    private final NumberProcessor numberProcessor;
    private final Scanner scanner;
    private int threadSum;

    public NumberThread(NumberProcessor numberProcessor, Scanner scanner) {
        this.numberProcessor = numberProcessor;
        this.scanner = scanner;
        threadSum = 0;
    }

    public int getThreadSum() {
        return threadSum;
    }

    @Override
    public void run() {
        int input;

        while(true) {
            synchronized (scanner) {
                input = scanner.nextInt();
            }
            if (input == 0) {
                break;
            }
            threadSum = threadSum + input;
            numberProcessor.processNumber(input);
        }
    }
}
