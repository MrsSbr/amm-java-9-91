package org.example;

public class Experiment {
    private AlcoholType alcoholType;
    private double amount;
    private boolean peakAchieved;

    public Experiment(AlcoholType alcoholType, double amount, boolean peakAchieved) {
        this.alcoholType = alcoholType;
        this.amount = amount;
        this.peakAchieved = peakAchieved;
    }

    public AlcoholType getAlcoholType() {
        return alcoholType;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPeakAchieved() {
        return peakAchieved;
    }
}
