package converter;

import exceptions.DeserializeException;
import lombok.SneakyThrows;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Deserializer {
    private List<Class> innerTypes;

    public Object DeserializeJSON(String json, Class<?> objType) {
        innerTypes = Collections.EMPTY_LIST;

        if (objType.isPrimitive()
                || Utils.isWrappedPrimitive(objType)
                || objType.isEnum()
                || objType == String.class) {

            throw new DeserializeException("Illegal deserialization objType");
        }

        return deserializeType(json, objType);
    }

    public Object DeserializeJSON(String json, Class<?> objType, List<Class> innerTypes) {
        this.innerTypes = innerTypes;

        if (objType.isPrimitive()
                || Utils.isWrappedPrimitive(objType)
                || objType.isEnum()
                || objType == String.class) {

            throw new DeserializeException("Illegal deserialization objType");
        }

        return deserializeType(json, objType);
    }

    private Object deserializeType(String json, Class<?> objType) {
        if (json.equals("null")) {
            return null;
        }
        if (objType.isPrimitive()) {
            return deserializePrimitive(json, objType);
        }
        if (Utils.isWrappedPrimitive(objType)) {
            return deserializeWrapperPrimitive(json, objType);
        }
        if (objType.isEnum()){
            return deserializeEnum(json, objType);
        }
        if (objType == String.class) {
            return deserializeString(json);
        }
        if (objType.isArray()) {
            return deserializeArray(json, objType);
        }
        if (Collection.class.isAssignableFrom(objType)) {
            return deserializeCollection(json, objType);
        }

        return deserializeObject(json, objType);
    }

    private Object deserializePrimitive(String json, Class<?> objType) {
        if (objType == int.class) {
            return Integer.parseInt(json);
        }
        if (objType == double.class) {
            return Double.parseDouble(json);
        }
        if (objType == boolean.class) {
            return Boolean.parseBoolean(json);
        }
        if (objType == long.class) {
            return Long.parseLong(json);
        }
        if (objType == float.class) {
            return Float.parseFloat(json);
        }
        if (objType == short.class) {
            return Short.parseShort(json);
        }
        if (objType == byte.class) {
            return Byte.parseByte(json);
        }
        if (objType == char.class) {
            return json.charAt(0);
        }

        throw new DeserializeException("Illegal deserialization objType");
    }

    private Object deserializeWrapperPrimitive(String json, Class<?> objType) {
        if (objType == Integer.class) {
            return Integer.valueOf(json);
        }
        if (objType == Double.class) {
            return Double.valueOf(json);
        }
        if (objType == Boolean.class) {
            return Boolean.valueOf(json);
        }
        if (objType == Long.class) {
            return Long.valueOf(json);
        }
        if (objType == Float.class) {
            return Float.valueOf(json);
        }
        if (objType == Short.class) {
            return Short.valueOf(json);
        }
        if (objType == Byte.class) {
            return Byte.valueOf(json);
        }
        if (objType == Character.class) {
            return json.charAt(0);
        }

        throw new DeserializeException("Illegal deserialization objType");
    }

    private Object deserializeEnum(String json, Class<?> objType) {
        if (!objType.isEnum()) {
            throw new DeserializeException("Type is not an enum");
        }
        return Enum.valueOf((Class<Enum>) objType, json.substring(1, json.length() - 1));
    }

    private String decodeString(String string) {
        return string.replace("\\\"", "\"");
    }

    private String deserializeString(String json) {
        return decodeString(json.substring(1, json.length() - 1));
    }

    private Object deserializeArray(String json, Class<?> objType) {
        var splits = json.substring(1, json.length() - 1).split(", ");

        var array = Array.newInstance(objType.getComponentType(), splits.length);
        for (int i = 0; i < splits.length; i++) {
            Array.set(array, i, deserializeType(splits[i].trim(), objType.getComponentType()));
        }
        return array;
    }

    private Object deserializeCollection(String json, Class<?> objType) {
        Class type;
        if (!innerTypes.isEmpty()) {
            type = innerTypes.get(0);
        }
        else {
            type = objType.getComponentType();
        }
        var splits = json.substring(1, json.length() - 1).split(", ");

        var collection = new ArrayList<>();
        for (var split : splits) {
            collection.add(deserializeType(split.trim(), type));
        }
        return collection;
    }



    @SneakyThrows
    private Object deserializeObject(String json, Class<?> objType) {
        var object = objType.getDeclaredConstructor().newInstance();
        var fields = objType.getDeclaredFields();

        var splits = json.substring(1, json.length() - 1).split(",");

        for (var split : splits) {
            var pairs = split.split(":");

            var key = pairs[0].trim().substring(1, pairs[0].length() - 1);
            var value = pairs[1].trim();

            for (var field : fields) {
                if (field.getName().equals(key)) {
                    field.setAccessible(true);
                    try {
                        field.set(object, deserializeType(value, field.getType()));
                    } catch (IllegalArgumentException e) {
                        throw new DeserializeException("Illegal arguments to set" + e.getMessage());
                    }
                }
            }
        }
        return object;
    }
}



