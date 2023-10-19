package ants;

/**
 * The SoldierAnt class represents an ant type that is focused on colony defense and is capable of fighting.
 */
public class SoldierAnt extends Ant implements Fighter {
    private int battlesWon;

    /**
     * Constructor to initialize a SoldierAnt with a name.
     *
     * @param name The name of the SoldierAnt.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public SoldierAnt(String name) {
        super(name);
        this.battlesWon = 0;
    }

    /**
     * Get the number of battles won by the soldier ant.
     *
     * @return The number of battles won.
     */
    public int getBattlesWon() {
        return battlesWon;
    }

    /**
     * Work as a soldier ant in colony defense.
     */
    @Override
    public void work() {
        System.out.println(name + " is defending the colony.");
    }

    /**
     * Fight as a soldier ant and increase the number of battles won.
     */
    @Override
    public void fight() {
        battlesWon = battlesWon + 1;
        System.out.println(name + " has won " + battlesWon + " battles.");
    }

    /**
     * Check if two soldier ants are equal based on their names and battles won.
     *
     * @param obj The object to compare.
     * @return true if the ants have the same name and battles won, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        SoldierAnt soldierAnt = (SoldierAnt) obj;
        return battlesWon == soldierAnt.battlesWon;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + battlesWon;
    }

    @Override
    public String toString() {
        return "SoldierAnt{" +
                "name='" + name + '\'' +
                ", battlesWon=" + battlesWon +
                '}';
    }
}
