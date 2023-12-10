package converter;

import lombok.SneakyThrows;

public class Deserializer {
    public Object DeserializeJSON(String json, Class<?> objType) {
        if (objType.isEnum() || objType.isPrimitive() || objType.isArray()) {
            throw new IllegalArgumentException();
        }

        return deserializeType(json, objType);
    }

    private Object deserializeType(String json, Class<?> type) {
        if (json.equals("null")) {
            return null;
        } else if (type.isPrimitive()) {
            return deserializePrimitive(json, type);
        } else if (type == String.class) {
            return deserializeString(json);
        } else if (type.isEnum()){
            return deserializeEnum(json, type);
        }

        return deserializeObject(json, type);
    }

    private Object deserializeEnum(String json, Class<?> type) {
        if (!type.isEnum()) {
            throw new IllegalArgumentException("Type is not an enum");
        }

        return Enum.valueOf((Class<Enum>) type, json.substring(1, json.length() - 1));
    }

    private Object deserializePrimitive(String json, Class<?> objType) {
        if (objType == int.class) {
            return Integer.parseInt(json);
        } else if (objType == double.class) {
            return Double.parseDouble(json);
        } else if (objType == boolean.class) {
            return Boolean.parseBoolean(json);
        } else if (objType == long.class) {
            return Long.parseLong(json);
        } else if (objType == float.class) {
            return Float.parseFloat(json);
        } else if (objType == short.class) {
            return Short.parseShort(json);
        } else if (objType == byte.class) {
            return Byte.parseByte(json);
        } else if (objType == char.class) {
            return json.charAt(0);
        }

        throw new IllegalArgumentException();
    }

    private String deserializeString(String json) {
        return json.substring(1, json.length() - 1);
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
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        return object;
    }
}
