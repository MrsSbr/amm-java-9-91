package hive;

public abstract class Bee {

    private int age;

    private double size;

    public int getId() {
        return id;
    }

    private final int id;

    private static int nextId = 0;

    public Bee(int age, double size) {
        this.age = age;
        this.size = size;
        id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public abstract String getStatus();

    @Override
    public String toString() {
        return String.format("%s: age = %d, size = %f", getStatus(), age, size);
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Bee bee = (Bee) object;

        if (age != bee.age) return false;
        if (java.lang.Double.compare(size, bee.size) != 0) return false;
        if (id != bee.id) return false;

        return true;
    }

    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + age;
        temp = java.lang.Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + id;
        return result;
    }
}
