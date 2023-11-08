package org.courses;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.*;
class StudentSurveyTest {
    private final CertainStudentsStorage studentsStorage = new CertainStudentsStorage(List.of
            (new Student("Василий","Васечкин","Васильевич", Map.of(
                    CoursesTaught.MATHEMATICAL_ANALYSIS,false,
                    CoursesTaught.ALGEBRA,false,
                    CoursesTaught.COMPUTER_SCIENCE,false,
                    CoursesTaught.NUMERICAL_METHODS,false,
                    CoursesTaught.DIFFERENTIAL_EQUATIONS,false,
                    CoursesTaught.PROBABILITY_THEORY,false,
                    CoursesTaught.FUNCTIONAL_ANALYSIS,false),11111111),
            new Student("Петр","Петров","Петрович", Map.of(
                    CoursesTaught.MATHEMATICAL_ANALYSIS,true,
                    CoursesTaught.ALGEBRA,true,
                    CoursesTaught.COMPUTER_SCIENCE,true,
                    CoursesTaught.NUMERICAL_METHODS,true,
                    CoursesTaught.DIFFERENTIAL_EQUATIONS,true,
                    CoursesTaught.PROBABILITY_THEORY,false,
                    CoursesTaught.FUNCTIONAL_ANALYSIS,false),22222222),
            new Student("Михаил","Михайлов","Михайлович", Map.of(
                    CoursesTaught.MATHEMATICAL_ANALYSIS,false,
                    CoursesTaught.ALGEBRA,false,
                    CoursesTaught.COMPUTER_SCIENCE,true,
                    CoursesTaught.NUMERICAL_METHODS,true,
                    CoursesTaught.DIFFERENTIAL_EQUATIONS,true,
                    CoursesTaught.PROBABILITY_THEORY,true,
                    CoursesTaught.FUNCTIONAL_ANALYSIS,false),33333333),
            new Student("Александр","Александров","Александрович", Map.of(
                    CoursesTaught.MATHEMATICAL_ANALYSIS,false,
                    CoursesTaught.ALGEBRA,false,
                    CoursesTaught.COMPUTER_SCIENCE,true,
                    CoursesTaught.NUMERICAL_METHODS,true,
                    CoursesTaught.DIFFERENTIAL_EQUATIONS,false,
                    CoursesTaught.PROBABILITY_THEORY,false,
                    CoursesTaught.FUNCTIONAL_ANALYSIS,false),44444444),
            new Student("Сергей","Сергеев","Сергеевич", Map.of(
                    CoursesTaught.MATHEMATICAL_ANALYSIS,true,
                    CoursesTaught.ALGEBRA,false,
                    CoursesTaught.COMPUTER_SCIENCE,true,
                    CoursesTaught.NUMERICAL_METHODS,false,
                    CoursesTaught.DIFFERENTIAL_EQUATIONS,false,
                    CoursesTaught.PROBABILITY_THEORY,false,
                    CoursesTaught.FUNCTIONAL_ANALYSIS,false),55555555)));
    private final CertainStudentsStorage emptyStudentsStorage = new CertainStudentsStorage (new ArrayList<Student>());
    private final CertainStudentsStorage studentsStorageEmptyFeedback = new CertainStudentsStorage (List.of(
            new Student("Марта","Васильева","Сергеевна",Map.of(),11111111)));
private final List<Supplier<Collection<Student>>> listSuppliers = List.of(
        LinkedList::new,
        ArrayList::new,
        HashSet::new
);
    @Test
    void utilityLevelSubject() {
        for(Supplier<Collection<Student>> supplier : listSuppliers) {
            StudentSurvey survey = new StudentSurvey(supplier, studentsStorage);
            assertEquals(3,survey.utilityLevelSubject(CoursesTaught.NUMERICAL_METHODS));
            assertEquals(1,survey.utilityLevelSubject(CoursesTaught.ALGEBRA));
        }
    }
    @Test
    void bestSubjects() {
        for(Supplier<Collection<Student>> supplier : listSuppliers) {
            StudentSurvey survey = new StudentSurvey(supplier, studentsStorage);
            assertEquals(List.of(CoursesTaught.COMPUTER_SCIENCE),survey.bestSubjects());
        }
    }
    @Test
    void studentsCountWithBadReviews() {
        for(Supplier<Collection<Student>> supplier : listSuppliers) {
            StudentSurvey survey = new StudentSurvey(supplier, studentsStorage);
            assertEquals(1,survey.studentsCountWithBadReviews());
        }
    }
    @Test
    void utilityLevelSubjectEmptyCollection() {
        for (Supplier<Collection<Student>> supplier : listSuppliers) {
            StudentSurvey survey = new StudentSurvey(supplier, emptyStudentsStorage);
            assertEquals(0, survey.utilityLevelSubject(CoursesTaught.NUMERICAL_METHODS));
            assertEquals(0, survey.utilityLevelSubject(CoursesTaught.ALGEBRA));
        }
    }
    @Test
    void bestSubjectsEmptyCollection() {
        for (Supplier<Collection<Student>> supplier : listSuppliers) {
            StudentSurvey survey = new StudentSurvey(supplier, emptyStudentsStorage);
            assertEquals(List.of(), survey.bestSubjects());
        }
    }
    @Test
    void studentsCountWithBadReviewsEmptyCollection() {
        for (Supplier<Collection<Student>> supplier : listSuppliers) {
            StudentSurvey survey = new StudentSurvey(supplier, emptyStudentsStorage);
            assertEquals(0, survey.studentsCountWithBadReviews());
        }
    }
    @Test
    void utilityLevelSubjectEmptyFeedback() {
        for(Supplier<Collection<Student>> supplier : listSuppliers) {
            StudentSurvey survey = new StudentSurvey(supplier, studentsStorageEmptyFeedback);
            assertEquals(0,survey.utilityLevelSubject(CoursesTaught.NUMERICAL_METHODS));
            assertEquals(0,survey.utilityLevelSubject(CoursesTaught.ALGEBRA));
        }
    }
    @Test
    void bestSubjectsEmptyFeedback() {
        for (Supplier<Collection<Student>> supplier : listSuppliers) {
            StudentSurvey survey = new StudentSurvey(supplier, studentsStorageEmptyFeedback);
            assertEquals(List.of(), survey.bestSubjects());
        }
    }
    @Test
    void studentsCountWithBadReviewsEmptyFeedback() {
        for (Supplier<Collection<Student>> supplier : listSuppliers) {
            StudentSurvey survey = new StudentSurvey(supplier, studentsStorageEmptyFeedback);
            assertEquals(studentsStorageEmptyFeedback.getCertainStudents().size(), survey.studentsCountWithBadReviews());
        }
    }

}