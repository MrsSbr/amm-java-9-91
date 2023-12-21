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
        JsonUtils json = new JsonUtils();
        String jsonString = "{\"name\":\"Мурка\",\"age\":3,\"gender\":FEMALE,\"breed\":THAI,\"defertilized\":true}";

        Cat cat = json.deserialize(jsonString, Cat.class);

        assertEquals(new Cat ("Мурка", 3, Gender.FEMALE, Breed.THAI, true), cat);
    }

    @Test
    public void testDeserializeFieldWithNullValue() {
        JsonUtils json = new JsonUtils();
        String jsonString = "{\"name\":\"Мурка\",\"age\":1,\"gender\":null,\"breed\":THAI,\"defertilized\":false}";

        Cat cat = json.deserialize(jsonString, Cat.class);

        assertEquals(new Cat ("Мурка", 1, null, Breed.THAI, false), cat);
    }

    @Test
    public void testDeserializeFieldWithInvalidValue() {
        JsonUtils json = new JsonUtils();
        String jsonString = "{\"name\":\"Мурка\",\"age\":1,\"gender\":,\"breed\":THAI,\"defertilized\":false}";

        assertEquals(null, json.deserialize(jsonString, Cat.class));
    }

    @Test
    public void testDeserializeFieldWithEmptyString() {
        JsonUtils json = new JsonUtils();
        String jsonString = "";

        assertEquals(null, json.deserialize(jsonString, Cat.class));
    }

    @Test
    public void testSerializeFieldWithValidValue() {
        JsonUtils json = new JsonUtils();
        Cat cat = new Cat("Мурка", 3, Gender.FEMALE, Breed.THAI, true);

        String result = json.serialize(cat);
        String actual = "{\"gender\":FEMALE,\"name\":\"Мурка\",\"age\":3,\"breed\":THAI,\"defertilized\":true}";

        assertEquals(result, actual);
    }

    @Test
    public void testSerializeFieldWithNullValue() {
        JsonUtils json = new JsonUtils();
        Cat cat = new Cat("Мурка", 1, null, Breed.THAI, false);
        String jsonString = "{\"gender\":null,\"name\":\"Мурка\",\"age\":1,\"breed\":THAI,\"defertilized\":false}";

        assertEquals(jsonString, json.serialize(cat));
    }
}