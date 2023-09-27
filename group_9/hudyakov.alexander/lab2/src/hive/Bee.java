package hive;

public abstract class Bee implements Worker {

    private int age;

    private double size;

    public Bee(int age, double size) {
        this.age = age;
        this.size = size;
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

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
