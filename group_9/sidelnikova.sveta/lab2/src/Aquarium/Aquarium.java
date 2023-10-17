package Aquarium;

import java.util.List;
import java.util.ArrayList;

import Fishes.AquariumFish;

public class Aquarium {
    private final List<AquariumFish> fishes;

    private float waterTemperature;

    private float pH;

    private float oxygenConcentration;

    public Aquarium(float waterTemperature, float oxygenConcentration, float pH) {
        this.waterTemperature = waterTemperature;
        this.oxygenConcentration = oxygenConcentration;
        this.pH = pH;
        fishes = new ArrayList<>();
    }

    public void plantFish(AquariumFish fish) {
        fishes.add(fish);
    }

    public void feedFish(String str) {
        for (var fish : fishes) {
            if (fish.getFoodType().contains(str)) {
                fish.eat();
            }
        }
    }

    public AquariumFish findFishByType(String type) {
        for (var fish : fishes) {
            if (type.equals(fish.getFishType()))
                return fish;
        }
        return null;
    }
}
