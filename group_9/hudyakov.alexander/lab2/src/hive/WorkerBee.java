package hive;

public class WorkerBee extends Bee, implements Worker {

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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        WorkerBee workerBee = (WorkerBee) object;

        if (java.lang.Double.compare(honeyProduced, workerBee.honeyProduced) != 0) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = java.lang.Double.doubleToLongBits(honeyProduced);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
