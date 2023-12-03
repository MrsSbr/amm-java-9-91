package animals;

import java.util.Objects;
import java.util.Random;

public final class Iguana extends Reptile {
    private boolean lovesToSwim;

    public Iguana(String name, int age, Sex sex, int length, boolean lovesToSwim) {
        super(name, age, sex, length);
        this.lovesToSwim = lovesToSwim;
        food = new Food[] {Food.BERRIES, Food.FRUITS, Food.LEAVES, Food.FLOWERS};
        averageLifeExpectancy = 15;
        averageLength = 150;
    }

    public void bask() {
        System.out.println(this + " is basking in the sun.");
    }

    @Override
    public void move() {
        String[] movements;
        if (lovesToSwim) {
            movements = new String[] {" is crawling.", " is swimming.", " is swimming.", " is swimming."};
        } else {
            movements = new String[] {" is crawling.", " is crawling.", " is crawling.", " is swimming."};
        }
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
        Iguana iguana = (Iguana) obj;
        return (age == iguana.age) && (sex == iguana.sex) && Objects.equals(name, iguana.name)
                && (length == iguana.length)
                && (lovesToSwim == iguana.lovesToSwim);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, length, lovesToSwim);
    }

    @Override
    public String toString() {
        return "Iguana " + name;
    }
}
