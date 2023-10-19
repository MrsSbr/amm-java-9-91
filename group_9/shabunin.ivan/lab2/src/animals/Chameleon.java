package animals;

public class Chameleon extends Reptile{
    public Chameleon(String name, int age, ZooAnimal.Sex sex, int length) {
        super(name, age, sex, length);
        food = new Food[]{Food.Insects, Food.Worms};
        averageLifeExpectancy = 7;
        averageLength = 35;
    }

    public void changeColor() {
        System.out.println(toString() + " is changing its color.");
    }
}
