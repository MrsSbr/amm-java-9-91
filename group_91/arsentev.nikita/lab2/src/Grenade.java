import java.util.Objects;

public class Grenade extends Consumables {
    private final String type;

    public Grenade(String name, int quantity, String type) {
        super(name, quantity);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void use() {
        System.out.println("Throw me to the enemy, then I myself");
    }

    @Override
    public String getAddInfo() {
        return "Type: " + type;
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Grenade grenade = (Grenade) o;
        return Objects.equals(getType(), grenade.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType());
    }
}
