package converter;

public class Utils {
    public static boolean isWrappedPrimitive(Class<?> obj) {
        return obj == Double.class || obj == Float.class || obj == Long.class
                || obj == Integer.class || obj == Short.class || obj == Character.class
                || obj == Byte.class || obj == Boolean.class || obj == Void.class;
    }
}
