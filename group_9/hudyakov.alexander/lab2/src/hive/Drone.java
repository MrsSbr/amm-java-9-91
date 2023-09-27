package hive;

public class Drone extends Bee {

    private int larvaeCared;

    public void setLarvaeCared(int larvaeCared) {
        this.larvaeCared = larvaeCared;
    }

    public int getLarvaeCared() {
        return larvaeCared;
    }

    public Drone(int age, double size) {
        super(age, size);
        this.larvaeCared = 0;
    }

    public Drone(int age, double size, int larvaeCared) {
        super(age, size);
        this.larvaeCared = larvaeCared;
    }

    @Override
    public String toString() {
        return String.format("%s, larvaeCared = %d", super.toString(), larvaeCared);
    }

    @Override
    public String getWorkDescription() {
        return "Taking care of the larvae";
    }

    @Override
    public void work() {
        larvaeCared += 1;
    }

    @Override
    public String getStatus() {
        return "Drone";
    }
}
