import java.util.Objects;

public abstract class Plant implements Plantable {
    protected String name;
    protected int age;

    public Plant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Plant plant = (Plant) obj;
        return age == plant.age && Objects.equals(name, plant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public abstract void giveWater();
}
