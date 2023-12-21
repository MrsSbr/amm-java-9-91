package org.example;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Bartender extends Thread {
    private final Semaphore weedSmokerSemaphore;
    private final Semaphore paperSmokerSemaphore;
    private final Semaphore matchesSmokerSemaphore;
    private final Random random;
    private Smoker weedSmoker;
    private Smoker paperSmoker;
    private Smoker matchesSmoker;

    private boolean shouldProcess;

    public Bartender(Random random) {
        weedSmokerSemaphore = new Semaphore(0);
        paperSmokerSemaphore = new Semaphore(0);
        matchesSmokerSemaphore = new Semaphore(0);
        this.random = random;

        shouldProcess = true;
    }

    public Semaphore getWeedSmokerSemaphore() {
        return weedSmokerSemaphore;
    }

    public Semaphore getPaperSmokerSemaphore() {
        return paperSmokerSemaphore;
    }

    public Semaphore getMatchesSmokerSemaphore() {
        return matchesSmokerSemaphore;
    }

    public void setWeedSmoker(Smoker weedSmoker) {
        this.weedSmoker = weedSmoker;
    }

    public void setPaperSmoker(Smoker paperSmoker) {
        this.paperSmoker = paperSmoker;
    }

    public void setMatchesSmoker(Smoker matchesSmoker) {
        this.matchesSmoker = matchesSmoker;
    }

    @Override
    public void run() {
        List<Semaphore> semaphores = List.of(weedSmokerSemaphore, matchesSmokerSemaphore, paperSmokerSemaphore);
        List<Smoker> smokers = List.of(weedSmoker, matchesSmoker, paperSmoker);

        while (shouldProcess) {

            try {
                int index = random.nextInt(semaphores.size());
                Semaphore chosenSemaphore = semaphores.get(index);
                Smoker chosenSmoker = smokers.get(index);
                System.out.printf("Бармен выдал компоненты курильщику %s\n", chosenSmoker.getComponentName());
                chosenSmoker.getSmokerSemaphore().acquire();
                chosenSemaphore.release();
                chosenSmoker.getSmokerSemaphore().release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopSmoking() {
        shouldProcess = false;
    }
}
