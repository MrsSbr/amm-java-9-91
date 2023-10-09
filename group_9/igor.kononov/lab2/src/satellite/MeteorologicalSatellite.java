package src.satellite;

import src.satellite.enums.Orbit;
import src.satellite.enums.Status;
import src.satellite.enums.Type;

import java.util.Objects;

public class MeteorologicalSatellite extends Satellite implements Spacecraft {
    String country;
    public MeteorologicalSatellite(String name, Orbit orbit, String country) {
        super(name, orbit, Type.METEOROLOGICAL);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String launch(String spaceports) {
        setStatus(Status.ON);
        return getName() +
                " был запущен с космодрома " +
                spaceports + ".";
    }

    @Override
    public String sendSignal() {
        if (getStatus() == Status.OFF) {
            return getName() +
                    " неактивен.";
        }
        return getName() +
                ", отправил сигнал.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        if (!super.equals(o)) return false;
        MeteorologicalSatellite meteorologicalSatellite = (MeteorologicalSatellite) o;
        return country.equals(meteorologicalSatellite.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country);
    }

    @Override
    public String toString() {
        return super.toString() +
                ", cтрана " + country;
    }
}
