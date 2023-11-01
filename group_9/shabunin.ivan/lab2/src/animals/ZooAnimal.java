package animals;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public abstract class ZooAnimal implements Alive {
    protected Food[] food;
    protected int averageLifeExpectancy;

    protected String name;
    protected int age;

    public enum Sex {
        MALE, FEMALE
    }

    protected Sex sex;

    public ZooAnimal(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public void eat() {
        Random rand = new Random(food.length);
        String f = (food.length > 0) ? food[rand.nextInt(food.length)].toString().toLowerCase() : "";
        System.out.println(this + " is eating " + f + '.');
    }

    @Override
    public void move() {
        System.out.println(this + " is moving.");
    }

    @Override
    public void sleep() {
        System.out.println(this + " is sleeping.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ZooAnimal zooAnimal = (ZooAnimal) obj;
        return (averageLifeExpectancy == zooAnimal.averageLifeExpectancy)
                && (age == zooAnimal.age) && (Arrays.equals(food, zooAnimal.food))
                && (Objects.equals(name, zooAnimal.name)) && (sex == zooAnimal.sex);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(averageLifeExpectancy, name, age, sex);
        result = 31 * result + Arrays.hashCode(food);
        return result;
    }

    @Override
    public String toString() {
        return "Animal " + name;
    }
}
