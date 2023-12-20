package org.example;

import java.util.List;

public interface TribeInterface {
    public List<String> getHunters(List<Hunt> hunts);

    public int getTotalWeight(List<Hunt> hunts, int year, int month, int day);

    public List<String> getHunterWeights(List<Hunt> hunts);
}
