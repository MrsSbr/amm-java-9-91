package ru.nikitadenisov.lab3.analyzer;

import java.util.Random;

public class StudentFactory {
    public static Student generateStudent() {
        return new Student(getRandomGender(), getRandomMonth());
    }

    private static Gender getRandomGender() {
        Gender[] genders = Gender.values();

        return genders[new Random().nextInt(genders.length)];
    }

    private static Month getRandomMonth() {
        Month[] months = Month.values();

        return months[new Random().nextInt(months.length)];
    }
}
