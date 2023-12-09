package Exceptions;

public class NotValidGenreException extends RuntimeException {
    public NotValidGenreException(String message) {
        super(message);
    }
}
