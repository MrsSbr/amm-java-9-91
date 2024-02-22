package ru.arsentev.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;


public class MyJsonDeserializer {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T deserialize(String jsonString, Class<T> clazz) throws Exception {
        String processedJsonString = jsonString.replaceAll("\"(\\d+(\\.\\d+)?)\"", "$1");
        return objectMapper.readValue(processedJsonString, clazz);
    }
}
