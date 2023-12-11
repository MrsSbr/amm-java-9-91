package org.example.exceptions;

public class NotComponentException extends RuntimeException {
    private final Class<?> clazz;

    public NotComponentException(Class<?> clazz) {
        this.clazz = clazz;
    }

    public NotComponentException(String message, Class<?> clazz) {
        super(message);
        this.clazz = clazz;
    }

    public NotComponentException(String message, Throwable cause, Class<?> clazz) {
        super(message, cause);
        this.clazz = clazz;
    }

    public NotComponentException(Throwable cause, Class<?> clazz) {
        super(cause);
        this.clazz = clazz;
    }

    public NotComponentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Class<?> clazz) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.clazz = clazz;
    }

    public Class<?> ofClass() {
        return clazz;
    }
}
