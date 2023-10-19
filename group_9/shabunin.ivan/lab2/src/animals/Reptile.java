package animals;

import java.util.Objects;
import java.util.Random;

public abstract class Reptile extends ZooAnimal {
    protected int averageLength;

    protected int length;

    public Reptile(String name, int age, ZooAnimal.Sex sex, int length) {
        super(name, age, sex);
        this.length = length;
    }

    @Override
    public void move() {
        String[] movements = new String[]{" is crawling.", " is swimming."};
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
        Reptile reptile = (Reptile) obj;
        return (age == reptile.age) && (sex == reptile.sex)
                && Objects.equals(name, reptile.name) && (length == reptile.length);
    }
}
