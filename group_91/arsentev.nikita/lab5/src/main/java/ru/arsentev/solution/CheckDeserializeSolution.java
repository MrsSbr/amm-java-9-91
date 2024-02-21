package ru.arsentev.solution;

import ru.arsentev.deserializer.JsonManualDeserializer;
import ru.arsentev.entities.Cat;

public class CheckDeserializeSolution {
    private static final String jsonString1;
    private static final String jsonString2;
    private static final String jsonString3;

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
                  "name": "Vas\"ya",
                  "age": "3",
                  "weight": "2.0",
                  "color": "BLUE",
                  "gender": "FEMALE",
                  "isPleased": false
                }""";
        jsonString3 = """
                {
                  "name": "Ivano",
                  "age": "10",
                  "weight": "12.5",
                  "color": "BLACK",
                  "gender": "MALE",
                  "isPleased": true
                }""";
    }

    public static void checkManualDeserializer() {
        System.out.println("ManualDeserializer:");
        try {
            System.out.println(jsonString1);
            System.out.println(JsonManualDeserializer.deserialize(jsonString1, Cat.class));
            System.out.println(jsonString2);
            System.out.println(JsonManualDeserializer.deserialize(jsonString2, Cat.class));
            System.out.println(jsonString3);
            System.out.println(JsonManualDeserializer.deserialize(jsonString3, Cat.class));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
