package Automobile;

import java.util.Objects;

public abstract class Automobile implements Vehicle {
    private String brand;
    private String model;

    public Automobile(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.print("Автомобиль (" + this + ") начал движение.");
    }

    @Override
    public void stop() {
        System.out.print("Автомобиль (" + this + ") остановился.");
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Automobile automobile = (Automobile) object;

        return Objects.equals(brand, automobile.brand) &&
                Objects.equals(model, automobile.model);
    }
}