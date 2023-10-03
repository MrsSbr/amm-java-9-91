package hive;

import java.util.HashSet;
import java.util.Set;

public class Hive {
    private final Set<Worker> workers;
    private Queen queen;
    public Hive() {
        workers = new HashSet<>();
        queen = null;
    }
    public Queen getQueen() {
        return queen;
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
            if (queen != null) {
                throw new ExtraQueenException("There can't be more than one queen in a hive", queen);
            }
            queen = q;
        } else if (bee instanceof Worker worker) {
            workers.add(worker);
        }
    }
    public void watchBees() {
        for (Worker bee : workers) {
            System.out.printf("%s is %s\n", bee.toString(), bee.getWorkDescription());
        }
    }
    public void cycle() {
        workers.forEach(Worker::work);
        if (queen != null) {
            queen.layEgg();
        }
    }
}
