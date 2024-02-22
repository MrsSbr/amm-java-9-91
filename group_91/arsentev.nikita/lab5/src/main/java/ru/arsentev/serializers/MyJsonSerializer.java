package ru.arsentev.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyJsonSerializer {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String serialize(Object object) throws Exception {
        return objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(object)
                .replace(" :", ":")
                .replaceAll("(\\d+(\\.\\d+)?)", "\"$1\"")
                .replace("\r", "");
    }
}
