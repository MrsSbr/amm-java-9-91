package org.example;

import java.util.List;

public class Hive {
    private final List<Double> honeyProductions;

    public Hive(List<Double> honeyProductions) {
        this.honeyProductions = honeyProductions;
    }

    public List<Double> getHoneyProductions() {
        return honeyProductions;
    }
}
