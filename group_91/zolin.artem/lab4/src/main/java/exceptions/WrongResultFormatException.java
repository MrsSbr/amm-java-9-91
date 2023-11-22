package exceptions;

public class WrongResultFormatException extends RuntimeException {

    public WrongResultFormatException(String message, Throwable cause) {
        super(message, cause);
    }

}
