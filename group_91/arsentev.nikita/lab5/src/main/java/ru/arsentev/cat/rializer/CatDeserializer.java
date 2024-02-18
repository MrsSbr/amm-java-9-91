package ru.arsentev.cat.rializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.arsentev.entities.Cat;
import ru.arsentev.entities.Color;
import ru.arsentev.entities.Gender;

import java.io.IOException;

public class CatDeserializer extends StdDeserializer<Cat> {
    public CatDeserializer() {
        this(null);
    }

    public CatDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Cat deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Cat cat = new Cat();
        String name = node.get("name").asText(null);
        int age = node.get("age").asInt();
        double weight = node.get("weight").asDouble();
        boolean isPleased = node.get("isPleased").asBoolean();

        String colorName = node.get("color").asText(null);
        Color color = colorName != null ? Color.valueOf(colorName) : null;
        String genderName = node.get("gender").asText(null);
        Gender male = genderName != null ? Gender.valueOf(genderName) : null;

        cat.setName(name);
        cat.setAge(age);
        cat.setWeight(weight);
        cat.setColor(color);
        cat.setGender(male);
        cat.setIsPleased(isPleased);

        return cat;
    }
}
