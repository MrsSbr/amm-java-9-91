public class WorkerBee extends Bee {

    public WorkerBee(int age, double size) {
        super(age, size);
    }

    @Override
    public String getWorkDescription() {
        return "Producing honey";
    }

    @Override
    public String getStatus() {
        return "Worker";
    }

}
