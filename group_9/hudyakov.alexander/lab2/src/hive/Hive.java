package hive;

import java.util.HashSet;
import java.util.Set;

public class Hive {

    private final Set<Worker> workers;

    public Queen getQueen() {
        return queen;
    }

    private Queen queen;


    public Hive() {
        workers = new HashSet<>();
        queen = null;
    }

    public double getTotalHoney() {
        return workers
                .stream()
                .filter(b -> b instanceof WorkerBee)
                .map(b -> (WorkerBee) b)
                .mapToDouble(WorkerBee::getHoneyProduced)
                .sum();
    }

    public void addBee(Bee bee) {
        if (bee instanceof Queen q) {
            if (!queen.equals(null)) {
                throw new ExtraQueenException("There can't be more than one queen in a hive", queen);
            }
            queen = q;
        }
        else {
            workers.add(bee);
        }
    }

    public void watchBees() {
        for (Bee bee : workers) {
            System.out.printf("%s is %s\n", bee.toString(), bee.getWorkDescription());
        }
    }

    @Override
    public void cycle() {
        workers.forEach(Bee::work);
        if(!queen.equals(null)){
            queen.layEgg();
        }
    }

}
