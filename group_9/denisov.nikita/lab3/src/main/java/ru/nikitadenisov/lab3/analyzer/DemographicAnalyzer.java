package ru.nikitadenisov.lab3.analyzer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemographicAnalyzer {
    private final Collection<Student> students;

    public DemographicAnalyzer(Collection<Student> students) {
        this.students = students;
    }

    // Количество человек, родившихся в определенный месяц.
    public long numberStudentsInMonth(Month month) {
        return students.stream()
                .filter(student -> student.getBirthMonth() == month)
                .count();
    }

    // Месяцы, в которых родилось больше женщин, чем мужчин.
    public List<Month> monthsWithMoreFemalesThanMales() {
        return Arrays.stream(Month.values())
                .filter(this::moreFemalesThanMalesInMonth)
                .collect(Collectors.toList());
    }

    private boolean moreFemalesThanMalesInMonth(Month month) {
        long femaleNumber = students.stream()
                .filter(student -> student.getBirthMonth() == month &&
                        student.getGender() == Gender.FEMALE)
                .count();

        long maleCount = students.stream()
                .filter(student -> student.getBirthMonth() == month &&
                        student.getGender() == Gender.MALE)
                .count();

        return femaleNumber > maleCount;
    }
}
