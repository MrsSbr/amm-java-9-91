package converter;

import exceptions.SerializeException;

import java.lang.reflect.Array;
import java.util.Collection;

public class Serializer {
    public String serializeJSON(Object obj) {
        if (obj == null) {
            return "null";
        }

        var objectType = obj.getClass();
        if (objectType.isPrimitive()
                || Utils.isWrappedPrimitive(objectType)
                || objectType.isEnum()
                || objectType == String.class) {
            throw new SerializeException("Illegal serialization objType");
        }

        return serializeType(obj, objectType);
    }

    private String serializeType(Object obj, Class<?> objectType) {
        if (obj == null) {
            return "null";
        }
        if (objectType.isPrimitive()) {
            return obj.toString();
        }
        if (Utils.isWrappedPrimitive(objectType)){
            return obj.toString();
        }
        if (objectType.isEnum() || objectType == String.class) {
            return serializeStringEnum(obj);
        }
        if (objectType.isArray()) {
            return serializeArray(obj);
        }
        if (Collection.class.isAssignableFrom(objectType)) {
            return serializeCollection(obj);
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

    private String serializeArray(Object obj) {
        var componentType = obj.getClass().getComponentType();
        var length = Array.getLength(obj);

        var stringBuilder = new StringBuilder("[");

        for (var i = 0; i < length; i++) {
            stringBuilder
                    .append(serializeType(Array.get(obj, i), componentType))
                    .append(",");
        }
        if (length != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder
                .append("]")
                .toString();
    }

    private String serializeCollection(Object obj) {
        var collection = (Collection) obj;

        if (collection.isEmpty()) {
            return serializeArray(new Object[0]);
        }

        var componentType = collection.iterator().next().getClass();
        var stringBuilder = new StringBuilder("[");

        collection.forEach(component -> stringBuilder
                .append(serializeType(component, componentType))
                .append(","));

        return stringBuilder
                .deleteCharAt(stringBuilder.length() - 1)
                .append("]")
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
                throw new SerializeException("Illegal arguments to append" + e.getMessage());
            }
            stringBuilder.append(",");
        }

        if (fields.length != 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.append("}").toString();
    }
}

