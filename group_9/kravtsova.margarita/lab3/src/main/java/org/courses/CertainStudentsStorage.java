package org.courses;

import java.util.Collection;
import java.util.stream.Stream;

public class CertainStudentsStorage implements StudentsStorage {
    private Collection<Student> certainStudents;
    public Collection<Student> getCertainStudents() {
        return certainStudents;
    }
    public void setCertainStudents(Collection<Student> certainStudents) {
        this.certainStudents = certainStudents;
    }
    public CertainStudentsStorage(Collection<Student> certainStudents) {
        this.certainStudents = certainStudents;
    }
    @Override
    public Stream<Student> getStudentsStream() {
        return certainStudents.stream();
    }
}
