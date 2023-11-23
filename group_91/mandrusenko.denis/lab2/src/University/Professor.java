package University;

import java.util.Objects;

public class Professor extends UniversityMember implements Person{
    private String department;

    public Professor(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void work() {
        System.out.println("Обучаю студентов и провожу исследования.");
    }

    @Override
    public String toString() {
        return super.toString() + ", Кафедра: " + department;
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }

        Professor professor = (Professor) object;

        return Objects.equals(department, professor.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }
}
