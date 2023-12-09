package Serialization;

import Serialization.Utils.EscSymbDeserializer;
import Serialization.Utils.WrappedPrimitiveUtils;

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


public class Deserializer {

    //Мап для восстановления типов полей-коллекций (коллекции могут быть вложенными)
    private Map<String, List<Class>> fieldInnerTypes;

    public Deserializer(Map<String, List<Class>> collFieldTypes) {
        this.fieldInnerTypes = collFieldTypes;
    }

    public Deserializer() {
        this.fieldInnerTypes = null;
    }

    //Десериализация значения из преобразованной строки-значения
    private Object deserializeValue(Class valueType, String valueStr, Iterator<String> jsonIt) {
        if (valueStr.equals("null"))
            return null;

        if (WrappedPrimitiveUtils.wrappedFromUnknown(valueType) == Character.class) {
            String desStrValue = EscSymbDeserializer.deserializeWithEsc(valueStr.substring(1, valueStr.length() - 1));
            return WrappedPrimitiveUtils.getWrappedFromStr(valueType, desStrValue);
        }

        if (valueType == String.class) {
            return EscSymbDeserializer.deserializeWithEsc(valueStr.substring(1, valueStr.length() - 1));
        }

        if (valueType.isEnum()) {
            return Enum.valueOf(valueType, valueStr.substring(1, valueStr.length() - 1));
        }

        if (valueType.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(valueType)) {
            return WrappedPrimitiveUtils.getWrappedFromStr(valueType, valueStr);
        }

        if (valueType.isArray()) {
            return deserializeSimpleArray(valueType, jsonIt);
        }

        return deserializeComplex(valueType, jsonIt);
    }

    //Получить объект
    public Object deserializeObject(Class objType, String jsonString) {
        if (objType.isPrimitive() || WrappedPrimitiveUtils.isWrappedPrimitive(objType) || objType.isArray()
                || objType.isEnum() || objType == String.class || Collection.class.isAssignableFrom(objType)) {
            throw new IllegalArgumentException();
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return deserializeComplex(objType, jsonIt);
        }

        return null;
    }

    //Получить коллекцию
    public Object deserializeCollection(Class objType, List<Class> innerTypes, String jsonString) {
        if (!Collection.class.isAssignableFrom(objType)) {
            throw new IllegalArgumentException();
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return deserializeCollection(objType, innerTypes, jsonIt);
        }
        return null;
    }

    //Получить массив из НЕ коллекций
    public Object deserializeSimpleArray(Class objType, String jsonString) {
        if (!objType.isArray() || Collection.class.isAssignableFrom(objType.getComponentType())) {
            throw new IllegalArgumentException();
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return deserializeSimpleArray(objType, jsonIt);
        }

        return null;
    }

    //Получить массив из коллекций (могут быть вложенными)
    public Object deserializeCollectionArray(Class objType, List<Class> innerTypes, String jsonString) {
        if (!objType.isArray() || !Collection.class.isAssignableFrom(objType.getComponentType())) {
            throw new IllegalArgumentException();
        }

        Iterator<String> jsonIt = getJsonIt(jsonString);

        if (jsonIt.hasNext()) {
            jsonIt.next();
            return deserializeCollectionArray(objType, innerTypes, jsonIt);
        }

        return null;
    }


    //Преобразование в объект
    private Object deserializeComplex(Class objType, Iterator<String> jsonIt) {
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
                            field.set(obj, deserializeCollectionArray(field.getType(), fieldInnerTypes.get(fieldStr), jsonIt));
                        } else {
                            field.set(obj, deserializeCollection(field.getType(), fieldInnerTypes.get(fieldStr), jsonIt));
                        }
                    } else {
                        field.set(obj, deserializeValue(field.getType(), valueStr, jsonIt));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj;
    }

    //Преобразование коллекции
    private Object deserializeCollection(Class collectionType, List<Class> innerTypes, Iterator<String> jsonIt) {
        String curLine;
        Collection collection = new ArrayList();
        Class topInnerType = innerTypes.get(0);
        List<Class> bottomInnerTypes = innerTypes.subList(1, innerTypes.size());

//        if (Set.class.isAssignableFrom(collectionType)) {
//            collection = new TreeSet();
//        } else if (Queue.class.isAssignableFrom(collectionType)) {
//            collection = new ArrayDeque();
//        } else {
//            collection = new ArrayList();
//        }

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
                    collection.add(deserializeCollection(topInnerType, bottomInnerTypes, jsonIt));
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
                    collection.add(deserializeCollectionArray(topInnerType, bottomInnerTypes, jsonIt));
                }
            }
        } else {    //Иначе это либо коллекция из обычных элементов / коллекция массивов, элементы которых - НЕ коллекции
            Object arr = deserializeSimpleArray(topInnerType.arrayType(), jsonIt);
            int arrSize = Array.getLength(arr);
            for (int i = 0; i < arrSize; i++) {
                collection.add(Array.get(arr, i));
            }
        }

        if (collectionType.isInterface()) {
            if (Set.class.isAssignableFrom(collectionType)) {
                return new TreeSet(collection);
            } else if (Queue.class.isAssignableFrom(collectionType)) {
                return new ArrayDeque(collection);
            } else {
                return new ArrayList(collection);
            }
        }

        try {
            return collectionType.getConstructor(Collection.class).newInstance(collection);
        } catch (InstantiationException | IllegalAccessException
                 | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        // return collection;
    }

    //Преобразование массива коллекций
    private Object deserializeCollectionArray(Class arrType, List<Class> innerTypes, Iterator<String> jsonIt) {
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
                collection.add(deserializeCollection(componentType, innerTypes, jsonIt));
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
    private Object deserializeSimpleArray(Class arrType, Iterator<String> jsonIt) {
        String curLine;
        Class componentType = arrType.getComponentType();
        Collection collection = new ArrayList();

        while (jsonIt.hasNext()) {
            curLine = jsonIt.next();

            if (curLine.equals("]") || curLine.equals("],")) {
                break;
            }

            String valueStr = getValueStr(curLine, -1);

            collection.add(deserializeValue(componentType, valueStr, jsonIt));
        }

        Object arrObj = Array.newInstance(componentType, collection.size());
        Iterator colIt = collection.iterator();
        for (int i = 0; i < collection.size(); i++) {
            Array.set(arrObj, i, colIt.next());
        }

        return arrObj;
    }

    private String getFieldStr(String jsonLine, int separatorIndex) {
        String fieldStr = jsonLine.substring(0, separatorIndex).trim();
        return fieldStr.substring(1, fieldStr.length() - 1);
    }

    private String getValueStr(String jsonLine, int separatorIndex) {
        String valueStr = jsonLine.substring(separatorIndex + 1).trim();
        if (valueStr.endsWith(","))
            valueStr = valueStr.substring(0, valueStr.length() - 1);
        return valueStr;
    }

    private Field getFieldByName(Class<?> objType, String fieldStr) throws NoSuchFieldException {
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

    private Iterator<String> getJsonIt(String jsonString) {
        return jsonString.lines().map(String::trim).toList().iterator();
    }
}
