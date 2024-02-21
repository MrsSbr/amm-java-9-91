package ru.arsentev.serializers;

import org.junit.jupiter.api.Test;
import ru.arsentev.entities.Cat;
import ru.arsentev.entities.Color;
import ru.arsentev.entities.Gender;

import static org.junit.jupiter.api.Assertions.*;

class JsonManualSerializerTest {
    @Test
    public void testSerializeCat() throws IllegalAccessException {
        Cat cat = new Cat("Whiskers", 5, 4.2, Color.BLACK, Gender.MALE, true);
        String expectedJson = """
                {
                  "name": "Whiskers",
                  "age": "5",
                  "weight": "4.2",
                  "color": "BLACK",
                  "gender": "MALE",
                  "isPleased": true
                }""";
        assertEquals(expectedJson, JsonManualSerializer.serialize(cat).trim());
    }

    @Test
    public void testSerializeStringWithEscapeCharacters() throws IllegalAccessException {
        Cat cat = new Cat("Whis\\kers\nTab\tName", 3, 2.5, Color.WHITE, Gender.FEMALE, false);
        assertTrue(JsonManualSerializer.serialize(cat).contains("\"Whis\\\\kers\\nTab\\tName\""));
    }

    @Test
    public void testSerializeStringWithVariousEscapeSequences() throws IllegalAccessException {
        Cat cat = new Cat("Line1\nLine2\tTab\"Quote", 5, 4.0, Color.BLACK, Gender.MALE, true);
        String json = JsonManualSerializer.serialize(cat);
        assertTrue(json.contains("\"Line1\\nLine2\\tTab\\\"Quote\""));
    }

    @Test
    public void testSerializeWithUninitializedFields() throws IllegalAccessException {
        Cat cat = new Cat();
        cat.setName("Ghost");
        String json = JsonManualSerializer.serialize(cat);
        assertTrue(json.contains("\"name\": \"Ghost\""));
        assertTrue(json.contains("\"age\": \"0\""));
        assertTrue(json.contains("\"weight\": \"0.0\""));
        assertTrue(json.contains("\"gender\": null"));
        assertTrue(json.contains("\"color\": null"));
        assertTrue(json.contains("\"isPleased\": false"));
    }

    @Test
    public void testSerializeNull() {
        assertThrows(NullPointerException.class, () -> {
            JsonManualSerializer.serialize(null);
        });
    }

    @Test
    public void testSerializeNullFields() throws IllegalAccessException {
        Cat cat = new Cat();
        cat.setName(null);
        String json = JsonManualSerializer.serialize(cat);
        assertTrue(json.contains("\"name\": null"));
    }

    @Test
    public void testSerializePrimitiveTypes() throws IllegalAccessException {
        Cat cat = new Cat();
        cat.setAge(3);
        cat.setWeight(4.5);
        cat.setIsPleased(true);
        String json = JsonManualSerializer.serialize(cat);
        assertTrue(json.contains("\"age\": \"3\""));
        assertTrue(json.contains("\"weight\": \"4.5\""));
        assertTrue(json.contains("\"isPleased\": true"));
    }

    @Test
    public void testSerializeEmptyString() throws IllegalAccessException {
        Cat cat = new Cat();
        cat.setName("");
        String json = JsonManualSerializer.serialize(cat);
        assertTrue(json.contains("\"name\": \"\""));
    }

    @Test
    public void testSerializeNewLineInValue() throws IllegalAccessException {
        Cat cat = new Cat("Name\nSecondLine", 2, 3.0, Color.GREEN, Gender.MALE, false);
        String json = JsonManualSerializer.serialize(cat);
        assertTrue(json.contains("\"Name\\nSecondLine\""));
    }

    @Test
    public void testSerializeEscapeSequences() throws IllegalAccessException {
        Cat cat = new Cat("Tab\tCharacter", 2, 3.0, Color.WHITE, Gender.MALE, false);
        String json = JsonManualSerializer.serialize(cat);
        assertTrue(json.contains("\"Tab\\tCharacter\""));
    }
}