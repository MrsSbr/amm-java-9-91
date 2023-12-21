package org.example;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class JsonUtils {
    public String serialize(Object object) {
        try {
            Class<?> clazz = object.getClass();
            Map<String, Object> map = new HashMap<>();

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.get(object) == null) {
                    map.put(field.getName(), null);
                } else {
                    map.put(field.getName(), field.get(object));
                }
            }

            StringBuilder json = new StringBuilder("{");
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                json.append("\"")
                        .append(entry.getKey())
                        .append("\":");
                if (entry.getValue() instanceof String) {
                    json.append("\"")
                            .append(entry.getValue())
                            .append("\",");
                } else {
                    json.append(entry.getValue()).append(",");
                }
            }
            json.deleteCharAt(json.length() - 1);
            json.append("}");

            return json.toString();
        } catch (IllegalAccessException e) {
            return null;
        }
    }

    public <T> T deserialize(String json, Class<T> clazz) {
        try {
            T object = clazz.newInstance();
            Map<String, String> map = parseJson(json);

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if (map.containsKey(field.getName())) {
                    if (map.get(field.getName()) == null) {
                        field.set(object, null);
                    } else if (field.getType() == int.class) {
                        field.setInt(object, Integer.parseInt(map.get(field.getName())));
                    } else if (field.getType() == double.class) {
                        field.setDouble(object, Double.parseDouble(map.get(field.getName())));
                    } else if (field.getType() == float.class) {
                        field.setFloat(object, Float.parseFloat(map.get(field.getName())));
                    } else if (field.getType() == long.class) {
                        field.setLong(object, Long.parseLong(map.get(field.getName())));
                    } else if (field.getType() == short.class) {
                        field.setShort(object, Short.parseShort(map.get(field.getName())));
                    } else if (field.getType() == byte.class) {
                        field.setByte(object, Byte.parseByte(map.get(field.getName())));
                    } else if (field.getType() == boolean.class) {
                        field.setBoolean(object, Boolean.parseBoolean(map.get(field.getName())));
                    } else if (field.getType() == String.class) {
                        field.set(object, map.get(field.getName()));
                    } else if (field.getType().isEnum()) {
                        Enum<?> enumValue = Enum.valueOf((Class<Enum>) field.getType(), map.get(field.getName()));
                        field.set(object, enumValue);
                    }
                }
            }

            return object;
        } catch (IllegalAccessException | InstantiationException
                | StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    private Map<String, String> parseJson(String json) {
        Map<String, String> map = new HashMap<>();
        String[] pairs = json.substring(1, json.length() - 1).split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].replaceAll("\"", "").trim();
            String value = keyValue[1].replaceAll("\"", "").trim();
            if (!value.equals("null")) {
                map.put(key, value);
            } else {
                map.put(key, null);
            }
        }
        return map;
    }
}
