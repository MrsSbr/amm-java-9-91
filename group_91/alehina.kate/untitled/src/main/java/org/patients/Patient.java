package org.patients;

import java.util.Objects;
import java.time.LocalDate;

public class Patient {
    private String surname;
    private String name;
    private String patronymic;
    private final FluorogramResult result;
    private final LocalDate date;

    public Patient(String surname, String name, String patronymic, FluorogramResult result, LocalDate date) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.result = result;
        this.date = date;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public FluorogramResult getResult() {
        return result;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(surname, patient.surname) &&
                Objects.equals(name, patient.name) &&
                Objects.equals(patronymic, patient.patronymic) &&
                result == patient.result && Objects.equals(date, patient.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, patronymic, result, date);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", result=" + result +
                ", date=" + date +
                '}';
    }
}