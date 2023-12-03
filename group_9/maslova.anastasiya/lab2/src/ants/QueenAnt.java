package ants;

import java.util.Random;

/**
 * The QueenAnt class represents the queen of the colony, vital for producing new ants.
 */
public class QueenAnt extends Ant {
    private int eggsLaid;

    /**
     * Constructor to initialize a QueenAnt with a name.
     *
     * @param name The name of the QueenAnt.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public QueenAnt(String name) {
        super(name);
        this.eggsLaid = 0;
    }


    /**
     * Get the number of eggs laid by the queen ant.
     *
     * @return The number of eggs laid.
     */
    public int getEggsLaid() {
        return eggsLaid;
    }

    /**
     * Work as a queen ant and increase the number of eggs laid.
     */
    @Override
    public void work() {
        Random random = new Random();
        int randomTasks = random.nextInt(5);
        eggsLaid = eggsLaid + randomTasks;
        System.out.println(name + "  is laying eggs. Eggs laid:  " + eggsLaid);
    }

    /**
     * Check if two queen ants are equal based on their names and eggs laid.
     *
     * @param obj The object to compare.
     * @return true if the ants have the same name and eggs laid, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        QueenAnt queenAnt = (QueenAnt) obj;
        return eggsLaid == queenAnt.eggsLaid;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + eggsLaid;
    }

    @Override
    public String toString() {
        return "QueenAnt{" +
                "name='" + name + '\'' +
                ", eggsLaid=" + eggsLaid +
                '}';
    }
}
