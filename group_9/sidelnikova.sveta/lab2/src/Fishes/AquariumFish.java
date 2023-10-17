package Fishes;

import java.util.Objects;
import java.util.Random;

public abstract class AquariumFish implements AquaticAnimal {

    final Random random = new Random();

    private final String color;

    private final String name;

    private final String age;

    public AquariumFish() {
        color = "";
        name = "";
        age = "";
    }

    public AquariumFish(String name, String age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public abstract String getFishType();

    public abstract String getFoodType();

    @Override
    public void eat() {
        System.out.println(getName() + " is eating");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming");
    }

    @Override
    public void sleep() {
        System.out.println(getName() + " is sleeping");
    }

    @Override
    public void play() {
        System.out.println(getName() + " is playing with other " + getFishType() + "s");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != getClass()) {
            return false;
        }
        AquariumFish other = (AquariumFish) object;
        return Objects.equals(color, other.color) && Objects.equals(name, other.name) &&
                Objects.equals(age, other.age);
    }

    @Override
    public int hashCode() {
        int result = age != null ? age.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Type: " + getFishType() + "\n" +
                "Color: " + color + "\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n";
    }
}
