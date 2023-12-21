package org.sql.queries.exceptions;

import java.lang.reflect.Field;

public class FieldAccessException extends RuntimeException {
    private final Field field;

    public FieldAccessException(Field field) {
        this.field = field;
    }

    public FieldAccessException(String message, Field field) {
        super(message);
        this.field = field;
    }

    public FieldAccessException(String message, Throwable cause, Field field) {
        super(message, cause);
        this.field = field;
    }

    public FieldAccessException(Throwable cause, Field field) {
        super(cause);
        this.field = field;
    }

    public FieldAccessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Field field) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.field = field;
    }

    public Field getField() {
        return field;
    }
}
