package ru.arsentev.deserializer;

import org.junit.jupiter.api.Test;
import ru.arsentev.entities.Cat;
import ru.arsentev.entities.Color;
import ru.arsentev.entities.Gender;

import static org.junit.jupiter.api.Assertions.*;

class JsonManualDeserializerTest {
    @Test
    public void testDeserializeCat() throws Exception {
        String json = "{\"name\":\"Whiskers\",\"age\":\"5\",\"weight\":\"4.2\",\"color\":\"BLACK\",\"gender\":\"MALE\",\"isPleased\":\"true\"}";
        Cat cat = JsonManualDeserializer.deserialize(json, Cat.class);
        assertEquals("Whiskers", cat.getName());
        assertEquals(5, cat.getAge());
        assertEquals(4.2, cat.getWeight(), 0.001);
        assertEquals(Color.BLACK, cat.getColor());
        assertEquals(Gender.MALE, cat.getGender());
        assertTrue(cat.getIsPleased());
    }

    @Test
    public void testDeserializeWithNullFields() throws Exception {
        String json = "{\"name\":null,\"age\":\"3\",\"weight\":\"2.5\",\"color\":\"WHITE\",\"gender\":\"FEMALE\",\"isPleased\":\"false\"}";
        Cat cat = JsonManualDeserializer.deserialize(json, Cat.class);
        assertNull(cat.getName());
        assertEquals(3, cat.getAge());
    }

    @Test
    public void testDeserializeWithEscapeCharacters() throws Exception {
        String json = "{\"name\":\"Whis\\\"kers\",\"age\":\"3\",\"weight\":\"2.5\",\"color\":\"GREEN\",\"gender\":\"MALE\",\"isPleased\":\"true\"}";
        Cat cat = JsonManualDeserializer.deserialize(json, Cat.class);
        assertEquals("Whis\\\"kers", cat.getName());
    }

    @Test
    public void testDeserializeWithMissingFields() throws Exception {
        String json = "{\"name\":\"Whiskers\",\"age\":\"5\"}"; // JSON без некоторых полей
        Cat cat = JsonManualDeserializer.deserialize(json, Cat.class);
        assertEquals("Whiskers", cat.getName());
        assertEquals(5, cat.getAge());
        assertEquals(0.0, cat.getWeight());
        assertNull(cat.getColor());
    }

    @Test
    public void testDeserializeWithExtraFields() throws Exception {
        String json = "{\"name\":\"Whiskers\",\"age\":\"5\",\"extraField\":\"extraValue\"}"; // JSON с полем, которого нет в классе Cat
        Cat cat = JsonManualDeserializer.deserialize(json, Cat.class);
        assertEquals("Whiskers", cat.getName());
        assertEquals(5, cat.getAge());
    }

    @Test
    public void testDeserializeWithIncorrectFieldType() {
        String json = "{\"name\":\"Whiskers\",\"age\":\"notANumber\",\"weight\":\"4.2\"}"; // Некорректный тип для поля age
        assertThrows(NumberFormatException.class, () -> JsonManualDeserializer.deserialize(json, Cat.class));
    }

    @Test
    public void testDeserializeInvalidEnumValue() {
        String json = "{\"color\":\"INVALID_COLOR\",\"gender\":\"INVALID_GENDER\"}";
        assertThrows(IllegalArgumentException.class, () -> JsonManualDeserializer.deserialize(json, Cat.class));
    }

    @Test
    public void testDeserializeEnumValues() throws Exception {
        String json = "{\"color\":\"BLACK\",\"gender\":\"MALE\"}";
        Cat cat = JsonManualDeserializer.deserialize(json, Cat.class);
        assertEquals(Color.BLACK, cat.getColor());
        assertEquals(Gender.MALE, cat.getGender());
    }

    @Test
    public void testDeserializeEmptyJson() throws Exception {
        String json = "{}";
        Cat cat = JsonManualDeserializer.deserialize(json, Cat.class);
        assertNotNull(cat);
        assertNull(cat.getName());
        assertEquals(0, cat.getAge());
        assertEquals(0.0, cat.getWeight(), 0.0);
        assertNull(cat.getColor());
        assertNull(cat.getGender());
        assertFalse(cat.getIsPleased());
    }

    @Test
    public void testDeserializeWithIncorrectKeys() throws Exception {
        String json = "{\"unknownKey\":\"value\",\"anotherUnknownKey\":\"value\"}";
        Cat cat = JsonManualDeserializer.deserialize(json, Cat.class);
        assertNotNull(cat);
        assertNotNull(cat);
        assertNull(cat.getName());
        assertEquals(0, cat.getAge());
        assertEquals(0.0, cat.getWeight(), 0.0);
        assertNull(cat.getColor());
        assertNull(cat.getGender());
        assertFalse(cat.getIsPleased());
    }
}