package org.example;

public class TaxiDriver {
    private String name;
    private double fuelConsumption;

    public TaxiDriver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}