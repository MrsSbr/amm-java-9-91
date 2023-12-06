package org.sql.queries;

import org.sql.queries.annotations.TableSQL;
import org.sql.queries.annotations.PrimaryKey;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SqlQueryGenerator {
    public String generateInsertQueries(Object entity) {
        StringBuilder query = new StringBuilder();
        Class<?> typeClass = entity.getClass();
        List<Field> listFields = Arrays.stream(typeClass.getDeclaredFields()).toList();
        String fields = listFields.stream()
                                  .filter(x->!x.isAnnotationPresent(PrimaryKey.class))
                                  .map(Field::getName)
                                  .collect(Collectors.joining(", "));
        String values = listFields.stream()
                                  .filter(field -> !field.isAnnotationPresent(PrimaryKey.class))
                                  .peek(field -> field.setAccessible(true))
                                  .map(field -> {
                                      try {
                                          return field.get(entity) != null ? field.get(entity).toString() : "NULL";
                                      } catch (IllegalAccessException ex) {
                                          throw new RuntimeException(ex);
                                      }
                                  })
                                  .collect(Collectors.joining(", "));
        String nameTable = typeClass.getAnnotation(TableSQL.class)
                                    .nameTable();
        return query.append("INSERT INTO ")
                    .append(nameTable)
                    .append(" (")
                    .append(fields)
                    .append(")\nVALUES (")
                    .append(values)
                    .append(");")
                    .toString();
    }

    public String generateSelectAllEntitiesQuery(Class<?> typeClass) {
        if(typeClass == null) {
            throw new RuntimeException();
        }
        StringBuilder query = new StringBuilder();
        String nameTable = typeClass.getAnnotation(TableSQL.class)
                                    .nameTable();
        return query.append("SELECT *\nFROM ")
                    .append(nameTable)
                    .append(";")
                    .toString();
    }

    public String generateSelectByPrimaryKeyEntityQuery(Class<?> typeClass, Integer pk) {
        if(pk == null || typeClass == null) {
            throw new RuntimeException();
        }
        Field primaryKey = Arrays.stream(typeClass.getDeclaredFields())
                                 .filter(field -> field.isAnnotationPresent(PrimaryKey.class))
                                 .findFirst()
                                 .get();
        String nameTable = typeClass.getAnnotation(TableSQL.class)
                                    .nameTable();
        StringBuilder query = new StringBuilder();
        return query.append("SELECT *\nFROM ")
                    .append(nameTable)
                    .append("\nWHERE ")
                    .append(primaryKey.getName())
                    .append(" = ")
                    .append(pk)
                    .append(";")
                    .toString();
    }

    public String generateUpdateEntitiesQuery(Object entity) {
        StringBuilder query = new StringBuilder();
        List<Field> entityFields = Arrays.stream(entity.getClass().getDeclaredFields()).toList();
        Field primaryKey = entityFields.stream()
                                       .filter(field -> field.isAnnotationPresent(PrimaryKey.class))
                                       .findFirst()
                                       .get();
        primaryKey.setAccessible(true);
        String pk = "";
        try {
            if(primaryKey.get(entity) == null) {
                throw new RuntimeException();
            }
            pk = primaryKey.get(entity).toString();
        } catch(IllegalAccessException ex) {
            throw new RuntimeException();
        }
        String nameTable = entity.getClass()
                                 .getAnnotation(TableSQL.class)
                                 .nameTable();
        String fields = entityFields.stream()
                                    .filter(field -> !field.isAnnotationPresent(PrimaryKey.class))
                                    .peek(field -> field.setAccessible(true))
                                    .map(field -> {
                                        try {
                                            return field.getName() + " = " + field.get(entity);
                                        } catch (IllegalAccessException ex) {
                                            throw new RuntimeException(ex);
                                        }
                                    })
                                    .collect(Collectors.joining(", "));
        return query.append("UPDATE ")
                    .append(nameTable)
                    .append("\nSET ")
                    .append(fields)
                    .append("\nWHERE ")
                    .append(primaryKey.getName())
                    .append(" = ")
                    .append(pk)
                    .append(";")
                    .toString();
    }
    public String generateDeleteByPrimaryKeyEntityQuery(Class<?> typeClass, Integer pk) {
        if(pk == null || typeClass == null) {
            throw new RuntimeException();
        }
        StringBuilder query = new StringBuilder();
        Field primaryKey = Arrays.stream(typeClass.getDeclaredFields())
                                 .filter(field -> field.isAnnotationPresent(PrimaryKey.class))
                                 .findFirst()
                                 .get();
        String tableName = typeClass.getAnnotation(TableSQL.class).nameTable();
        return query.append("DELETE from ")
                    .append(tableName)
                    .append("\nWHERE ")
                    .append(primaryKey.getName())
                    .append(" = ")
                    .append(pk)
                    .append(";")
                    .toString();
    }
}