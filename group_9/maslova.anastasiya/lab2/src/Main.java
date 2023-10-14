/**
 * The Main class serves as the application entry point to demonstrate various ant actions and behaviors.
 */
public class Main {

    public static void main(String[] args) {
        Ant worker = new WorkerAnt("Worker");
        Ant soldier = new SoldierAnt("Soldier");
        Ant queen = new QueenAnt("Queen");

        performAntAction(worker);
        performAntAction(soldier);
        performAntAction(queen);
    }

    /**
     * Perform actions and print information related to the ant.
     *
     * @param ant An instance of Ant to perform actions on.
     */
    private static void performAntAction(Ant ant) {
        ant.work();

        if(ant instanceof Fighter) {
            ((Fighter) ant).fight();
        }

        if(ant instanceof SoldierAnt) {
            System.out.println(ant + " is ready to fight!");
        } else {
            System.out.println(ant + " is not a soldier.");
        }
    }
}
