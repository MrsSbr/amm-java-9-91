package org.courses;


import java.util.Map;

public class Student {
    private String name;
    private String surname;
    private String patronymic;
    private Map<CoursesTaught, Boolean> feedback; //отзывы студента о предметах
    private final int numberRecordBook;
    public Student (String name, String surname, String patronymic, Map<CoursesTaught, Boolean> feedback, int numberRecordBook) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.feedback = feedback;
        this.numberRecordBook = numberRecordBook;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public Map<CoursesTaught, Boolean> getFeedback() {
        return feedback;
    }
    public int getNumberRecordBook() {
        return numberRecordBook;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public void setFeedback(Map<CoursesTaught, Boolean> feedback) {
        this.feedback = feedback;
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return numberRecordBook == student.numberRecordBook;
    }
    @Override
    public int hashCode() {
        return numberRecordBook;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", feedback=" + feedback +
                ", numberRecordBook=" + numberRecordBook +
                '}';
    }
}
