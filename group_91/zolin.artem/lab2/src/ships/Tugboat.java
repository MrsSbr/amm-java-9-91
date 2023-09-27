package ships;

public class Tugboat extends Ship implements CivilShip {

    public Tugboat(String name, int displacement) {
        super(name, displacement);
    }

    public void tug(Ship ship) {
        System.out.println(getName() + " буксирует " + ship.getName());
    }

    @Override
    public String getDescription() {
        return "Буксир";
    }

    @Override
    public void sail() {
        System.out.println("Буксир " + getName() + " плывёт кого-то буксировать");
    }

    @Override
    public String toString() {
        return "Tugboat{} " + super.toString();
    }

}
