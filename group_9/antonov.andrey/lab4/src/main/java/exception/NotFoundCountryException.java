package exception;

public class NotFoundCountryException extends ParseException{

    public NotFoundCountryException(final String countryNotFoundMessage) {
        super(countryNotFoundMessage);
    }
}
