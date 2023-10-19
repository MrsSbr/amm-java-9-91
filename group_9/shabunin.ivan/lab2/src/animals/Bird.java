package animals;

import java.util.Objects;

public abstract class Bird extends ZooAnimal {
    protected int averageWingspan;
    protected boolean isCapableOfFlight;

    protected int wingspan;

    public Bird(String name, int age, ZooAnimal.Sex sex, int wingspan) {
        super(name, age, sex);
        this.wingspan = wingspan;
    }

    @Override
    public void move() {
        String movement = (isCapableOfFlight) ? " is flying." : " is walking.";
        System.out.println(this.toString() + movement);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Bird bird = (Bird) obj;
        return (age == bird.age) && (sex == bird.sex)
                && Objects.equals(name, bird.name) && (wingspan == bird.wingspan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, wingspan);
    }
}
