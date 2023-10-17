package Fishes;

import java.util.HashSet;
import java.util.Set;

public class GoldFish extends AquariumFish {
    private int numberOfEggsPerSpawn;

    public static Set<AquariumFish> incompatibility;

    static {
        incompatibility = new HashSet<>();
        incompatibility.add(new MelanohromisyFish());
    }

    public GoldFish() {
        super();
    }

    public GoldFish(String name, String age, String color) {
        super(name, age, color);
        numberOfEggsPerSpawn = random.nextInt(1500) + 1500;
    }

    @Override
    public String getFishType() {
        return "GoldFish";
    }

    @Override
    public String getFoodType() {
        return "Flake feed and granules, small animals and insects, fresh vegetables";
    }

    @Override
    public void specialBehavior() {
        System.out.println(getFishType() + " recognizes their handlers");
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
        GoldFish other = (GoldFish) object;
        return numberOfEggsPerSpawn == other.numberOfEggsPerSpawn;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numberOfEggsPerSpawn;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Number of eggs per spawn: " + numberOfEggsPerSpawn + "\n";
    }
}
