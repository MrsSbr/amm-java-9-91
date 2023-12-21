package Exceptions;

public class NotValidTitleException extends RuntimeException {
    public NotValidTitleException(String message) {
        super(message);
    }
}

