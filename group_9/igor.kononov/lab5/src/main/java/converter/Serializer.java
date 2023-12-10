package converter;

public class Serializer {
    public String serializeJSON(Object obj) {
        var type = obj.getClass();

        if (type.isEnum() || type.isPrimitive() || type.isArray()) {
            throw new IllegalArgumentException();
        }

        return serializeType(obj, type);
    }

    private String serializeType(Object obj, Class<?> objectType) {
        if (obj == null) {
            return "null";
        } else if (objectType.isPrimitive()) {
            return obj.toString();
        } else if (objectType.isEnum() || objectType == String.class) {
            return serializeStringEnum(obj);
        }

        return serializeObject(obj);
    }

    private String serializeStringEnum(Object obj) {
        var stringBuilder = new StringBuilder();

        return stringBuilder
                .append("\"")
                .append(obj.toString())
                .append("\"")
                .toString();
    }

    private String serializeObject(Object obj) {
        var objectType = obj.getClass();
        var fields = objectType.getDeclaredFields();

        var stringBuilder = new StringBuilder("{");

        for (var field : fields) {
            field.setAccessible(true);
            stringBuilder
                    .append("\"")
                    .append(field.getName())
                    .append("\":");
            try {
                stringBuilder.append(serializeType(field.get(obj), field.getType()));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            stringBuilder.append(",");
        }

        if (fields.length != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.append("}").toString();
    }
}

