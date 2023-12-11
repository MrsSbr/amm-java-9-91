package src.Aircrafts;

import java.util.Objects;

public abstract class Aircraft implements IFlyable {

    private String model;

    public Aircraft(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void fly() {
        System.out.println(model + " is flying.");
    }

    public abstract void refuel();

    @Override
    public String toString() {
        return model;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Aircraft aircraft)) {
            return false;
        }

        return Objects.equals(model, aircraft.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }
}
