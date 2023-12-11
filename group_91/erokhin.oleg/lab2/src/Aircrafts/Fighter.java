package src.Aircrafts;

public class Fighter extends Aircraft {

    public Fighter(String model) {
        super(model);
    }

    @Override
    public void fly() {
        System.out.println("Fighter plane " + super.toString() + " is flying.");
    }

    @Override
    public void refuel() {
        System.out.println("Refueling the fighter plane.");
    }
}
