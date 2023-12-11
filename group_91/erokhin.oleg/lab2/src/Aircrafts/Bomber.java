package src.Aircrafts;

public class Bomber extends Aircraft {

    public Bomber(String model) {
        super(model);
    }

    @Override
    public void fly() {
        System.out.println("Bomber plane " + super.toString() + " is flying.");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the bomber plane.");
    }
}
