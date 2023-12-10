package org.example;

import java.util.List;
import java.util.Random;

public class Writer extends Thread {
    private final List<String> poem;
    private final Napkin napkin;
    private final Random random = new Random();

    public Writer(List<String> poem, Napkin napkin) {
        this.poem = poem;
        this.napkin = napkin;
    }

    @Override
    public void run() {
        for (String line : poem) {
            synchronized (napkin) {
                // System.out.println(currentThread().getName()+"  " + line);
                napkin.addLine(line + "\n");
            }
            try {
                int sleepTime = random.nextInt(3000);
                sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
