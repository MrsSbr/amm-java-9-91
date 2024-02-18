package ru.arsentev.serializers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.arsentev.entities.Cat;
import ru.arsentev.entities.Color;
import ru.arsentev.entities.Gender;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MethodsSerializerTest {

    String createJsonString(String name, int age, double weight, Color color, Gender gender, boolean isPleased) {
        String expected = "{\n  ";
        if (name != null) {
            expected += "\"name\": \"" + name + "\",\n  ";
        } else {
            expected += "\"name\": null,\n  ";
        }
        expected = expected
                + "\"age\": \"" + age + "\",\n  "
                + "\"weight\": \"" + weight + "\",\n  "
                + "\"color\": \"" + color + "\",\n  "
                + "\"gender\": \"" + gender + "\",\n  "
                + "\"isPleased\": " + isPleased + "\n}";
        return expected;
    }

    boolean checkString(String json, String name, int age, double weight,
                        Color color, Gender gender, boolean isPleased) {
        return (!Objects.equals(name, "null") ? json.contains("\"name\": \"" + name + "\"") : json.contains("\"name\": null"))
                && json.contains("\"age\": \"" + age + "\"") && json.contains("\"weight\": \"" + weight + "\"")
                && json.contains("\"color\": \"" + color + "\"") && json.contains("\"gender\": \"" + gender + "\"")
                && json.contains("\"isPleased\": " + isPleased);
    }

    @ParameterizedTest
    @CsvSource({
            "Whiskers, 3, 4.5, BLACK, MALE, true",
            "null, 0, 0.0, RED, FEMALE, false"
    })
    void testSerializeOrderCat(String name, int age, double weight, Color color, Gender gender, boolean isPleased) {
        Cat cat = new Cat(name, age, weight, color, gender, isPleased);

        String jsonManual = MethodsSerializer.templateSerializeJsonManualMethod(cat);
        String jsonMy = MethodsSerializer.templateMySerializeJsonMethod(cat);

        String expected = createJsonString(name, age, weight, color, gender, isPleased);

        assertEquals(expected, jsonManual);
        assertEquals(expected, jsonMy);
    }

    @ParameterizedTest
    @CsvSource({
            "Whiskers, 3, 4.5, BLACK, MALE, true",
            "null, 0, 0.0, RED, FEMALE, false"
    })
    void testSerializeNotOrderCat(String name, int age, double weight, Color color, Gender gender, boolean isPleased) {
        Cat cat = new Cat(name, age, weight, color, gender, isPleased);
        String jsonObject = MethodsSerializer.templateSerializeJsonObjectMethod(cat);
        String jsonStd = MethodsSerializer.catSerializeJsonStdCatMethod(cat);

        assertTrue(checkString(jsonObject, name, age, weight, color, gender, isPleased));
        assertTrue(checkString(jsonStd, name, age, weight, color, gender, isPleased));
    }
}