import java.util.Objects;

public abstract class Consumables implements Ammunition {
    private final String name;
    private final int quantity;

    public Consumables(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract String getAddInfo();

    @Override
    public String toString() {
        return "Name: " + name + ", Quantity: " + quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Consumables other = (Consumables) obj;
        return name.equals(other.name) && quantity == other.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quantity);
    }
}
