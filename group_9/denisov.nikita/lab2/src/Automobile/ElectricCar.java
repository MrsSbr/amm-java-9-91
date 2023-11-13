package Automobile;

import java.util.Objects;

public class ElectricCar extends Automobile implements Vehicle {
    private double maximumSpeed;

    public ElectricCar(String brand, String model, double maximumSpeed) {
        super(brand, model);
        this.maximumSpeed = maximumSpeed;
    }

    public double getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(double maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    @Override
    public void start() {
        super.start();
        System.out.println(" (электрический автомобиль)");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println(" (электрический автомобиль)");
    }

    @Override
    public String toString() {
        return super.toString() + " " + "максимальная скорость " + maximumSpeed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maximumSpeed);
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }

        ElectricCar electricCar = (ElectricCar) object;

        return Objects.equals(maximumSpeed, electricCar.maximumSpeed);
    }
}
