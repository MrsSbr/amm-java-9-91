public class Vegetable extends Plant {
    private String type;

    public Vegetable(String name, int age, String type) {
        super(name, age);
        this.type = type;
    }

    @Override
    public void grow() {
        age += 2;
    }

    @Override
    public void harvest() {
        System.out.println("Harvesting vegetable: " + name);
    }

    @Override
    public void giveWater() {
        System.out.println("Giving water to vegetable: " + name);
    }
}

