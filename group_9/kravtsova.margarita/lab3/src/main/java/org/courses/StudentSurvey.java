package org.courses;
import java.util.*;
import java.util.function.Supplier;


public class StudentSurvey {
    private final Collection<Student> students;
    public StudentSurvey(Supplier<Collection<Student>> supplier, StudentsStorage storage) {
        students = storage.getStudentsStream().collect(supplier, Collection::add, Collection::addAll);
    }
    public long utilityLevelSubject(CoursesTaught course) {                         //кол-во студентов, которые назвали предмет course полезным
           return students.stream()
                   .filter(student -> Boolean.TRUE.equals(student.getFeedback().get(course)))
                   .count();
    }
    public List<CoursesTaught> bestSubjects() {                                     //предмет(ы) с наибольшей оценкой
        Map<CoursesTaught, Long> evaluations = new HashMap<>();
        List<CoursesTaught> bestCourses = new ArrayList<>();

        students.stream()
                .flatMap(student -> student.getFeedback().entrySet().stream())
                .filter(entry -> entry.getValue())
                .forEach(entry -> evaluations.merge(entry.getKey(),1L,Long::sum));
        evaluations.entrySet().stream()
                              .forEach(entry -> {
                                  if (bestCourses.isEmpty()) {
                                      bestCourses.add(entry.getKey());
                                  } else if (evaluations.get(bestCourses.get(0)) < entry.getValue()) {
                                          bestCourses.clear();
                                          bestCourses.add(entry.getKey());
                                  } else if (evaluations.get(bestCourses.get(0)).equals(entry.getValue())) {
                                          bestCourses.add(entry.getKey());
                                      }
                              });
        return bestCourses;
    }
    public Long studentsCountWithBadReviews() {                                      //кол-во студентов, не оценивших положительно ни один предмет
        return students.stream()
                .filter(student -> student.getFeedback()
                                        .values()
                                        .stream()
                                        .noneMatch(Boolean::booleanValue))
                                        .count();
    }
}