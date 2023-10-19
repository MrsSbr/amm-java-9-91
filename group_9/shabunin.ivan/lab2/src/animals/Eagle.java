package animals;

public class Eagle extends Bird {
    public Eagle(String name, int age, ZooAnimal.Sex sex, int wingspan) {
        super(name, age, sex, wingspan);
        food = new Food[]{Food.Mice, Food.Mice, Food.Fish, Food.Fish, Food.Insects};
        averageLifeExpectancy = 30;
        isCapableOfFlight = true;
        averageWingspan = 200;
    }

    public void sitProudly() {
        System.out.println(toString() + " is sitting proudly.");
    }
}
