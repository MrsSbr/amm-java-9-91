package src.satellite;

import src.satellite.enums.Orbit;
import src.satellite.enums.Status;
import src.satellite.enums.Type;

import java.util.Objects;

public abstract class Satellite implements Spacecraft {
    private final String name;
    private final Orbit orbit;
    private final Type type;
    private Status status;

    public Satellite(String name, Orbit orbit, Type type) {
        this.name = name;
        this.orbit = orbit;
        this.type = type;
        this.status = Status.OFF;
    }

    public String getName() {
        return name;
    }

    public Orbit getOrbit() {
        return orbit;
    }

    public Type getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public abstract String launch(String cosmodrome);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Satellite satellite = (Satellite) o;
        return name.equals(satellite.name) && orbit.equals(satellite.orbit) && type.equals(satellite.type) && status.equals(satellite.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, orbit, type);
    }

    @Override
    public String toString() {
        return "Спутник: " + name + ", орбита: " + orbit + ", тип: " + type + ", статус: " + status;
    }
}