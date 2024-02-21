package ru.arsentev.deserializer;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonManualDeserializer {
    public static <T> T deserialize(String json, Class<T> clazz) throws Exception {
        T instance = clazz.getDeclaredConstructor().newInstance();
        Map<String, String> keyValueMap = parseJsonToMap(json);

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String key = field.getName();
            String value = keyValueMap.get(key);

            if (value != null) {
                Class<?> fieldType = field.getType();
                value = value.replaceAll("^\"|\"$", "");//.replace("\\\"", "\"");

                if (fieldType == String.class) {
                    field.set(instance, value.equals("null") ? null : value);
                } else if (fieldType == int.class || fieldType == Integer.class) {
                    field.set(instance, Integer.parseInt(value));
                } else if (fieldType == double.class || fieldType == Double.class) {
                    field.set(instance, Double.parseDouble(value));
                } else if (fieldType == boolean.class || fieldType == Boolean.class) {
                    field.set(instance, Boolean.parseBoolean(value));
                } else if (fieldType.isEnum()) {
                    //noinspection unchecked,rawtypes
                    Enum<?> enumValue = Enum.valueOf((Class<Enum>) fieldType, value);
                    field.set(instance, enumValue);
                }
            } else if (!field.getType().isPrimitive()) {
                field.set(instance, null);
            }
        }
        return instance;
    }

    private static Map<String, String> parseJsonToMap(String json) {
        Map<String, String> map = new HashMap<>();
        json = json.substring(1, json.length() - 1);
        //?=([^"]*"[^"]*")*[^"]*$)
        String[] keyValuePairs = json.split(",");

        for (String pair : keyValuePairs) {
            if (!pair.isEmpty()) {
                String[] entry = pair.split(":");
                String key = entry[0].trim().replaceAll("^\"|\"$", "");
                String value = entry[1].trim();
                map.put(key, value);
            }
        }

        return map;
    }
}
