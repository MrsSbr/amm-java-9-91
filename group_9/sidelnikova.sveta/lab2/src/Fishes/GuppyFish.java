package Fishes;

import java.util.HashSet;
import java.util.Set;

public class GuppyFish extends AquariumFish {
    private int numberOfFriesPerSpawn;

    public static Set<AquariumFish> incompatibility;

    static {
        incompatibility = new HashSet<>();
        incompatibility.add(new MelanohromisyFish());
    }

    public GuppyFish() {
        super();
    }

    public GuppyFish(String name, String age, String color) {
        super(name, age, color);
        numberOfFriesPerSpawn = random.nextInt(20) + 20;
    }

    @Override
    public String getFishType() {
        return "GuppyFish";
    }

    @Override
    public String getFoodType() {
        return "Flake feed and granules, small animals and insects";
    }

    @Override
    public void specialBehavior() {
        System.out.println(getFishType() + " breeds very quickly");
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
        GuppyFish other = (GuppyFish) object;
        return numberOfFriesPerSpawn == other.numberOfFriesPerSpawn;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + numberOfFriesPerSpawn;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Number of fries per spawn: " + numberOfFriesPerSpawn + "\n";
    }
}