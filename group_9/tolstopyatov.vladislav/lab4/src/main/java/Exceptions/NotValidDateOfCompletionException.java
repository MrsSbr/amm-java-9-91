package Exceptions;

public class NotValidDateOfCompletionException extends RuntimeException {
    public NotValidDateOfCompletionException(String message) {
        super(message);
    }
}
