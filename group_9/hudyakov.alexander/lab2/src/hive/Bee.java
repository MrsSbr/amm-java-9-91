package hive;

import java.util.UUID;

public abstract class Bee {
    private int age;
    private double size;
    private final UUID id;
    public Bee(int age, double size) {
        this.age = age;
        this.size = size;
        id  = UUID.randomUUID();
    }
    public UUID getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public double getSize() {
        return size;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public abstract String getStatus();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bee bee = (Bee) o;

        if (age != bee.age) return false;
        if (Double.compare(size, bee.size) != 0) return false;
        return id.equals(bee.id);
    }
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = age;
        temp = Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + id.hashCode();
        return result;
    }
    @Override
    public String toString() {
        return "Bee{" +
                "age=" + age +
                ", size=" + size +
                ", id=" + id +
                '}';
    }
}
