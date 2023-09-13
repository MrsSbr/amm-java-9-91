package org.example;

import org.example.JsonUtils;
import org.example.cat.Breed;
import org.example.cat.Cat;
import org.example.cat.Gender;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class JsonUtilsTest {

    @Test
    public void testDeserializeFieldWithValidValue() {
        String json = "{\"name\":\"Мурка\",\"age\":3,\"gender\":FEMALE,\"breed\":THAI,\"defertilized\":true}";

        Cat cat = JsonUtils.deserialize(json, Cat.class);

        assertEquals(new Cat ("Мурка", 3, Gender.FEMALE, Breed.THAI, true), cat);
    }

    @Test
    public void testDeserializeFieldWithNullValue() {
        String json = "{\"name\":\"Мурка\",\"age\":1,\"gender\":null,\"breed\":THAI,\"defertilized\":false}";

        Cat cat = JsonUtils.deserialize(json, Cat.class);

        assertEquals(new Cat ("Мурка", 1, null, Breed.THAI, false), cat);
    }

    @Test
    public void testDeserializeFieldWithInvalidValue() {
        String json = "{\"name\":\"Мурка\",\"age\":1,\"gender\":,\"breed\":THAI,\"defertilized\":false}";

        assertEquals(null, JsonUtils.deserialize(json, Cat.class));
    }

    @Test
    public void testDeserializeFieldWithEmptyString() {
        String json = "";

        assertEquals(null, JsonUtils.deserialize(json, Cat.class));
    }

    @Test
    public void testSerializeFieldWithValidValue() throws NoSuchFieldException, IllegalAccessException {
        Cat cat = new Cat("Мурка", 3, Gender.FEMALE, Breed.THAI, true);

        String result = JsonUtils.serialize(cat);
        String actual = "{\"gender\":FEMALE,\"name\":\"Мурка\",\"age\":3,\"breed\":THAI,\"defertilized\":true}";

        assertEquals(result, actual);
    }

    @Test
    public void testSerializeFieldWithNullValue() {
        Cat cat = new Cat("Мурка", 1, null, Breed.THAI, false);
        String json = "{\"gender\":null,\"name\":\"Мурка\",\"age\":1,\"breed\":THAI,\"defertilized\":false}";

        assertEquals(json, JsonUtils.serialize(cat));
    }
}