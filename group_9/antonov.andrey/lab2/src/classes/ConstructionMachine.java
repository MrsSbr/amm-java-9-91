package classes;

public abstract class ConstructionMachine implements ConstructionVehicle {
    private final int loadCapacity;

    public ConstructionMachine(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }
}
