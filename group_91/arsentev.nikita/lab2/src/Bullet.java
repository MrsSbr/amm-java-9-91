import java.util.Objects;

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
    public String getAddInfo() {
        return "Caliber: " + caliber;
    }

    @Override
    public String toString() {
        return super.toString() + ", Caliber: " + caliber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Bullet bullet = (Bullet) o;
        return getCaliber() == bullet.getCaliber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), caliber);
    }
}
