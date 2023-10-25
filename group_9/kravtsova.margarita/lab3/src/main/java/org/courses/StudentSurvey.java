package org.courses;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentSurvey {
    private final Collection<Student> students;
    public StudentSurvey(Supplier<Collection<Student>> supplier, StudentsStorage storage) {
        students = storage.getStudentsStream().collect(supplier, Collection::add, Collection::addAll);
    }
    public long utilityLevelSubject(CoursesTaught course) {                         //кол-во студентов, которые назвали предмет course полезным
        return students
                .stream()
                .filter(student -> student.getFeedback().get(course))
                .count();
    }
    public Set<CoursesTaught> bestSubjects() {                                     //предмет(ы) с наибольшей оценкой
        Map<CoursesTaught, Long> evaluations = new HashMap<>();
        Set<CoursesTaught> bestCourses =  new HashSet<>();
        Stream.of(CoursesTaught.values())
              .forEach(subject -> evaluations.put(subject, utilityLevelSubject(subject)));
        Long maxEstimation = evaluations
                             .values()
                             .stream()
                             .max(Long::compareTo)
                             .get();
        evaluations
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(maxEstimation))
                .forEach(entry -> bestCourses.add(entry.getKey()));
        return bestCourses;
    }
    public Long studentsCountWithBadReviews() {                                      //кол-во студентов, не оценивших положительно ни один предмет
        return students
                .stream()
                .filter(student -> student.getFeedback()
                        .values()
                        .stream().noneMatch(Boolean::booleanValue))
                .count();
    }
}