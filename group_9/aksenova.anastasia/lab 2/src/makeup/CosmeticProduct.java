package makeup;
import java.util.Objects;

public abstract class CosmeticProduct {
    protected String name;
    protected double price;

    public CosmeticProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void describe();

    @Override
    public String toString() {
        return "Продукт: " + name + ", Цена: $" + price;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CosmeticProduct product = (CosmeticProduct) obj;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }


    public boolean deepEquals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CosmeticProduct product = (CosmeticProduct) obj;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}