package bakery;

public class Cupcake extends Pastry {
    private String sprinkling;

    public Cupcake(String name, int weight, int price, String sprinkling) {
        super(name, weight, price);
        this.sprinkling = sprinkling;
    }

    public String getSprinkling() {
        return sprinkling;
    }

    public void setSprinkling(String newSprinkling) {
        sprinkling = newSprinkling;
    }

    public void baking() {
        System.out.println("The cupcake is being prepared, please wait...");
        System.out.println("We make sprinkling...");
        condition = true;
        System.out.println("The cupcake is ready!");
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Weight: " + weight + "g" + "\n"
                + "Price: " + price + "\n" + "Sprinkling: " + sprinkling + "\n";
    }
    
}
