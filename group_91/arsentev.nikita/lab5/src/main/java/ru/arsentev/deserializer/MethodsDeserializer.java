package ru.arsentev.deserializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonSyntaxException;
import ru.arsentev.entities.Cat;

public class MethodsDeserializer {
    public static Cat catDeserializeJsonStdCatMethod(String jsonString) throws JsonProcessingException {
        try {
            return JsonStdCatDeserializer.deserialize(jsonString);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to deserialize JSON string: " + jsonString, e);
        }
    }

    public static Cat catDeserializeBuilderMethod(String jsonString) throws JsonSyntaxException {
        try {
            return JsonBuilderDeserializer.deserialize(jsonString);
        } catch (JsonSyntaxException e) {
            throw new IllegalArgumentException("Failed to deserialize JSON string: " + jsonString, e);
        }
    }

    public static <T> T templateMyDeserializeMethod(String jsonString, Class<T> clazz) throws Exception {
        try {
            return MyJsonDeserializer.deserialize(jsonString, clazz);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed to deserialize JSON string: " + jsonString, e);
        }

    }
}
