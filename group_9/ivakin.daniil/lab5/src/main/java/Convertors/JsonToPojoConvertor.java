package Convertors;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;


public class JsonToPojoConvertor {

    //Мап для восстановления типов полей-коллекций (коллекции могут быть вложенными)
    private Map<String, List<Class>> fieldInnerTypes;

    public JsonToPojoConvertor(Map<String, List<Class>> collFieldTypes) {
        this.fieldInnerTypes = collFieldTypes;
    }

    public JsonToPojoConvertor() {
        this.fieldInnerTypes = null;
    }

    private static String getFieldStr(String jsonLine, int separatorIndex) {
        String fieldStr = jsonLine.substring(0, separatorIndex).trim();
        return fieldStr.substring(1, fieldStr.length() - 1);
    }

    private static String getValueStr(String jsonLine, int separatorIndex) {
        String valueStr = jsonLine.substring(separatorIndex + 1).trim();
        if (valueStr.endsWith(","))
            valueStr = valueStr.substring(0, valueStr.length() - 1);
        return valueStr;
    }

    private static Field getFieldByName(Class<?> objType, String fieldStr) throws NoSuchFieldException {
        Class superType = objType;
        while (superType != null) {
            try {
                return superType.getDeclaredField(fieldStr);
            } catch (NoSuchFieldException e) {
                superType = superType.getSuperclass();
            }
        }
        throw new NoSuchFieldException(fieldStr);
    }

    private static Iterator<String> getJsonIt(String jsonString) {
        return jsonString.
                lines().map(String::trim).toList().iterator();
    }

    //Получить объект
    public Object getObject(Class objType, String jsonString) {
        if (objType.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(objType) || objType.isArray()
                || objType.isEnum() || objType == String.class || Collection.class.isAssignableFrom(objType)) {
            throw new IllegalArgumentException();
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return getComplex(objType, jsonIt);
        }

        return null;
    }

    //Получить коллекцию
    public Object getCollection(Class objType, List<Class> innerTypes, String jsonString) {
        if (!Collection.class.isAssignableFrom(objType)) {
            throw new IllegalArgumentException();
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return getCollection(objType, innerTypes, jsonIt);
        }
        return null;
    }

    //Получить массив из НЕ коллекций
    public Object getSimpleArray(Class objType, String jsonString) {
        if (!objType.isArray() || Collection.class.isAssignableFrom(objType.getComponentType())) {
            throw new IllegalArgumentException();
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return getSimpleArray(objType, jsonIt);
        }

        return null;
    }

    //Получить массив из коллекций (могут быть вложенными)
    public Object getCollectionArray(Class objType, List<Class> innerTypes, String jsonString) {
        if (!objType.isArray() || !Collection.class.isAssignableFrom(objType.getComponentType())) {
            throw new IllegalArgumentException();
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return getCollectionArray(objType, innerTypes, jsonIt);
        }

        return null;
    }


