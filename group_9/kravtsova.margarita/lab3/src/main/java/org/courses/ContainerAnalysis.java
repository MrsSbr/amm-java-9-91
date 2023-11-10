package org.courses;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContainerAnalysis {
    public static void main(String[] args) {
        List<Supplier<Collection<Student>>> suppliersCollections = List.of(
                LinkedList::new,
                ArrayList::new,
                HashSet::new
        );
        List<String> namesCollections = List.of("LinkedList", "ArrayList", "HashSet");
        List<String> namesMethods = List.of("utilityLevelSubject", "bestSubjects", "studentsCountWithBadReviews");
        int indexCollection = 0;
        final int countTest = 10;
        for (Supplier<Collection<Student>> supplier : suppliersCollections) {
            StudentSurvey survey = new StudentSurvey(supplier, getGeneratedListStudents(550));
            List<Long> timeMethods = new ArrayList<>(List.of(0L, 0L, 0L));
            for(int i = 0; i < countTest; ++i) {
                long time = System.nanoTime();
                survey.utilityLevelSubject(CoursesTaught.FUNCTIONAL_ANALYSIS);
                timeMethods.set(0, timeMethods.get(0) + System.nanoTime() - time);
                time = System.nanoTime();
                survey.bestSubjects();
                timeMethods.set(1, timeMethods.get(1) + System.nanoTime() - time);
                time = System.nanoTime();
                survey.studentsCountWithBadReviews();
                timeMethods.set(2, timeMethods.get(2) + System.nanoTime() - time);
            }
            System.out.println("Время работы контейнера " + namesCollections.get(indexCollection) + " в методе " +
                    namesMethods.get(0) + " составило в среднем " + timeMethods.get(0)/countTest + " наносекунд");
            System.out.println("Время работы контейнера " + namesCollections.get(indexCollection) + " в методе " +
                    namesMethods.get(1) + " составило в среднем " + timeMethods.get(1)/countTest + " наносекунд");
            System.out.println("Время работы контейнера " + namesCollections.get(indexCollection) + " в методе " +
                    namesMethods.get(2) + " составило в среднем " + timeMethods.get(2)/countTest + " наносекунд");
            System.out.println();
            indexCollection++;
        }
    }
    public static List<Student> getGeneratedListStudents(int countStudents) {
        return Stream.generate(StudentFactory::generateStudent)
                     .limit(countStudents)
                     .collect(Collectors.toList());
    }
}
