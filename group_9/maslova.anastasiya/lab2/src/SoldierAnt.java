/**
 * The SoldierAnt class represents an ant type that is focused on colony defense and is capable of fighting.
 */
public class SoldierAnt extends Ant implements Fighter {

    public SoldierAnt(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(name + " is defending the colony.");
    }

    @Override
    public void fight() {
        System.out.println(name + " is fighting an enemy.");
    }

    @Override
    public String toString() {
        return "SoldierAnt named " + name;
    }
}

