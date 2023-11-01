public class Bullet extends Consumables {
    private final int caliber;

    public Bullet(String name, int quantity, int caliber) {
        super(name, quantity);
        this.caliber = caliber;
    }

    public int getCaliber() {
        return caliber;
    }

    @Override
    public void use() {
        System.out.println("Put me in the gun and fire!!!");
    }

    @Override
    public String toString() {
        return super.toString() + ", Caliber: " + caliber;
    }

    @Override
    public String getAddInfo() {
        return "Caliber: " + caliber;
    }
}
