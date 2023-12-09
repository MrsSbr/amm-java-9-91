package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReflectionApiUtil {

    public static final String GET_METHOD_PREFIX = "get";

    public static <E> Method getGetterMethod(final E entity, final String name) {
        try {
            return entity.getClass()
                .getMethod(GET_METHOD_PREFIX + name.substring(0, 1).toUpperCase() + name.substring(1));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static <E> String getRepresentationValueInQuery(Method method, E entity) {
        final Class<?> returnType = method.getReturnType();
        final var invoke = methodInvoke(method, entity);
        if (returnType == Long.class) {
            return invoke + "L";
        }
        if (returnType == String.class ||
            returnType == LocalDate.class ||
            returnType == LocalDateTime.class) {
            return "'" + invoke + "'";
        } else {
            return String.valueOf(invoke);
        }
    }

    private static <E> Object methodInvoke(final Method method, final E entity) {
        try {
            return method.invoke(entity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
