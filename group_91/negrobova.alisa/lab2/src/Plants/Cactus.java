package Plants;

public class Cactus extends Plant implements Waterable {
    private int spikesCount;

    public Cactus(String name, int waterLevel, int spikesCount) {
        super(name, waterLevel);
        if (spikesCount < 0) {
            throw new IllegalArgumentException("Color cannot be < 0");
        }
        this.spikesCount = spikesCount;
    }

    @Override
    public void water() {
        waterLevel += 5;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Cactus cactus = (Cactus) obj;

        if (waterLevel != cactus.waterLevel) {
            return false;
        }
        if (spikesCount != cactus.spikesCount) {
            return false;
        }
        return name.equals(cactus.name);
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 31 * result + waterLevel;
        result = 31 * result + spikesCount;
        return result;
    }

    @Override
    public String toString() {
        return "Cactus: " + name + ", Water Level: " + waterLevel + ", Spikes Count: " + spikesCount;
    }
}

