package animals;

import java.util.Objects;
import java.util.Random;

public abstract class Mammal extends ZooAnimal {
    protected int averageLength;
    protected int averageWeight;

    protected int length;
    protected int weight;

    public Mammal(String name, int age, ZooAnimal.Sex sex, int length, int weight) {
        super(name, age, sex);
        this.length = length;
        this.weight = weight;
    }

    @Override
    public void move() {
        String[] movements = new String[]{" is walking.", " is running."};
        Random rand = new Random();
        System.out.println(this.toString() + movements[rand.nextInt(movements.length)]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Mammal mammal = (Mammal) obj;
        return (age == mammal.age) && (sex == mammal.sex) && Objects.equals(name, mammal.name)
                && (length == mammal.length) && (weight == mammal.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, length, weight);
    }
}
