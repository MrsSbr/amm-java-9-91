package ru.arsentev.solution;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonSyntaxException;
import ru.arsentev.entities.Cat;
import ru.arsentev.deserializer.MethodsDeserializer;

public class CheckDeserializeSolution {
    private static final String jsonString1;
    private static final String jsonString2;

    static {
        jsonString1 = """
                {
                  "name": null,
                  "age": "1",
                  "weight": "2.5",
                  "color": "BLACK",
                  "gender": "MALE",
                  "isPleased": true
                }""";
        jsonString2 = """
                {
                  "name": "Vasya",
                  "age": "3",
                  "weight": "2.0",
                  "color": "BLUE",
                  "gender": "FEMALE",
                  "isPleased": false
                }""";
    }

    public static void checkCatDeserializeJsonStdCatMethod() {
        System.out.println("CatDeserializeJsonStdCatMethod:");
        try {
            System.out.println(jsonString1);
            System.out.println(MethodsDeserializer.catDeserializeJsonStdCatMethod(jsonString1));
            System.out.println(jsonString2);
            System.out.println(MethodsDeserializer.catDeserializeJsonStdCatMethod(jsonString2));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkCatDeserializeBuilderMethod() {
        try {
            System.out.println("CatDeserializeJsonStdCatMethod:");
            System.out.println(jsonString1);
            System.out.println(MethodsDeserializer.catDeserializeBuilderMethod(jsonString1));
            System.out.println(jsonString2);
            System.out.println(MethodsDeserializer.catDeserializeBuilderMethod(jsonString2));
        } catch (JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkTemplateDeserializeMethod() {
        System.out.println("TemplateDeserializeMethod:");
        try {
            System.out.println(jsonString1);
            System.out.println(MethodsDeserializer.templateMyDeserializeMethod(jsonString1, Cat.class));
            System.out.println(jsonString2);
            System.out.println(MethodsDeserializer.templateMyDeserializeMethod(jsonString2, Cat.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
