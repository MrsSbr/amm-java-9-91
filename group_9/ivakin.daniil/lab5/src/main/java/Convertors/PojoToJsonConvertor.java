package Convertors;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PojoToJsonConvertor {

    public String getJSONStr(Object obj) {
        Class type = obj.getClass();
        if (type.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(type)
                || type.isEnum() || type == String.class) {
            throw new IllegalArgumentException();
        }

        return getJSONStrHelper(obj, obj.getClass(), 0);
    }

    private String getJSONStrHelper(Object obj, Class objType, int indentCount) {
        if (obj == null) {
            return "null";
        }

        if (objType.isEnum() || objType == String.class || WrappedPrimitiveUtils.wrappedFromUnknown(objType) == Character.class) {
            return convertStringCharEnum(obj);
        }

        if (objType.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(objType)) {
            return obj.toString();
        }

        if (Collection.class.isAssignableFrom(objType)) {
            return convertCollection(obj, indentCount);
        }

        if (objType.isArray()) {
            return convertArray(obj, indentCount);
        }

        return convertComplex(obj, indentCount);
    }

    private String convertStringCharEnum(Object obj) {
        StringBuilder jsonStrBuilder = new StringBuilder();
        String transformedStr;

        if (obj.getClass() == Character.class) {
            transformedStr = EscapeSymbolUtils.transformWithEscapes((Character) obj);
        } else if (obj.getClass() == String.class) {
            transformedStr = EscapeSymbolUtils.transformWithEscapes((String) obj);
        } else if (obj.getClass().isEnum()) {
            transformedStr = obj.toString();
        } else {
            transformedStr = EscapeSymbolUtils.transformWithEscapes((char) obj);
        }

        return jsonStrBuilder
                .append("\"")
                .append(transformedStr)
                .append("\"")
                .toString();
    }

    private String convertCollection(Object obj, int indentCount) {
        Collection collection = ((Collection) obj);

        if (collection.isEmpty()) {
            return convertArray(new Object[0], indentCount);
        }

        String indentStr = getIndentStr(indentCount);
        StringBuilder jsonStrBuilder = new StringBuilder("[");

        Class componentType = collection.iterator().next().getClass();

        collection.forEach(item -> jsonStrBuilder
                .append("\n")
                .append(indentStr)
                .append("  ")
                .append(getJSONStrHelper(item, componentType, indentCount + 2))
                .append(","));

        return jsonStrBuilder
                .deleteCharAt(jsonStrBuilder.length() - 1)
                .append("\n")
                .append(indentStr)
                .append("]")
                .toString();
    }

    private String convertArray(Object obj, int indentCount) {
        String indentStr = getIndentStr(indentCount);
        StringBuilder jsonStrBuilder = new StringBuilder("[");

        Class componentType = obj.getClass().getComponentType();
        int arrLength = Array.getLength(obj);

        for (int i = 0; i < arrLength; ++i) {
            jsonStrBuilder
                    .append("\n")
                    .append(indentStr)
                    .append("  ")
                    .append(getJSONStrHelper(Array.get(obj, i), componentType, indentCount + 2))
                    .append(",");
        }

        if (arrLength != 0) {
            jsonStrBuilder.deleteCharAt(jsonStrBuilder.length() - 1);
        }

        return jsonStrBuilder
                .append("\n")
                .append(indentStr)
                .append("]")
                .toString();
    }

    private String convertComplex(Object obj, int indentCount) {
        String indentStr = getIndentStr(indentCount);
        StringBuilder jsonStrBuilder = new StringBuilder("{");

        Class type = obj.getClass();
        List<Field> fields = getAllFields(type);

        for (Field field : fields) {
            if (field.trySetAccessible()) {
                jsonStrBuilder
                        .append("\n")
                        .append(indentStr)
                        .append("  \"")
                        .append(field.getName())
                        .append("\" : ");

                try {
                    jsonStrBuilder.append(getJSONStrHelper(field.get(obj), field.getType(), indentCount + 2));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }

                jsonStrBuilder.append(",");
            }
        }

        if (!fields.isEmpty()) {
            jsonStrBuilder.deleteCharAt(jsonStrBuilder.length() - 1);
        }

        return jsonStrBuilder
                .append("\n")
                .append(indentStr)
                .append("}")
                .toString();
    }

    private String getIndentStr(int indentCount) {
        return " ".repeat(indentCount);
    }

    private List<Field> getAllFields(Class type) {
        List<Field> fields = new ArrayList<>();
        for (Class superType = type; superType != null; superType = superType.getSuperclass()) {
            fields.addAll(Arrays.stream(superType.getDeclaredFields()).toList());
        }
        return fields;
    }
}
