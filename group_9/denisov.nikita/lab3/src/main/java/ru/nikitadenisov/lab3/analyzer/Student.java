package ru.nikitadenisov.lab3.analyzer;

public class Student {
    private Gender gender;
    private Month birthMonth;

    public Student(Gender gender, Month birthMonth) {
        this.gender = gender;
        this.birthMonth = birthMonth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Month getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Month birthMonth) {
        this.birthMonth = birthMonth;
    }
}
