package ru.arsentev.solution;

import ru.arsentev.entities.Cat;
import ru.arsentev.entities.Color;
import ru.arsentev.entities.Gender;
import ru.arsentev.serializers.JsonManualSerializer;

public class CheckSerializeSolution {
    private static final Cat cat1;
    private static final Cat cat2;
    private static final Cat cat3;

    static {
        cat1 = new Cat(null, 1, 2.5, Color.BLACK, Gender.MALE, true);
        cat2 = new Cat("Vas\"ya", 3, 2, Color.BLUE, Gender.FEMALE, false);
        cat3 = new Cat("Ivani", 10, 12.5, Color.BLACK, Gender.MALE, true);

    }

    public static void checkManualSerialize() {
        System.out.println("TemplateMySerializeJsonMethod");
        try {
            System.out.println(cat1);
            System.out.println(JsonManualSerializer.serialize(cat1));
            System.out.println(cat2);
            System.out.println(JsonManualSerializer.serialize(cat2));
            System.out.println(cat3);
            System.out.println(JsonManualSerializer.serialize(cat3));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
