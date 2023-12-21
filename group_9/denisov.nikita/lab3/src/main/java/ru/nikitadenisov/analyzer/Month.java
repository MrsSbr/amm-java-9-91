package ru.nikitadenisov.analyzer;

import java.util.Random;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public static Month getRandom() {
        return values()[new Random().nextInt(values().length)];
    }
}
