package ships;

import java.util.Objects;

public class WarShip extends Ship {

    private int missiles;

    public WarShip(String name, int displacement) {
        super(name, displacement);
    }

    public boolean attack(Ship ship) {
        if (ship instanceof CivilShip civilShip) {
            System.out.println(getName()+ " проплывает мимо "
                    + ship.getName() + " (" + civilShip.getDescription() + ')');
            return false;
        }
        if (missiles > 0) {
            --missiles;
            System.out.println(getName() + " атакует " + ship.getName());
            return true;
        } else {
            System.out.println("У " + getName() + " нет ракет!");
            return false;
        }
    }

    public void loadMissiles(int count) {
        missiles += count;
    }

    public int getMissilesCount() {
        return missiles;
    }

    @Override
    public void sail() {
        System.out.println("Военный корабль " + getName() + " отправляется в плавание");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WarShip warShip = (WarShip) o;
        return missiles == warShip.missiles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), missiles);
    }

    @Override
    public String toString() {
        return "WarShip{" +
                "missiles=" + missiles +
                "} " + super.toString();
    }

}
