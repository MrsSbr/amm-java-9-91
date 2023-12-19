package org.example.exceptions;

public class ConstructorNotFoundException extends RuntimeException {
    private final Class<?> clazz;

    public ConstructorNotFoundException(Class<?> clazz) {
        this.clazz = clazz;
    }

    public ConstructorNotFoundException(String message, Class<?> clazz) {
        super(message);
        this.clazz = clazz;
    }

    public ConstructorNotFoundException(String message, Throwable cause, Class<?> clazz) {
        super(message, cause);
        this.clazz = clazz;
    }

    public ConstructorNotFoundException(Throwable cause, Class<?> clazz) {
        super(cause);
        this.clazz = clazz;
    }

    public ConstructorNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Class<?> clazz) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.clazz = clazz;
    }

    public Class<?> ofClass() {
        return clazz;
    }
}