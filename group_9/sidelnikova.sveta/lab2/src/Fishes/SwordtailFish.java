package Fishes;

import java.util.HashSet;
import java.util.Set;

public class SwordtailFish extends AquariumFish {
    private boolean fertility;

    public static Set<AquariumFish> incompatibility;

    static {
        incompatibility = new HashSet<>();
        incompatibility.add(new MelanohromisyFish());
    }

    public SwordtailFish() {
        super();
    }

    public SwordtailFish(String name, String age, String color) {
        super(name, age, color);
        fertility = random.nextBoolean();
    }

    @Override
    public String getFishType() {
        return "SwordtailFish";
    }

    @Override
    public String getFoodType() {
        return "Flake feed and granules, small animals and insects, fresh vegetables";
    }

    @Override
    public void specialBehavior() {
        System.out.println(getFishType() + " is very peaceful");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || object.getClass() != getClass())
            return false;
        if (!super.equals(object))
            return false;
        SwordtailFish other = (SwordtailFish) object;
        return fertility == other.fertility;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (fertility ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Fertility: " + fertility + "\n";
    }
}
