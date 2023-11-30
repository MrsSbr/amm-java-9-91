package University;

import java.util.Objects;

public class Student extends UniversityMember implements Person{
    private int course;

    public Student(String name, int age, int course) {
        super(name, age);
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public void work() {
        System.out.println("Готовлюсь к экзаменам!");
    }

    @Override
    public String toString() {
        return super.toString() + ", Курс: " + course;
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }

        Student student = (Student) object;

        return Objects.equals(course, student.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), course);
    }
}