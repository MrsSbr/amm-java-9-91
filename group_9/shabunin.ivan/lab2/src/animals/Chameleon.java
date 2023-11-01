package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public final class Chameleon extends Reptile {
    ChameleonColor currentColor;

    public enum ChameleonColor {
        GREEN, YELLOW, BLUE, VIOLET, RED, AZURE;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    public Chameleon(String name, int age, Sex sex, int length, ChameleonColor currentColor) {
        super(name, age, sex, length);
        this.currentColor = currentColor;
        food = new Food[] {Food.INSECTS, Food.WORMS};
        averageLifeExpectancy = 7;
        averageLength = 35;
    }

    public void changeColor() {
        ChameleonColor oldColor = currentColor;

        Random rand = new Random();
        List<ChameleonColor> colors = new ArrayList<>();
        for (ChameleonColor color : ChameleonColor.values()) {
            if (color.equals(currentColor)) {
                continue;
            }
            colors.add(color);
        }
        currentColor = colors.get(rand.nextInt(colors.size()));

        System.out.println(
                this + " is changing its color from " + oldColor.toString() + " to " + currentColor.toString() + ".");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Chameleon chameleon = (Chameleon) obj;
        return (age == chameleon.age) && (sex == chameleon.sex) && Objects.equals(name, chameleon.name)
                && (length == chameleon.length)
                && (Objects.equals(currentColor, chameleon.currentColor));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, length, currentColor);
    }

    @Override
    public String toString() {
        return "Chameleon " + name;
    }
}
