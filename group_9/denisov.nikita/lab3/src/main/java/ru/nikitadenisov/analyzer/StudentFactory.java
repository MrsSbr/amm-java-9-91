package ru.nikitadenisov.analyzer;

public class StudentFactory {
    public static Student generateStudent() {
        return new Student(getRandomGender(), getRandomMonth());
    }

    private static Gender getRandomGender() {
        return Gender.getRandom();
    }

    private static Month getRandomMonth() {
        return Month.getRandom();
    }
}
