package animals;

import java.util.Objects;
import java.util.Random;

public abstract class Reptile extends ZooAnimal {
    protected int averageLength;

    protected int length;

    public Reptile(String name, int age, Sex sex, int length) {
        super(name, age, sex);
        this.length = length;
    }

    @Override
    public void move() {
        String[] movements = new String[] {" is crawling.", " is swimming."};
        Random rand = new Random();
        System.out.println(this + movements[rand.nextInt(movements.length)]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Reptile reptile = (Reptile) obj;
        return (age == reptile.age) && (sex == reptile.sex) && Objects.equals(name, reptile.name)
                && (averageLength == reptile.averageLength) && (length == reptile.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, averageLength, length);
    }

    @Override
    public String toString() {
        return "Reptile " + name;
    }
}
