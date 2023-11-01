public class Grenade extends Consumables {
    private final String type;

    public Grenade(String name, int quantity, String type) {
        super(name, quantity);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void use() {
        System.out.println("Throw me to the enemy, then I myself");
    }

    @Override
    public String toString() {
        return super.toString() + ", Type: " + type;
    }

    @Override
    public String getAddInfo() {
        return "Type: " + type;
    }
}
