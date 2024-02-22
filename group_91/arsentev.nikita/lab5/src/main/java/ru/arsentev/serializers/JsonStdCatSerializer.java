package ru.arsentev.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ru.arsentev.cat.rializer.CatSerializer;
import ru.arsentev.entities.Cat;

public class JsonStdCatSerializer {
    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Cat.class, new CatSerializer());
        mapper.registerModule(module);
    }

    public static String serialize(Cat cat) throws JsonProcessingException {
        return mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(cat)
                .replace(" :", ":")
                .replace("\r", "")
                .replace("\"null\"", "null");
    }
}
