package hive;

import java.util.HashSet;
import java.util.Set;

public class Hive implements Worker {

    private final Set<Bee> bees;

    private boolean hasQueen;

    public boolean isHasQueen() {
        return hasQueen;
    }

    public Hive() {
        bees = new HashSet<>();
        hasQueen = false;
    }

    public double getTotalHoney() {
        return bees
                .stream()
                .filter(b -> b instanceof WorkerBee)
                .map(b -> (WorkerBee) b)
                .mapToDouble(WorkerBee::getHoneyProduced)
                .sum();
    }

    public void addBee(Bee bee) {
        if (bee instanceof Queen queen) {
            if (isHasQueen()) {
                throw new ExtraQueenException("There can't be more than one queen in a hive", queen);
            }
            hasQueen = true;
        }
        bees.add(bee);
    }

    public void watchBees() {
        for (Bee bee : bees) {
            System.out.printf("%s is %s\n", bee.toString(), bee.getWorkDescription());
        }
    }

    @Override
    public String getWorkDescription() {
        return "Bees are busy in the hive";
    }

    @Override
    public void work() {
        bees.forEach(Bee::work);
    }

}
