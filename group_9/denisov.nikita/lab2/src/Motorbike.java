public class Motorbike extends Vehicle implements VehicleInterface {

    Motorbike(String brand, String model) {
        super(brand, model);
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
}