    //Преобразование в объект
    private Object getComplex(Class objType, Iterator<String> jsonIt) {
        Object obj;
        Field field;
        String curLine;

        try {
            obj = objType.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        while (jsonIt.hasNext()) {
            curLine = jsonIt.next();

            if (curLine.equals("}") || curLine.equals("},")) {
                break;
            }

            int separatorIndex = curLine.indexOf(":");
            String fieldStr = getFieldStr(curLine, separatorIndex);
            String valueStr = getValueStr(curLine, separatorIndex);

            try {
                field = getFieldByName(objType, fieldStr);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }

            if (field.trySetAccessible()) {
                try {
                    //Тут нужно проверить, не является ли поле коллекцией или массивом коллекций
                    //Проверяется это тем, что оно должно быть заранее указано в мапе
                    if (fieldInnerTypes != null && fieldInnerTypes.containsKey(fieldStr)) {
                        if (field.getType().isArray()) {
                            field.set(obj, getCollectionArray(field.getType(), fieldInnerTypes.get(fieldStr), jsonIt));
                        } else {
                            field.set(obj, getCollection(field.getType(), fieldInnerTypes.get(fieldStr), jsonIt));
                        }
                    } else {
                        field.set(obj, getValue(field.getType(), valueStr, jsonIt));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    //Преобразование коллекции
    private Object getCollection(Class collectionType, List<Class> innerTypes, Iterator<String> jsonIt) {
        String curLine;
        Collection collection;
        Class topInnerType = innerTypes.get(0);
        List<Class> bottomInnerTypes = innerTypes.subList(1, innerTypes.size());

        if (Set.class.isAssignableFrom(collectionType)) {
            collection = new TreeSet();
        } else if (Queue.class.isAssignableFrom(collectionType)) {
            collection = new ArrayDeque();
        } else {
            collection = new ArrayList();
        }

        //Тут идет разборка с тем, является ли коллекция вложенной
        if (Collection.class.isAssignableFrom(topInnerType)) {
            while (jsonIt.hasNext()) {
                curLine = jsonIt.next();
                if (curLine.equals("]")) {
                    break;
                }

                if (curLine.equals("null") || curLine.equals("null,")) {
                    collection.add(null);
                } else {
                    collection.add(getCollection(topInnerType, bottomInnerTypes, jsonIt));
                }
            }
        //Или это коллекция массивов, элементы которых - коллекции
        } else if (topInnerType.isArray() &&
                Collection.class.isAssignableFrom(topInnerType.getComponentType())) {
            //bottomInnerTypes = bottomInnerTypes.subList(1, bottomInnerTypes.size());
            while (jsonIt.hasNext()) {
                curLine = jsonIt.next();
                if (curLine.equals("]")) {
                    break;
                }
                if (curLine.equals("null") || curLine.equals("null,")) {
                    collection.add(null);
                } else {
                    collection.add(getCollectionArray(topInnerType, bottomInnerTypes, jsonIt));
                }
            }
        } else {    //Иначе это либо коллекция из обычных элементов / коллекция массивов, элементы которых - НЕ коллекции
            Object arr = getSimpleArray(topInnerType.arrayType(), jsonIt);
            int arrSize = Array.getLength(arr);
            for (int i = 0; i < arrSize; i++) {
                collection.add(Array.get(arr, i));
            }
        }

        return collection;
    }

    //Преобразование массива коллекций
    private Object getCollectionArray(Class arrType, List<Class> innerTypes, Iterator<String> jsonIt) {
        String curLine;
        Class componentType = arrType.getComponentType();
        Collection collection = new ArrayList();

        while (jsonIt.hasNext()) {
            curLine = jsonIt.next();

            if (curLine.equals("]") || curLine.equals("],")) {
                break;
            }

            String valueStr = getValueStr(curLine, -1);

            if (valueStr.equals("null")) {
                collection.add(null);
            } else {
                collection.add(getCollection(componentType, innerTypes, jsonIt));
            }
        }

        Object arrObj = Array.newInstance(componentType, collection.size());
        Iterator colIt = collection.iterator();
        for (int i = 0; i < collection.size(); i++) {
            Array.set(arrObj, i, colIt.next());
        }

        return arrObj;
    }

    //Получение массива НЕ коллекций
    private Object getSimpleArray(Class arrType, Iterator<String> jsonIt) {
        String curLine;
        Class componentType = arrType.getComponentType();
        Collection collection = new ArrayList();

        while (jsonIt.hasNext()) {
            curLine = jsonIt.next();

            if (curLine.equals("]") || curLine.equals("],")) {
                break;
            }

            String valueStr = getValueStr(curLine, -1);

            collection.add(getValue(componentType, valueStr, jsonIt));
        }

        Object arrObj = Array.newInstance(componentType, collection.size());
        Iterator colIt = collection.iterator();
        for (int i = 0; i < collection.size(); i++) {
            Array.set(arrObj, i, colIt.next());
        }

        return arrObj;
    }

    //Получение значения из преобразованной строки-значения. Тип значения берется от поля
    private Object getValue(Class valueType, String valueStr, Iterator<String> jsonIt) {
        if (valueStr.equals("null"))
            return null;

        if (WrappedPrimitiveUtils.wrappedFromUnknown(valueType) == Character.class) {
            return WrappedPrimitiveUtils.getWrappedFromStr(valueType, valueStr.substring(1, valueStr.length() - 1));
        }

        if (valueType.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(valueType)) {
            return WrappedPrimitiveUtils.getWrappedFromStr(valueType, valueStr);
        }

        if (valueType.isEnum()) {
            return Enum.valueOf(valueType, valueStr.substring(1, valueStr.length() - 1));
        }

        if (valueType == String.class) {
            return valueStr.substring(1, valueStr.length() - 1);
        }

        if (valueType.isArray()) {
            return getSimpleArray(valueType, jsonIt);
        }

        return getComplex(valueType, jsonIt);
    }
}
