package ru.arsentev.serializers;

import org.json.JSONObject;

import java.lang.reflect.Field;

public class JsonObjectSerializer {
    public static String serialize(Object object) throws IllegalAccessException {
        Class<?> clazz = object.getClass();
        JSONObject json = new JSONObject();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(object);
            if (value != null) {
                if (value instanceof Number || value instanceof Enum) {
                    json.put(field.getName(), value.toString());
                } else {
                    json.put(field.getName(), value);
                }
            } else {
                json.put(field.getName(), "null");
            }
        }
        return formatJsonString(json.toString());
    }

    private static String formatJsonString(String jsonString) {
        return jsonString.replace("\":", "\": ")
                .replace(",", ",\n  ")
                .replace("{", "{\n  ")
                .replace("}", "\n}")
                .replace("\"null\"", "null");
    }
}
