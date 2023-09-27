package hive;

public class WorkerBee extends Bee {

    private double honeyProduced;

    public void setHoneyProduced(double honeyProduced) {
        this.honeyProduced = honeyProduced;
    }

    public double getHoneyProduced() {
        return honeyProduced;
    }

    public WorkerBee(int age, double size) {
        super(age, size);
        this.honeyProduced = 0;
    }

    public WorkerBee(int age, double size, double honeyProduced) {
        super(age, size);
        this.honeyProduced = honeyProduced;
    }

    @Override
    public String getWorkDescription() {
        return "Producing honey";
    }

    @Override
    public String toString() {
        return String.format("%s, honeyProduced = %f", super.toString(), honeyProduced);
    }

    @Override
    public String getStatus() {
        return "Worker";
    }

    @Override
    public void work() {
        honeyProduced += Math.random() * 3 * getSize();
    }
}
