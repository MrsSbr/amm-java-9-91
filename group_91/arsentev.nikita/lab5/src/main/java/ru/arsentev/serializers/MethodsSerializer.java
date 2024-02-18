package ru.arsentev.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.arsentev.entities.Cat;

public class MethodsSerializer {

    public static String templateSerializeJsonObjectMethod(Object object) {
        try {
            return JsonObjectSerializer.serialize(object);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Failed object: " + object);
        }
    }

    public static String templateSerializeJsonManualMethod(Object object) {
        try {
            return JsonManualSerializer.serialize(object);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Failed object: " + object);
        }
    }

    public static String templateMySerializeJsonMethod(Object object) {
        try {
            return MyJsonSerializer.serialize(object);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed object: " + object);
        }
    }

    public static String catSerializeJsonStdCatMethod(Cat cat) {
        try {
            return JsonStdCatSerializer.serialize(cat);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Failed object: " + cat);
        }
    }
}
