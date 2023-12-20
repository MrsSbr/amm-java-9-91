package src.Aircrafts;

public class FighterJet extends Aircraft {

    private final int missileCount;

    public FighterJet(AircraftModel model, String boardNumber, int missileCount) {
        super(model, boardNumber);
        this.missileCount = missileCount;
    }

    public int getMissileCount() {
        return missileCount;
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println("Equipped with " + missileCount + " missiles.");
    }

    @Override
    public void refuel() {
        System.out.println("Fighter Jet " + this + " is being refueled.");
    }

    public void engage() {
        System.out.println("Fighter Jet " + this + " is engaging the enemy with " + missileCount + " missiles.");
    }
}
