package makeup;
import java.util.Objects;
public class Lipstick extends CosmeticProduct {
    private String color;

    public Lipstick(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    @Override
    public void describe() {
        System.out.println("Это помада. Цвет: " + color);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Lipstick lipstick = (Lipstick) obj;
        return Double.compare(lipstick.price, price) == 0 &&
                Objects.equals(name, lipstick.name) &&
                Objects.equals(color, lipstick.color);
    }
}
