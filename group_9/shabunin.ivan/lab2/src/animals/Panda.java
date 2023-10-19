package animals;

public class Panda extends Mammal {
    public Panda(String name, int age, ZooAnimal.Sex sex, int length, int weight) {
        super(name, age, sex, length, weight);
        food = new Food[]{Food.Bamboo};
        averageLifeExpectancy = 25;
        averageLength = 150;
        averageWeight = 120;
    }

    public void rollOnTheGround() {
        System.out.println(toString() + " is rolling on the ground.");
    }
}
