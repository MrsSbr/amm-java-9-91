package Automobile;

import java.util.Objects;

public class GasolineCar extends Automobile implements Vehicle {
    private double enginePower;

    public GasolineCar(String brand, String model, double enginePower) {
        super(brand, model);
        this.enginePower = enginePower;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    @Override
    public void start() {
        super.start();
        System.out.println(" (бензиновый автомобиль)");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println(" (бензиновый автомобиль)");
    }

    @Override
    public String toString() {
        return super.toString() + " " + enginePower + " литров";
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enginePower);
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }

        GasolineCar gasolineCar = (GasolineCar) object;

        return Objects.equals(enginePower, gasolineCar.enginePower);
    }
}
