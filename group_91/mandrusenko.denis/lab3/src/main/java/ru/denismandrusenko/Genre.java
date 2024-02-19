package ru.denismandrusenko;

import java.util.Random;

public enum Genre {
    CARD,
    ROLEPLAY,
    STRATEGY,
    PUZZLE;

    public static Genre getRandom() {
        return values()[new Random().nextInt(values().length)];
    }
}
