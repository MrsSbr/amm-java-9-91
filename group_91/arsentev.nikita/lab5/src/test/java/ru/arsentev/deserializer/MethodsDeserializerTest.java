package ru.arsentev.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonSyntaxException;
import org.junit.jupiter.api.Test;
import ru.arsentev.entities.Cat;
import ru.arsentev.entities.Color;
import ru.arsentev.entities.Gender;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MethodsDeserializerTest {

    boolean checkCat(Cat cat, String name, int age, double weight,
                     Color color, Gender gender, boolean isPleased) {
        Cat localCat = new Cat(name, age, weight, color, gender, isPleased);
        return localCat.equals(cat);
    }

    @Test
    void testDeserializeCat() throws Exception {
        String json = "{\"name\":\"Whiskers\",\"age\":\"4\",\"weight\":\"5.5\",\"color\":\"RED\",\"gender\":\"FEMALE\",\"isPleased\":false}";

        Cat cat1 = MethodsDeserializer.catDeserializeJsonStdCatMethod(json);
        Cat cat2 = MethodsDeserializer.templateMyDeserializeMethod(json, Cat.class);
        Cat cat3 = MethodsDeserializer.catDeserializeBuilderMethod(json);

        assertTrue(checkCat(cat1, "Whiskers", 4, 5.5, Color.RED, Gender.FEMALE, false));
        assertTrue(checkCat(cat2, "Whiskers", 4, 5.5, Color.RED, Gender.FEMALE, false));
        assertTrue(checkCat(cat3, "Whiskers", 4, 5.5, Color.RED, Gender.FEMALE, false));
    }

    @Test
    void testDeserializeCatWithNullString() throws Exception {
        String json = "{\"name\":null,\"age\":3,\"weight\":4.5,\"color\":\"BLACK\",\"gender\":\"MALE\",\"isPleased\":true}";

        Cat cat1 = MethodsDeserializer.catDeserializeJsonStdCatMethod(json);
        Cat cat2 = MethodsDeserializer.templateMyDeserializeMethod(json, Cat.class);
        Cat cat3 = MethodsDeserializer.catDeserializeBuilderMethod(json);

        assertTrue(checkCat(cat1, null, 3, 4.5, Color.BLACK, Gender.MALE, true));
        assertTrue(checkCat(cat2, null, 3, 4.5, Color.BLACK, Gender.MALE, true));
        assertTrue(checkCat(cat3, null, 3, 4.5, Color.BLACK, Gender.MALE, true));
    }

    @Test
    void testDeserializeInvalid() {
        String json = "invalid json";
        assertThrows(JsonProcessingException.class, () -> MyJsonDeserializer.deserialize(json, Cat.class));
        assertThrows(JsonSyntaxException.class, () -> JsonBuilderDeserializer.deserialize(json));
        assertThrows(JsonProcessingException.class, () -> JsonStdCatDeserializer.deserialize(json));
    }

    @Test
    void testDeserializeInvalidJsonOnMethod() {
        String json = "invalid json";
        assertThrows(IllegalArgumentException.class, () -> MethodsDeserializer.templateMyDeserializeMethod(json, Cat.class));
        assertThrows(IllegalArgumentException.class, () -> MethodsDeserializer.catDeserializeJsonStdCatMethod(json));
        assertThrows(IllegalArgumentException.class, () -> MethodsDeserializer.catDeserializeBuilderMethod(json));
    }

}