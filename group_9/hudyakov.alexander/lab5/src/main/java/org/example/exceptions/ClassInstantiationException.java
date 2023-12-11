package org.example.exceptions;

public class ClassInstantiationException extends RuntimeException {
    private final Class<?> clazz;

    public ClassInstantiationException(Class<?> clazz) {
        this.clazz = clazz;
    }

    public ClassInstantiationException(String message, Class<?> clazz) {
        super(message);
        this.clazz = clazz;
    }

    public ClassInstantiationException(String message, Throwable cause, Class<?> clazz) {
        super(message, cause);
        this.clazz = clazz;
    }

    public ClassInstantiationException(Throwable cause, Class<?> clazz) {
        super(cause);
        this.clazz = clazz;
    }

    public ClassInstantiationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Class<?> clazz) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.clazz = clazz;
    }

    public Class<?> ofClass() {
        return clazz;
    }
}
