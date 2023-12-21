package src.Aircrafts;

public class Bomber extends Aircraft {

    private final int maxBombLoad;

    public Bomber(AircraftModel model, String boardNumber, int maxBombLoad) {
        super(model, boardNumber);
        this.maxBombLoad = maxBombLoad;
    }

    public int getMaxBombLoad() {
        return maxBombLoad;
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("Carrying a bomb load of " + maxBombLoad + ".");
    }

    @Override
    public void refuel() {
        System.out.println("Bomber " + this + " is being refueled.");
    }

    public void bomb() {
        System.out.println("Bomber " + this + " is dropping a bomb.");
    }
}
