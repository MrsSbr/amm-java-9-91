package edu.deals.exceptions;

public class DealParseException extends RuntimeException {
    private final String parsedString;

    public DealParseException(String message, String parsedString, Throwable cause) {
        super(message, cause);
        this.parsedString = parsedString;
    }

    public String getParsedString() {
        return parsedString;
    }
}
