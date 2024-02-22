package ru.arsentev.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ru.arsentev.cat.rializer.CatDeserializer;
import ru.arsentev.entities.Cat;

public class JsonStdCatDeserializer {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Cat.class, new CatDeserializer());
        mapper.registerModule(module);
    }

    public static Cat deserialize(String jsonString) throws JsonProcessingException {
        return mapper.readValue(jsonString, Cat.class);
    }
}
