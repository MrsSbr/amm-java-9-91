package ru.nikitadenisov.analyzer;

import java.util.Random;

public enum Gender {
    MALE,
    FEMALE;

    public static Gender getRandom() {
        return values()[new Random().nextInt(values().length)];
    }
}
