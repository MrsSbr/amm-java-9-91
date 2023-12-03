package ships;

import java.util.Objects;

public abstract class Ship {

    private final String name;
    private final int displacement;

    public Ship(String name, int displacement) {
        this.name = name;
        this.displacement = displacement;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getName() {
        return name;
    }

    public abstract void sail();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ship ship = (Ship) o;
        return displacement == ship.displacement && Objects.equals(name, ship.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displacement);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", displacement=" + displacement +
                '}';
    }

}
