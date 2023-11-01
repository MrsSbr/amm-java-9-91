package Plants;

import java.util.Objects;

public abstract class Plant {
    protected String name;
    protected int waterLevel;

    public Plant(String name, int waterLevel) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (waterLevel < 0) {
            throw new IllegalArgumentException("waterLevel cannot be < 0");
        }
        this.name = name;
        this.waterLevel = waterLevel;
    }

    public abstract void water();

    public String getName() {
        return name;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Plant plant = (Plant) obj;

        if (waterLevel != plant.waterLevel) {
            return false;
        }
        return name.equals(plant.name);
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 31 * result + waterLevel;
        return result;
    }

    @Override
    public String toString() {
        return "Plant: " + name + ", Water Level: " + waterLevel;
    }

}
