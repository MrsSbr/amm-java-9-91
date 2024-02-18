package enums;

public enum Size {

    XS("XS"),
    S("S"),
    M("M"),
    L("L"),
    XL("XL");

    private final String size;

    Size(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size;
    }

}