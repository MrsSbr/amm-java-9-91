package org.courses;

import java.util.stream.Stream;

public class RandomStudentsStorage implements StudentsStorage {
    private int countStudents;
    public RandomStudentsStorage(int countStudents) {
        this.countStudents = countStudents;
    }
    public int getCountStudents() {
        return countStudents;
    }
    public void setCountStudents(int countStudents) {
        this.countStudents = countStudents;
    }
    @Override
    public Stream<Student> getStudentsStream() {
        return Stream.generate(StudentFactory::generateStudent).limit(countStudents);
    }
}
