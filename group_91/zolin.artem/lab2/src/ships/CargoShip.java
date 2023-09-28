package ships;

import java.util.Objects;

public class CargoShip extends Ship implements CivilShip {

    private int totalCargoWeight;

    public CargoShip(String name, int displacement) {
        super(name, displacement);
    }

    public void addCargo(int cargoWeight) {
        totalCargoWeight += cargoWeight;
    }

    public int getTotalCargoWeight() {
        return totalCargoWeight;
    }

    @Override
    public String getDescription() {
        return "Грузовой корабль";
    }

    @Override
    public void sail() {
        System.out.println("Грузовой корабль " + getName()
                + " отправляется в плавание. Вес груза : " + totalCargoWeight);
        if (totalCargoWeight > 300) {
            totalCargoWeight -= 300;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoShip cargoShip = (CargoShip) o;
        return totalCargoWeight == cargoShip.totalCargoWeight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalCargoWeight);
    }

    @Override
    public String toString() {
        return "CargoShip{" +
                "totalCargoWeight=" + totalCargoWeight +
                "} " + super.toString();
    }

}
