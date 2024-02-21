package ru.arsentev.serializers;


import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

public class JsonManualSerializer {

    public static String serialize(Object object) throws IllegalAccessException {
        Map<String, Object> jsonMap = new LinkedHashMap<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(object);
            if (value instanceof Number || value instanceof Enum) {
                value = "\"" + value + "\"";
            } else if (value instanceof String) {
                value = "\"" + StringEscapeUtils.escapeJava(value.toString()) + "\"";
            }
            jsonMap.put(field.getName(), value);
        }
        return formatJsonString(jsonMap);
    }

    private static String formatJsonString(Map<String, Object> jsonMap) {
        StringBuilder jsonBuilder = new StringBuilder("{\n");
        int i = 0;
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            jsonBuilder.append("  \"")
                    .append(entry.getKey())
                    .append("\": ")
                    .append(entry.getValue());
            if (i < jsonMap.size() - 1) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
            i++;
        }
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
