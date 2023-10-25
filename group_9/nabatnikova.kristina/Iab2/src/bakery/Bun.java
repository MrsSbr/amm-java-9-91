package bakery;

public class Bun extends Pastry {
    private String filling;
    private String sprinkling;

    public Bun(String name, int weight, int price, String filling, String sprinkling) {
        super(name, weight, price);
        this.filling = filling;
        this.sprinkling = sprinkling;
    }

    public String getFilling() {
        return filling;
    }

    public String getSprinkling() {
        return sprinkling;
    }

    public void setFilling(String newFilling) {
        filling = newFilling;
    }

    public void setSprinkling(String newSprinkling) {
        sprinkling = newSprinkling;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Weight: " + weight + "g" + "\n"
                + "Price: " + price + "\n" + "Filling: " + filling + "\n"
                + "Sprinkling: " + sprinkling + "\n";
    }

    public void baking() {
        System.out.println("Add the filling...");
        System.out.println("The bun is being prepared, please wait...");
        System.out.println("We make sprinkling...");
        condition = true;
        System.out.println("The bun is ready!");
    }

    @Override
    public void sale() {
        System.out.println("I'm so sorry! The cash register broke down. We can't sell you a bun.");
    }
}
