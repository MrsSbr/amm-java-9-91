package src.satellite;

import src.satellite.enums.Orbit;
import src.satellite.enums.Status;
import src.satellite.enums.Type;

import java.util.Objects;

public class NavigationSatellite extends Satellite implements Spacecraft {

    String country;

    public NavigationSatellite(String name, Orbit orbit, String country) {
        super(name, orbit, Type.NAVIGATION);
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
        NavigationSatellite navigationSatellite = (NavigationSatellite) o;
        return country.equals(navigationSatellite.country);
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
