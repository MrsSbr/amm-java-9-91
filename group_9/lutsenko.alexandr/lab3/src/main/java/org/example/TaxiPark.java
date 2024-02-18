package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaxiPark {
    private List<TaxiDriver> drivers;

    public TaxiPark(int numDrivers) {
        drivers = new ArrayList<>();
        for (int i = 1; i <= numDrivers; i++) {
            drivers.add(new TaxiDriver("Driver " + i));
        }
    }

    public void analyzeFuelConsumption(int numDays) {
        Random random = new Random();

        for (int day = 1; day <= numDays; day++) {
            System.out.println("Day " + day + ":");

            double totalFuelConsumption = 0;

            for (TaxiDriver driver : drivers) {
                double consumption = random.nextDouble() * 20;
                driver.setFuelConsumption(driver.getFuelConsumption() + consumption);
                totalFuelConsumption += consumption;
            }

            System.out.println("Total fuel consumption for day " + day + ": " + totalFuelConsumption);
            System.out.println();
        }

        System.out.println("Total fuel consumption for each driver:");
        drivers.forEach(driver ->
                System.out.println(driver.getName() + ": " + driver.getFuelConsumption()));
    }

    public void resetFuelConsumption() {
        drivers.forEach(driver -> driver.setFuelConsumption(0.0));
    }

    public double getTotalFuelConsumption() {
        return drivers.stream().mapToDouble(TaxiDriver::getFuelConsumption).sum();
    }

    public double getDriverFuelConsumption(String driverName) {
        return drivers.stream()
                .filter(driver -> driver.getName().equals(driverName))
                .findFirst()
                .map(TaxiDriver::getFuelConsumption)
                .orElse(0.0);
    }

    public static void main(String[] args) {
        TaxiPark taxiPark = new TaxiPark(20);
        taxiPark.analyzeFuelConsumption(5);
    }
}