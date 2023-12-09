package Exceptions;

public class NotValidGameTimeInHoursException extends RuntimeException {
    public NotValidGameTimeInHoursException(String message) {
        super(message);
    }
}
