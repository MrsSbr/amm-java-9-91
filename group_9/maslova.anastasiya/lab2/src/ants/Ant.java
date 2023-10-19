package ants;

import java.util.Objects;

/**
 * The Ant class serves as a base class for all ant types.
 */
public abstract class Ant {
    protected String name;

    /**
     * Constructor to initialize an ant with a name.
     *
     * @param name The name of the ant.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public Ant(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    /**
     * Get the name of the ant.
     *
     * @return The name of the ant.
     */
    public String getName() {
        return name;
    }

    /**
     * Perform work specific to the ant type.
     */
    public abstract void work();

    /**
     * Check if two ants are equal based on their names.
     *
     * @param obj The object to compare.
     * @return true if the ants have the same name, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ant ant = (Ant) obj;
        return name.equals(ant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Ant{" +
                "name='" + name + '\'' +
                '}';
    }
}
