package src.Aircrafts;

import java.util.Objects;

public abstract class Aircraft implements Flyable {

    protected final AircraftModel model;
    protected String boardNumber;

    public Aircraft(AircraftModel model, String boardNumber) {
        this.model = model;
        this.boardNumber = boardNumber;
    }

    public AircraftModel getModel() {
        return model;
    }

    public String getBoardNumber() {
        return boardNumber;
    }

    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }

    @Override
    public void fly() {
        System.out.println(this + " is flying.");
    }

    public abstract void refuel();

    @Override
    public String toString() {
        return model.getDescription() + " with board number " + boardNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Aircraft aircraft)) {
            return false;
        }

        return Objects.equals(model, aircraft.model) && Objects.equals(boardNumber, aircraft.boardNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, boardNumber);
    }
}
