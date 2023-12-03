package colony;

import ants.Ant;
import ants.Fighter;
import ants.QueenAnt;
import ants.SoldierAnt;
import ants.WorkerAnt;

/**
 * The ColonyMain class serves as the application entry point to demonstrate various ant actions and behaviors.
 */
public class ColonyMain {
    public static void main(String[] args) {
        try {
            Ant worker = new WorkerAnt("Worker");
            Ant soldier = new SoldierAnt("Solider");
            Ant queen = new QueenAnt("Queen");

            performAntAction(worker);
            performAntAction(soldier);
            performAntAction(queen);
        } catch (IllegalArgumentException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Perform the action of the given ant, including work and potentially fighting.
     *
     * @param ant The ant to perform the action.
     */
    private static void performAntAction(Ant ant) {
        ant.work();
        if (ant instanceof Fighter) {
            ((Fighter) ant).fight();
        }
    }
}
