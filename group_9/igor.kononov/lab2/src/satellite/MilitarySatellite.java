package src.satellite;

import src.satellite.enums.Orbit;
import src.satellite.enums.Status;
import src.satellite.enums.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MilitarySatellite extends Satellite implements Spacecraft, MilitarySpacecraft {

    private String country;

    public MilitarySatellite(String name, Orbit orbit, String country) {
        super(name, orbit, Type.MILITARY);
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
                " отправил сигнал.";
    }

    @Override
    public List<Satellite> targeting(List<Satellite> satelliteList, StringBuilder stringBuilder) {
        List<Satellite> targetList = new ArrayList<>();

        stringBuilder.append(getName());
        stringBuilder.append(" навелся на цели: ");

        for (Satellite satellite : satelliteList) {
            if (satellite instanceof MilitarySatellite) {
                stringBuilder.append(satellite.getName());
                stringBuilder.append(", ");

                targetList.add(satellite);
            }
        }

        return targetList;
    }

    public String emp(List<Satellite> satelliteList) {
        if (getStatus() == Status.OFF) {
            return getName() +
                    " неактивен.";
        }

        for (Satellite satellite : satelliteList) {
            if (satellite instanceof MilitarySatellite) {
                satellite.setStatus(Status.OFF);
            }
        }

        return getName() +
                " произвел электромагнитный импульс.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        if (!super.equals(o)) return false;
        MilitarySatellite militarySatellite = (MilitarySatellite) o;
        return country.equals(militarySatellite.country);
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
