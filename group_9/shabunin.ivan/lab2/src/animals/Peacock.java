package animals;

import java.util.Random;

public class Peacock extends Bird{
    public Peacock(String name, int age, ZooAnimal.Sex sex, int wingspan) {
        super(name, age, sex, wingspan);
        food = new Food[]{Food.Corn, Food.Wheat};
        averageLifeExpectancy = 20;
        isCapableOfFlight = true;
        averageWingspan = 160;
    }

    public void spreadTail() {
        System.out.println(toString() + " is spreading its tail.");
    }

    @Override
    public void move() {
        String[] movements = new String[]{" is flying.", " is walking importantly.", " is walking importantly."};
        Random rand = new Random();
        System.out.println(this.toString() + movements[rand.nextInt(movements.length)]);
    }
}
