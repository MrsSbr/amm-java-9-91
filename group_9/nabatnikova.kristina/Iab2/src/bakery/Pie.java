package bakery;

public class Pie extends Pastry {
    private String filling;

    public Pie(String name, int weight, int price, String filling) {
        super(name, weight, price);
        this.filling = filling;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String newFilling) {
        filling = newFilling;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" + "Weight: " + weight + "g" + "\n"
                + "Price: " + price + "\n" + "Filling: " + filling + "\n";
    }

    public void baking() {
        System.out.println("Add the filling...");
        System.out.println("The pie is being prepared, please wait...");
        condition = true;
        System.out.println("The pie is ready!");
    }
}
