package Vehicle;

import java.util.Objects;

public class Motorbike extends Vehicle implements VehicleInterface {
    double fuelCapacity;

    public Motorbike(String brand, String model, double fuelCapacity) {
        super(brand, model);
        this.fuelCapacity = fuelCapacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public void start() {
        super.start();
        System.out.println(" (Мотоцикл)");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println(" (Мотоцикл)");
    }

    @Override
    public String toString() {
        return super.toString() + ", емкость топливного бака: " + fuelCapacity;
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object) ||
                !(object instanceof Motorbike motorbike)) {
            return false;
        }

        return Objects.equals(fuelCapacity, motorbike.fuelCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fuelCapacity);
    }
}
