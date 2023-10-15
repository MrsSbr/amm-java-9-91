package Vehicle;

import java.util.Objects;

public abstract class Vehicle implements VehicleInterface {
    private final String brand;
    private final String model;

    Vehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public void start() {
        System.out.print(this + " начало движение.");
    }

    @Override
    public void stop() {
        System.out.print(this + " остановилось.");
    }

    @Override
    public String toString() {
        return "Транспортное средство " + brand + ' ' + model;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Vehicle vehicle)) {
            return false;
        }

        return Objects.equals(brand, vehicle.brand) &&
                Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }
}