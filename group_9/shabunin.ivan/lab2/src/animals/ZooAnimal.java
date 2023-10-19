package animals;

import java.util.Objects;
import java.util.Random;

public abstract class ZooAnimal implements Animal {
    protected Food[] food;
    protected int averageLifeExpectancy;

    protected String name;
    protected int age;

    public enum Sex {
        Male, Female;
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
        System.out.println(this.toString() + " is eating " + f + '.');
    }

    @Override
    public void move() {
        System.out.println(this.toString() + " is moving.");
    }

    @Override
    public void sleep() {
        System.out.println(this.toString() + " is sleeping.");
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
        return (age == zooAnimal.age) && (sex == zooAnimal.sex) && Objects.equals(name, zooAnimal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return getClass().getName() + " " + name;
    }
}
