package org.sql.queries;

import org.sql.queries.annotations.TableSQL;
import org.sql.queries.annotations.PrimaryKey;
import org.sql.queries.exceptions.FieldAccessException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SqlQueryGenerator {
    public String generateInsertQueries(Object entity) {
        Class<?> typeClass = entity.getClass();
        List<Field> listFields = Arrays.stream(typeClass.getDeclaredFields()).toList();
        String fields = listFields.stream()
                .filter(x -> !x.isAnnotationPresent(PrimaryKey.class))
                .map(Field::getName)
                .collect(Collectors.joining(", "));
        String values = listFields.stream()
                .filter(field -> !field.isAnnotationPresent(PrimaryKey.class))
                .map(field -> {
                    field.setAccessible(true);
                    try {
                        return field.get(entity) != null ? convertField(field.get(entity)) : "NULL";
                    } catch (IllegalAccessException ex) {
                        throw new FieldAccessException("Невозможно получить доступ к private полю", field);
                    }
                })
                .collect(Collectors.joining(", "));
        String nameTable = typeClass.getAnnotation(TableSQL.class)
                .nameTable();
        return "INSERT INTO " +
                nameTable +
                " (" +
                fields +
                ")\nVALUES (" +
                values +
                ");";
    }

    public String generateSelectAllEntitiesQuery(Class<?> typeClass) {
        if (typeClass == null) {
            throw new NullPointerException("Тип класса имел значение NULL");
        }
        String nameTable = typeClass.getAnnotation(TableSQL.class)
                .nameTable();
        String fields = Arrays.stream(typeClass.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.joining(", "));
        return "SELECT " +
                fields +
                "\nFROM " +
                nameTable +
                ";";
    }

    public String generateSelectByPrimaryKeyEntityQuery(Class<?> typeClass, Integer pk) {
        if (pk == null) {
            throw new NullPointerException("Первичный ключ равен NULL");
        }
        if (typeClass == null) {
            throw new NullPointerException("Тип класса равен NULL");
        }
        Field primaryKey = Arrays.stream(typeClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(PrimaryKey.class))
                .findFirst()
                .orElseThrow(NullPointerException::new);
        String nameTable = typeClass.getAnnotation(TableSQL.class)
                .nameTable();
        String fields = Arrays.stream(typeClass.getDeclaredFields())
                .map(Field::getName)
                .collect(Collectors.joining(", "));
        return "SELECT " +
                fields +
                "\nFROM " +
                nameTable +
                "\nWHERE " +
                primaryKey.getName() +
                " = " +
                pk +
                ";";
    }

    public String generateUpdateEntitiesQuery(Object entity) {
        List<Field> entityFields = Arrays.stream(entity.getClass().getDeclaredFields()).toList();
        Field primaryKey = entityFields.stream()
                .filter(field -> field.isAnnotationPresent(PrimaryKey.class))
                .findFirst()
                .orElseThrow(NullPointerException::new);
        primaryKey.setAccessible(true);
        String pk = "";
        try {
            if (primaryKey.get(entity) == null) {
                throw new NullPointerException("Первичный ключ равен NULL");
            }
            pk = primaryKey.get(entity).toString();
        } catch (IllegalAccessException ex) {
            throw new FieldAccessException("Невозможно получить доступ к private полю", primaryKey);
        }
        String nameTable = entity.getClass()
                .getAnnotation(TableSQL.class)
                .nameTable();
        String fields = entityFields.stream()
                .filter(field -> !field.isAnnotationPresent(PrimaryKey.class))
                .map(field -> {
                    field.setAccessible(true);
                    try {
                        return field.getName() + " = " + convertField(field.get(entity));
                    } catch (IllegalAccessException ex) {
                        throw new FieldAccessException("Невозможно получить доступ к private полю", field);
                    }
                })
                .collect(Collectors.joining(", "));
        return "UPDATE " +
                nameTable +
                "\nSET " +
                fields +
                "\nWHERE " +
                primaryKey.getName() +
                " = " +
                pk +
                ";";
    }

    public String generateDeleteByPrimaryKeyEntityQuery(Class<?> typeClass, Integer pk) {
        if (pk == null) {
            throw new NullPointerException("Первичный ключ равен NULL");
        }
        if (typeClass == null) {
            throw new NullPointerException("Тип класса равен NULL");
        }
        Field primaryKey = Arrays.stream(typeClass.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(PrimaryKey.class))
                .findFirst()
                .orElseThrow(NullPointerException::new);
        String tableName = typeClass.getAnnotation(TableSQL.class).nameTable();
        return "DELETE from " +
                tableName +
                "\nWHERE " +
                primaryKey.getName() +
                " = " +
                pk +
                ";";
    }

    private String convertField(Object field) {
        if (field instanceof String stringField) {
            stringField = stringField.replaceAll("'", "''");
            return "'" + stringField + "'";
        } else {
            return field.toString();
        }
    }
}