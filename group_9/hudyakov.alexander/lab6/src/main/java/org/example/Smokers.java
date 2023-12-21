package org.example;

import java.util.Random;

public class Smokers {
    public static void main(String[] args) {
        Random random = new Random();
        Bartender bartender = new Bartender(random);
        Smoker weedSmoker = new Smoker(bartender.getWeedSmokerSemaphore(), "табак", random);
        Smoker paperSmoker = new Smoker(bartender.getPaperSmokerSemaphore(), "бумага", random);
        Smoker matchesSmoker = new Smoker(bartender.getMatchesSmokerSemaphore(), "спички", random);
        bartender.setWeedSmoker(weedSmoker);
        bartender.setPaperSmoker(paperSmoker);
        bartender.setMatchesSmoker(matchesSmoker);
        weedSmoker.start();
        paperSmoker.start();
        matchesSmoker.start();
        bartender.start();
        try {
            Thread.sleep(30000);
            matchesSmoker.stopSmoking();
            weedSmoker.stopSmoking();
            paperSmoker.stopSmoking();
            bartender.stopSmoking();
            matchesSmoker.join();
            weedSmoker.join();
            paperSmoker.join();
            bartender.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Все закончили курить");
    }
}
