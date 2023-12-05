package org.example;

import java.util.Random;

public enum AlcoholType {
    VODKA, WINE, BEER, WHISKEY;

    public static AlcoholType getRandomType() {
        AlcoholType[] types = values();
        return types[new Random().nextInt(types.length)];
    }
}
