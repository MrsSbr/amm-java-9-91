package Laba2_rentCar;

import java.util.Objects;

public abstract class Automobile implements Vehicle {
    private String brand;
    private String model;
    private String isRent;

    public Automobile(String brand, String model, String isRent) {
        this.brand = brand;
        this.model = model;
        this.isRent = isRent;
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
    public String toString() {
        return brand + " " + model + " " + isRent;
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

    @Override
    public int hashCode() {
        return Objects.hash(brand, model);
    }

    @Override
    public void classCar() {
       System.out.println("Автомобилб типа: ");
    }

}

