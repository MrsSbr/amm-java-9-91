package org.courses;

public enum CoursesTaught {
    MATHEMATICAL_ANALYSIS ("Математический анализ"),
    ALGEBRA ("Алгебра"),
    COMPUTER_SCIENCE ("Информатика"),
    NUMERICAL_METHODS ("Численные методы"),
    DIFFERENTIAL_EQUATIONS ("Дифференциальные уравнения"),
    PROBABILITY_THEORY ("Теория вероятностей"),
    FUNCTIONAL_ANALYSIS ("Функциональный анализ");
    private final String courseName;
    CoursesTaught(String nameCourse) {
        this.courseName = nameCourse;
    }
    public String getCourseName() {
        return courseName;
    }
}
