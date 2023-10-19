package animals;

public class Iguana extends Reptile {
    public Iguana(String name, int age, ZooAnimal.Sex sex, int length) {
        super(name, age, sex, length);
        food = new Food[]{Food.Berries, Food.Fruits, Food.Leaves, Food.Flowers};
        averageLifeExpectancy = 15;
        averageLength = 150;
    }

    public void bask() {
        System.out.println(toString() + " is basking in the sun.");
    }
}
