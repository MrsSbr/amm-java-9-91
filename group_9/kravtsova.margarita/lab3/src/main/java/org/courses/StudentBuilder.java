package org.courses;
import java.util.Map;

public class StudentBuilder {
    private String name;
    private String surname;
    private String patronymic;
    private Map<CoursesTaught, Boolean> feedback; //отзывы студента о предметах
    private int numberRecordBook;
    public StudentBuilder withName(String name) {
        this.name = name;
        return this;
    }
    public StudentBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public StudentBuilder withPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }
    public StudentBuilder withFeedback(Map<CoursesTaught, Boolean> feedback) {
        this.feedback = feedback;
        return this;
    }
    public StudentBuilder withNumberRecordBook(int number) {
        this.numberRecordBook = number;
        return this;
    }
    public Student build() {
        return new Student(name,surname,patronymic,feedback,numberRecordBook);
    }
}
