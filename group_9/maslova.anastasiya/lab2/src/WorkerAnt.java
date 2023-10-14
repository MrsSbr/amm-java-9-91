/**
 * The WorkerAnt class represents an ant type that performs general labor.
 */
public class WorkerAnt extends Ant {

    public WorkerAnt(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(name + " is working hard.");
    }
}

