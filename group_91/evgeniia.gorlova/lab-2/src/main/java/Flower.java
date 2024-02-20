public class Flower extends Plant {
    private String color;

    public Flower(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    @Override
    public void grow() {
        age++;
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting flower: " + name);
    }

    @Override
    public void giveWater() {
        System.out.println("Giving water to flower: " + name);
    }
}

