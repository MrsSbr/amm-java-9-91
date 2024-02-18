package ru.arsentev.solution;

import ru.arsentev.entities.Cat;
import ru.arsentev.entities.Color;
import ru.arsentev.entities.Gender;
import ru.arsentev.serializers.MethodsSerializer;

public class CheckSerializeSolution {
    private static final Cat cat1;
    private static final Cat cat2;

    static {
        cat1 = new Cat(null, 1, 2.5, Color.BLACK, Gender.MALE, true);
        cat2 = new Cat("Vasya", 3, 2, Color.BLUE, Gender.FEMALE, false);

    }

    public static void checkTemplateSerializeJsonObjectMethod() {
        System.out.println("TemplateSerializeJsonObjectMethod:");
        try {
            System.out.println(cat1);
            System.out.println(MethodsSerializer.templateSerializeJsonObjectMethod(cat1));
            System.out.println(cat2);
            System.out.println(MethodsSerializer.templateSerializeJsonObjectMethod(cat2));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkTemplateSerializeJsonManualMethod() {
        System.out.println("TemplateSerializeJsonManualMethod:");
        try {
            System.out.println(cat1);
            System.out.println(MethodsSerializer.templateSerializeJsonManualMethod(cat1));
            System.out.println(cat2);
            System.out.println(MethodsSerializer.templateSerializeJsonManualMethod(cat2));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkCatSerializeJsonStdCatMethod() {
        System.out.println("CatSerializeJsonStdCatMethod:");
        try {
            System.out.println(cat1);
            System.out.println(MethodsSerializer.catSerializeJsonStdCatMethod(cat1));
            System.out.println(cat2);
            System.out.println(MethodsSerializer.catSerializeJsonStdCatMethod(cat2));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkTemplateMySerializeJsonMethod() {
        System.out.println("TemplateMySerializeJsonMethod");
        try {
            System.out.println(cat1);
            System.out.println(MethodsSerializer.templateMySerializeJsonMethod(cat1));
            System.out.println(cat2);
            System.out.println(MethodsSerializer.templateMySerializeJsonMethod(cat2));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
}
