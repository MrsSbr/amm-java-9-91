public class Car extends Vehicle implements VehicleInterface {
    private final double speed;
    private double currentSpeed;

    Car(String brand, String model, double speed) {
        super(brand, model);
        this.speed = speed;
        this.currentSpeed = speed;
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
        return super.toString() + " скорость " + speed;
    }
}
