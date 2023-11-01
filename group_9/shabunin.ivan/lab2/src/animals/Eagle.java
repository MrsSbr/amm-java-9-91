package animals;

import java.util.Objects;

public final class Eagle extends Bird {
    EagleType type;

    public enum EagleType {
        GOLDEN, BROWN, SOLITARY, BLACK, AFRICAN;

        @Override
        public String toString() {
            String name = name();
            String firstLetter = name.substring(0, 1);
            String restOfName = name.substring(1).toLowerCase();
            return firstLetter + restOfName;
        }
    }

    public Eagle(EagleType type, String name, int age, Sex sex, int wingspan) {
        super(name, age, sex, wingspan);
        this.type = type;
        food = new Food[] {Food.MICE, Food.MICE, Food.FISH, Food.FISH, Food.INSECTS};
        averageLifeExpectancy = 30;
        isCapableOfFlight = true;
        averageWingspan = 200;
    }

    public void sitProudly() {
        System.out.println(this + " is sitting proudly.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Eagle eagle = (Eagle) obj;
        return (age == eagle.age) && (sex == eagle.sex) && Objects.equals(name, eagle.name)
                && (wingspan == eagle.wingspan)
                && Objects.equals(type, eagle.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, wingspan, type);
    }

    @Override
    public String toString() {
        return type.toString() + " Eagle " + name;
    }
}
