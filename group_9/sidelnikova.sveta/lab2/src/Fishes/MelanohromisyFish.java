package Fishes;

import java.util.HashSet;
import java.util.Set;

public class MelanohromisyFish extends AquariumFish {
    private boolean aggression;

    public static Set<AquariumFish> incompatibility;

    static {
        incompatibility = new HashSet<>();
        incompatibility.add(new GuppyFish());
        incompatibility.add(new GoldFish());
        incompatibility.add(new SwordtailFish());
    }

    public MelanohromisyFish() {
        super();
    }

    public MelanohromisyFish(String name, String age, String color) {
        super(name, age, color);
        aggression = random.nextBoolean();
    }

    @Override
    public String getFishType() {
        return "MelanohromisyFish";
    }

    @Override
    public String getFoodType() {
        return "Small molluscs, worms, invertebrates";
    }

    @Override
    public void specialBehavior() {
        System.out.println(getFishType() + " are very aggressive to other tank mates");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || object.getClass() != getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        MelanohromisyFish other = (MelanohromisyFish) object;
        return aggression == other.aggression;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (aggression ? 1 : 0);
        ;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Aggression: " + aggression + "\n";
    }
}