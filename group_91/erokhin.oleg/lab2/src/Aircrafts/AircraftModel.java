package src.Aircrafts;

public enum AircraftModel {
    F22_RAPTOR("F-22 Raptor"),
    B52_STRATOFORTRESS("B-52 Stratofortress"),
    SU57("Sukhoi Su-57");

    private final String description;

    AircraftModel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}