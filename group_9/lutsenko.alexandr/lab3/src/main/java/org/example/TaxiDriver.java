package org.example;
import java.util.List;

public class TaxiDriver {
    private String name;
    private String carBrand;
    private String carModel;
    private double fuelConsumption;

    public TaxiDriver(String name, String carBrand, String carModel) {
        this.name = name;
        this.carBrand = carBrand;
        this.carModel = carModel;
    }

    public String getName() {
        return name;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}