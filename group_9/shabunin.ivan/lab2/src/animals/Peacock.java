package animals;

import java.util.Objects;
import java.util.Random;

public final class Peacock extends Bird {
    boolean isAlbino;

    public Peacock(String name, int age, Sex sex, int wingspan, boolean isAlbino) {
        super(name, age, sex, wingspan);
        this.isAlbino = isAlbino;
        food = new Food[] {Food.CORN, Food.WHEAT};
        averageLifeExpectancy = 20;
        isCapableOfFlight = true;
        averageWingspan = 160;
    }

    public void spreadTail() {
        System.out.println(this + " is spreading its tail.");
    }

    @Override
    public void move() {
        String[] movements = new String[] {" is flying.", " is walking importantly.", " is walking importantly."};
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
        Peacock peacock = (Peacock) obj;
        return (age == peacock.age) && (sex == peacock.sex) && Objects.equals(name, peacock.name)
                && (wingspan == peacock.wingspan)
                && (isAlbino == peacock.isAlbino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, wingspan, isAlbino);
    }

    @Override
    public String toString() {
        if (isAlbino) {
            return "Albino Peacock " + name;
        }
        return "Peacock " + name;
    }
}
