package ru.nikitadenisov.analyzer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.EnumSet;
import java.util.Vector;

public class DemographicAnalyzer {
    private final Collection<Student> students;

    public DemographicAnalyzer(Collection<Student> students) {
        this.students = students;
    }

    // Число студентов мужского и женского пола, родившихся в каждом месяце.
    public List<List<Long>> numberStudentsBornInMonths() {
        List<Long> maleCounts = new ArrayList<>(Collections.nCopies(Month.values().length, 0L));
        List<Long> femaleCounts = new ArrayList<>(Collections.nCopies(Month.values().length, 0L));

        students.forEach(student -> {
            int monthIndex = student.getBirthMonth().ordinal();

            if (student.getGender() == Gender.MALE) {
                maleCounts.set(monthIndex, maleCounts.get(monthIndex) + 1);
            } else {
                femaleCounts.set(monthIndex, femaleCounts.get(monthIndex) + 1);
            }
        });

        List<List<Long>> counts = new ArrayList<>();
        counts.add(maleCounts);
        counts.add(femaleCounts);

        return counts;
    }

    // Месяцы, в которых родилось больше женщин, чем мужчин.
    public List<Month> monthsWithMoreFemalesThanMales() {
        Vector<Integer> numberFemaleMonths = monthsByGender(Gender.FEMALE);
        Vector<Integer> numberMaleMonths = monthsByGender(Gender.MALE);

        return EnumSet.allOf(Month.class).stream()
                .filter(month -> numberFemaleMonths.get(month.ordinal()) > numberMaleMonths.get(month.ordinal()))
                .toList();
    }

    private Vector<Integer> monthsByGender(Gender gender) {
        Vector<Integer> counts = new Vector<>(Collections.nCopies(Month.values().length, 0));

        students.stream()
                .filter(student -> student.getGender() == gender)
                .map(Student::getBirthMonth)
                .forEach(month -> counts.setElementAt(counts.get(month.ordinal()) + 1, month.ordinal()));

        return counts;
    }
}
