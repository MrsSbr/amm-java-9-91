package hive;

public class Drone extends Bee implements Worker {
    private int larvaeCared;
    public Drone(int age, double size) {
        super(age, size);
        this.larvaeCared = 0;
    }
    public Drone(int age, double size, int larvaeCared) {
        super(age, size);
        this.larvaeCared = larvaeCared;
    }
    public int getLarvaeCared() {
        return larvaeCared;
    }
    public void setLarvaeCared(int larvaeCared) {
        this.larvaeCared = larvaeCared;
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Drone drone = (Drone) object;

        return larvaeCared == drone.larvaeCared;
    }
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + larvaeCared;
        return result;
    }

    @Override
    public String toString() {
        return "Drone{" +
                "larvaeCared=" + larvaeCared +
                "} " + super.toString();
    }
}
