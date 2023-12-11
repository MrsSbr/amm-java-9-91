package org.example;

public class Experiment {
    private final AlcoholType alcoholType;
    private final double amount;
    private final boolean peakAchieved;

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
