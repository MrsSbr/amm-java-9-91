package Plants;

public class Flower extends Plant implements Waterable{
    private String color;

    public Flower(String name, int waterLevel, String color) {
        super(name, waterLevel);
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color cannot be null or empty");
        }
        this.color = color;
    }

    @Override
    public void water() {
        waterLevel += 10;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Flower flower = (Flower) obj;

        if (waterLevel != flower.waterLevel) {
            return false;
        }
        if (!color.equals(flower.color)) {
            return false;
        }
        return name.equals(flower.name);
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result = 31 * result + waterLevel;
        result = 31 * result + color.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Flower: " + name + ", Water Level: " + waterLevel + ", Color: " + color;
    }
}
