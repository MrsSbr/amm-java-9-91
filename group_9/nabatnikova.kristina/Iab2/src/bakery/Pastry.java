package bakery;

import bakery.BakeryProducts;

import java.util.Objects;

public abstract class Pastry implements BakeryProducts {
    protected String name;
    protected int weight;
    protected int price;
    protected boolean condition;

    public Pastry(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        condition = false;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == this.getClass()) {
            if (this == obj)
                return true;
            Pastry pastry = (Pastry) obj;
            return weight == pastry.weight && Objects.equals(name, pastry.name) && price == pastry.price;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price);
    }

    public abstract void baking();

    public void sale() {
        if (!condition) {
            System.out.println("There is no " + name + " ready at the moment, but we will cook it now.");
            baking();
        }
        System.out.println("That'll be " + price + " rubles. Enjoy your meal!");
    }

}
