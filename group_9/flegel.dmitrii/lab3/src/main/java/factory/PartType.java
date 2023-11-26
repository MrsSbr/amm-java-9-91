package factory;

public enum PartType {
    ENGINE_PART("Engine Part"),
    ELECTRICAL_PART("Electrical Part"),
    BODY_PART("Body Part"),
    INTERIOR_PART("Interior Part");

    private final String displayName;

    PartType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}