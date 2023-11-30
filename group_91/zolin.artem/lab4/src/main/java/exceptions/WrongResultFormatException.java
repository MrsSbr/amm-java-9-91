package exceptions;

public class WrongResultFormatException extends RuntimeException {

    private final String failedLine;

    public WrongResultFormatException(String failedLine, String message, Throwable cause) {
        super(message, cause);
        this.failedLine = failedLine;
    }

    public String getFailedLine() {
        return failedLine;
    }
}
