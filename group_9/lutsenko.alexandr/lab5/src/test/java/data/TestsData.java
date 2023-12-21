package data;

import java.math.BigDecimal;


public class TestsData {

    public static final Student SASHA_STUDENT = new Student(0, "Луценко Александр Сергеевич", BigDecimal.valueOf(0), 3, 9);
    public static final Student STUDENT_WITH_APOSTROPHE = new Student(1, "Джим'хек Свиф'т", BigDecimal.valueOf(3500), 2, 9);

    public static final Person VASILIY_IVANOV = new Person("Василий", "Иванов");
}

