package ru.nikitadenisov.lab3.analyzer;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DemographicAnalyzer {
    private final Collection<Student> students;

    public DemographicAnalyzer(Collection<Student> students) {
        this.students = students;
    }

    // Количество человек, родившихся в определенный месяц.
    public long numberStudentsBornInMonth(Month month) {
        return students.stream()
                .filter(student -> student.getBirthMonth() == month)
                .count();
    }

    // Месяцы, в которых родилось больше женщин, чем мужчин.
    public List<Month> monthsWithMoreFemalesThanMales() {
        List<Month> femaleMonths = monthsByGender(Gender.FEMALE);
        List<Month> maleMonths = monthsByGender(Gender.MALE);

        maleMonths.forEach(femaleMonths::remove);

        return femaleMonths.stream().distinct().toList();
    }

    private List<Month> monthsByGender(Gender gender) {
        return students.stream()
                .filter(student -> student.getGender() == gender)
                .map(Student::getBirthMonth)
                .collect(Collectors.toList());
    }
}
