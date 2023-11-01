package animals;

import java.util.Objects;
import java.util.Random;

public final class Tiger extends Mammal {
    TigerSubspecies subspecies;

    public enum TigerSubspecies {
        BENGAL, SIBERIAN, INDOCHINESE, MALAYAN, SUMATRAN;

        @Override
        public String toString() {
            String name = name();
            String firstLetter = name.substring(0, 1);
            String restOfName = name.substring(1).toLowerCase();
            return firstLetter + restOfName;
        }
    }

    public Tiger(TigerSubspecies subspecies, String name, int age, Sex sex, int length, int weight) {
        super(name, age, sex, length, weight);
        this.subspecies = subspecies;
        food = new Food[] {Food.MEAT, Food.MEAT, Food.MEAT, Food.WHEAT, Food.FISH};
        averageLifeExpectancy = 20;
        averageLength = 115;
        averageWeight = 220;
    }

    public void roar() {
        System.out.println(this + " is roaring.");
    }

    @Override
    public void move() {
        String[] movements = new String[] {" is walking.", " is running.", " is licking."};
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
        Tiger tiger = (Tiger) obj;
        return (age == tiger.age) && (sex == tiger.sex) && Objects.equals(name, tiger.name)
                && (length == tiger.length) && (weight == tiger.weight)
                && Objects.equals(subspecies, tiger.subspecies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, length, weight, subspecies);
    }

    @Override
    public String toString() {
        return subspecies.toString() + " Tiger " + name;
    }
}
