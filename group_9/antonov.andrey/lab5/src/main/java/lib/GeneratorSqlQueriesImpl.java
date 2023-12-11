package lib;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import annotaion.Column;
import annotaion.Table;
import util.ReflectionApiUtil;


public class GeneratorSqlQueriesImpl<K, E> implements GeneratorSqlQueries<K, E> {

    private final Class<?> CLASS;

    public GeneratorSqlQueriesImpl(final Class<?> CLASS) {
        this.CLASS = Objects.requireNonNull(CLASS, "CLASS не может быть null");
    }

    private static final String INSERT_TEMPLATE_SQL = """
        INSERT INTO %s.%s (%s)
        VALUES (%s);
        """;

    private static final String FIND_BY_ID_TEMPLATE_SQL = """
        SELECT %s
        FROM %s.%s
        WHERE id = %s;
        """;

    private static final String FIND_ALL_TEMPLATE_SQL = """
        SELECT %s
        FROM %s.%s;
        """;

    public static final String UPDATE_TEMPLATE_SQL = """
        UPDATE %s.%s
        SET %s
        WHERE id = %s;
        """;

    public static final String DELETE_TEMPLATE_SQL = """
        DELETE FROM %s.%s
        WHERE id = %s;
        """;

    @Override
    public String buildInsertQuery(final E entity) {
        final var table = entity.getClass().getAnnotation(Table.class);
        final var fields = entity.getClass().getDeclaredFields();
        final var fieldNames = getFieldNames(fields);
        final var filedValues = getFiledValues(entity, fields);
        return String.format(INSERT_TEMPLATE_SQL, table.schema(), table.name(), fieldNames, filedValues);
    }

    @Override
    public String buildSelectByIdQuery(K id) {
        final var table = CLASS.getAnnotation(Table.class);
        final var fields = CLASS.getDeclaredFields();
        final var fieldNames = getFieldNames(fields);
        return String.format(FIND_BY_ID_TEMPLATE_SQL, fieldNames, table.schema(), table.name(), id);
    }

    @Override
    public String buildSelectAllQuery() {
        final var table = CLASS.getAnnotation(Table.class);
        final var fields = CLASS.getDeclaredFields();
        final var fieldNames = getFieldNames(fields);
        return String.format(FIND_ALL_TEMPLATE_SQL, fieldNames, table.schema(), table.name());
    }

    @Override
    public String buildUpdateQuery(final E entity) {
        final var table = entity.getClass().getAnnotation(Table.class);
        final var fields = entity.getClass().getDeclaredFields();
        final var update = Arrays.stream(fields)
            .filter(field -> field.isAnnotationPresent(Column.class))
            .collect(getFieldMapCollector(entity))
            .entrySet()
            .stream()
            .map(entry -> entry.getKey() + " = " + entry.getValue())
            .collect(Collectors.joining(", "));
        final var getterMethod = ReflectionApiUtil.getGetterMethod(entity, "Id");
        final var id = ReflectionApiUtil.getRepresentationValueInQuery(getterMethod, entity);
        return String.format(UPDATE_TEMPLATE_SQL, table.schema(), table.name(), update, id);
    }

    @Override
    public String buildDeleteQuery(final K id) {
        final var table = CLASS.getAnnotation(Table.class);
        return String.format(DELETE_TEMPLATE_SQL, table.schema(), table.name(), id);
    }

    private static <E> Collector<Field, ?, Map<String, String>> getFieldMapCollector(final E entity) {
        return Collectors.toMap
            (
                field -> field.getAnnotation(Column.class).name(),
                field -> ReflectionApiUtil.getRepresentationValueInQuery(
                    ReflectionApiUtil.getGetterMethod(entity, field.getName()), entity)
            );
    }

    private static String getFieldNames(final Field[] fields) {
        return Arrays.stream(fields)
            .filter(field -> field.isAnnotationPresent(Column.class))
            .sorted(Comparator.comparing(Field::getName))
            .map(field -> field.getAnnotation(Column.class))
            .map(Column::name)
            .collect(Collectors.joining(", "));
    }

    private static <E> String getFiledValues(final E entity, final Field[] fields) {
        return Arrays.stream(fields)
            .filter(field -> field.isAnnotationPresent(Column.class))
            .sorted(Comparator.comparing(Field::getName))
            .map(field -> ReflectionApiUtil.getGetterMethod(entity, field.getName()))
            .map(method -> ReflectionApiUtil.getRepresentationValueInQuery(method, entity))
            .collect(Collectors.joining(", "));
    }
}
