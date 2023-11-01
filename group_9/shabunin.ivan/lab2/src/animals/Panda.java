package animals;

import java.util.Objects;

public final class Panda extends Mammal {
    private PandaCharacter character;

    public enum PandaCharacter {
        KIND, SULLEN, FUNNY, SAD, MERRY, SHY, STUPID;

        @Override
        public String toString() {
            String name = name();
            String firstLetter = name.substring(0, 1);
            String restOfName = name.substring(1).toLowerCase();
            return firstLetter + restOfName;
        }
    }

    public Panda(String name, int age, Sex sex, int length, int weight, PandaCharacter character) {
        super(name, age, sex, length, weight);
        this.character = character;
        food = new Food[] {Food.BAMBOO};
        averageLifeExpectancy = 25;
        averageLength = 150;
        averageWeight = 120;
    }

    public void rollOnTheGround() {
        System.out.println(this + " is rolling on the ground.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Panda panda = (Panda) obj;
        return (age == panda.age) && (sex == panda.sex) && Objects.equals(name, panda.name)
                && (length == panda.length) && (weight == panda.weight)
                && Objects.equals(character, panda.character);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, length, weight, character);
    }

    @Override
    public String toString() {
        return character.toString() + " Panda " + name;
    }
}
