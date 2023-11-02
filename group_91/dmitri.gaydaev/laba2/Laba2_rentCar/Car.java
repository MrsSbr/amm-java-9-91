package Laba2_rentCar;

import java.util.Objects;

public class Car extends Automobile implements Vehicle {
    private int capacityPeople;

    public Car(String brand, String model, String isRent, int capacityPeople) {
        super(brand, model, isRent);
        this.capacityPeople = capacityPeople;
    }

    public double getCapacityPeople() {
        return capacityPeople;
    }

    public void setCapacityPeople(int capacityPeople) {
        this.capacityPeople = capacityPeople;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "максимальная вместительность пассажиров " + capacityPeople;
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }

        Car Car = (Car) object;

        return Objects.equals(capacityPeople, Car.capacityPeople);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), capacityPeople);
    }

    @Override
    public void classCar() {
        super.classCar();
        System.out.println("легковой");
    }
}
