package Furniture;

public abstract class AbstractFurniture implements Furniture { // Абстрактный класс для мебели
    private String name;
    private double price;
    public AbstractFurniture(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void commonAssemblySteps() {
        System.out.println("Common assembly steps for " + name);
    }
    @Override
    public String toString() {
        return "Furniture: " + name + ", Price: $" + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        AbstractFurniture that = (AbstractFurniture) obj;
        return Double.compare(that.price, price) == 0 &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Double.hashCode(price);
        return result;
    }
}