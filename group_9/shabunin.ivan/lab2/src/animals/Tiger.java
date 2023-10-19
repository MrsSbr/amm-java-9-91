package animals;

import java.util.Random;

public class Tiger extends Mammal {
    public Tiger(String name, int age, ZooAnimal.Sex sex, int length, int weight) {
        super(name, age, sex, length, weight);
        food = new Food[]{Food.Meat, Food.Meat, Food.Wheat, Food.Fish};
        averageLifeExpectancy = 20;
        averageLength = 115;
        averageWeight = 220;
    }

    public void roar() {
        System.out.println(toString() + " is roaring.");
    }

    @Override
    public void move() {
        String[] movements = new String[]{" is walking.", " is running.", " is licking."};
        Random rand = new Random();
        System.out.println(this.toString() + movements[rand.nextInt(movements.length)]);
    }
}
