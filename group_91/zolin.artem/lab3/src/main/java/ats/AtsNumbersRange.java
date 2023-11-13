package ats;

public record AtsNumbersRange(int atsId, int start, int end) {

    public AtsNumbersRange {
        if (start > end) {
            throw new IllegalArgumentException("start must be less than or equal to end");
        }
    }

}
