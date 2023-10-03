package hive;

public class WorkerBee extends Bee implements Worker {
    private double honeyProduced;
    public WorkerBee(int age, double size) {
        super(age, size);
        this.honeyProduced = 0;
    }
    public WorkerBee(int age, double size, double honeyProduced) {
        super(age, size);
        this.honeyProduced = honeyProduced;
    }
    public double getHoneyProduced() {
        return honeyProduced;
    }
    public void setHoneyProduced(double honeyProduced) {
        this.honeyProduced = honeyProduced;
    }
    @Override
    public String getStatus() {
        return "Worker";
    }
    @Override
    public void work() {
        honeyProduced += Math.random() * 3 * getSize();
    }
    @Override
    public String getWorkDescription() {
        return "Producing honey";
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        WorkerBee workerBee = (WorkerBee) object;

        return Double.compare(honeyProduced, workerBee.honeyProduced) == 0;
    }
    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = java.lang.Double.doubleToLongBits(honeyProduced);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public String toString() {
        return "WorkerBee{" +
                "honeyProduced=" + honeyProduced +
                "} " + super.toString();
    }
}
