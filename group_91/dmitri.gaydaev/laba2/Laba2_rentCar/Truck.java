package Laba2_rentCar;

import java.util.Objects;

public class Truck extends Automobile implements Vehicle {
    private int loadCapacity;

    public Truck(String brand, String model, String isRent, int enginePower) {
        super(brand, model, isRent);
        this.loadCapacity = enginePower;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void classCar() {
        super.classCar();
        System.out.println("грузовой");
    }

    @Override
    public String toString() {
        return super.toString() + " " + loadCapacity + " тонн";
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }

        Truck truck = (Truck) object;

        return Objects.equals(loadCapacity, truck.loadCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), loadCapacity);
    }

}

