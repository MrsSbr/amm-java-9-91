import java.util.HashSet;
import java.util.Set;

public class Hive {

    private final Set<Bee> bees;

    public Hive() {
        bees = new HashSet<>();
    }

    public void addBee(Bee bee) {
        bees.add(bee);
    }

    public void watchBees() {
        for (Bee bee : bees) {
            System.out.printf("%s is %s\n", bee.toString(), bee.getWorkDescription());
        }
    }

}
