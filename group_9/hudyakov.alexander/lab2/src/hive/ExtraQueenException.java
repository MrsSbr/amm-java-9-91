package hive;

public class ExtraQueenException extends RuntimeException {
    private final Queen extraQueen;
    public Queen getExtraQueen() {
        return extraQueen;
    }
    public ExtraQueenException(String message, Queen extraQueen) {
        super(message);
        this.extraQueen = extraQueen;
    }
}
