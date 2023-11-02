package org.courses;

import java.util.*;
import java.util.function.Supplier;

public class ContainerAnalysis {
    public static void main(String[] args) {
        List<Supplier<Collection<Student>>> suppliersCollections = List.of(
                LinkedList::new,
                ArrayList::new,
                HashSet::new
        );
        List<String> namesColletions = List.of("LinkedList", "ArrayList", "HashSet");
        List<String> namesMethods = List.of("utilityLevelSubject", "bestSubjects", "studentsCountWithBadReviews");
        int indexCollection = 0;
        for (Supplier<Collection<Student>> supplier : suppliersCollections) {
            StudentSurvey survey = new StudentSurvey(supplier, new RandomStudentsStorage(550));
            long time = System.nanoTime();
            survey.utilityLevelSubject(CoursesTaught.FUNCTIONAL_ANALYSIS);
            System.out.println("Время работы контейнера " +  namesColletions.get(indexCollection) + " в методе " +
                    namesMethods.get(0) + " составило " + (System.nanoTime() - time) + " наносекунд");
            time = System.nanoTime();
            survey.bestSubjects();
            System.out.println("Время работы контейнера " +  namesColletions.get(indexCollection) + " в методе " +
                    namesMethods.get(1) + " составило " + (System.nanoTime() - time) + " наносекунд");
            time = System.nanoTime();
            survey.studentsCountWithBadReviews();
            System.out.println("Время работы контейнера " +  namesColletions.get(indexCollection) + " в методе " +
                    namesMethods.get(2) + " составило " + (System.nanoTime() - time) + " наносекунд");
            indexCollection ++;
            System.out.println();
        }
    }
}