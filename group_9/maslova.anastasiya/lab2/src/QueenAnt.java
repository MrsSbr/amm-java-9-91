/**
 * The QueenAnt class represents the queen of the colony, vital for producing new ants.
 */
public class QueenAnt extends Ant {

    public QueenAnt(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(name + " is laying eggs.");
    }
}

