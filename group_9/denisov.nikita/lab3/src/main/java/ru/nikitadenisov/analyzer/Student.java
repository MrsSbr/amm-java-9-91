package ru.nikitadenisov.analyzer;

public class Student {
    private final Gender gender;
    private final Month birthMonth;

    public Student(Gender gender, Month birthMonth) {
        this.gender = gender;
        this.birthMonth = birthMonth;
    }

    public Gender getGender() {
        return gender;
    }

    public Month getBirthMonth() {
        return birthMonth;
    }
}
