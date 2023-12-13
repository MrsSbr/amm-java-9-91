package exceptions;

public class DeserializeException extends RuntimeException {
    public DeserializeException() {
    }

    public DeserializeException(String message) {
        super(message);
    }

    public DeserializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
