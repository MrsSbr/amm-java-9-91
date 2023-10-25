package org.courses;

import java.util.stream.Stream;

public interface StudentsStorage {
    public Stream<Student> getStudentsStream();
}
