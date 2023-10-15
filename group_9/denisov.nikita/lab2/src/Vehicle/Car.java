package Vehicle;

import java.util.Objects;

public class Car extends Vehicle implements VehicleInterface {
    private double speed;
    private double currentSpeed;

    public Car(String brand, String model, double speed) {
        super(brand, model);
        this.speed = speed;
        currentSpeed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    @Override
    public void start() {
        currentSpeed = speed;

        super.start();
        System.out.println("\nСкорость машины: " + speed);
    }

    @Override
    public void stop() {
        currentSpeed = 0;

        super.stop();
        System.out.println("\nСкорость машины: 0");
    }

    @Override
    public String toString() {
        return super.toString() + ", скорость " + speed;
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object) ||
                !(object instanceof Car car)) {
            return false;
        }

        return Objects.equals(speed, car.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speed);
    }
}
