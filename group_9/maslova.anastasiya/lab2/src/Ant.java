/**
 * Abstract representation of an ant, providing a base structure for specialized ant types.
 */
public abstract class Ant {

    protected String name;

    /**
     * Constructor to create an Ant with a specific name.
     *
     * @param name The name of the ant.
     */
    public Ant(String name) {
        this.name = name;
    }

    /**
     * Abstract method to perform a work action, to be implemented by subclasses.
     */
    public abstract void work();

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Ant ant = (Ant) obj;
        return name.equals(ant.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Ant named " + name;
    }
}
