package Aquarium;

import java.util.HashSet;
import java.util.Set;

import Fishes.AquariumFish;
import Fishes.GoldFish;
import Fishes.GuppyFish;
import Fishes.MelanohromisyFish;
import Fishes.SwordtailFish;

public class AquariumEmulation {
    private final Set<String> fishTypesInAquarium;

    private final Aquarium aquarium;

    public AquariumEmulation(Aquarium aquarium) {
        this.aquarium = aquarium;
        fishTypesInAquarium = new HashSet<>();
    }

    private void addNewTypeInFishTypesSet(String fishType) {
        fishTypesInAquarium.add(fishType);
    }

    private boolean isAquariumContainsFishOfAType(String fishType) {
        AquariumFish currentFish = aquarium.findFishByType(fishType);
        return currentFish != null;
    }

    public boolean isFishCompatible(AquariumFish fish) {
        String newFishType = fish.getFishType();
        if (fishTypesInAquarium.contains(newFishType)) {
            return true;
        } else if (fish instanceof GoldFish) {
            for (var incompatibleFish : GoldFish.incompatibility) {
                if (isAquariumContainsFishOfAType(incompatibleFish.getFishType())) {
                    return false;
                }
            }
            addNewTypeInFishTypesSet(newFishType);
            return true;
        } else if (fish instanceof GuppyFish) {
            for (var incompatibleFish : GuppyFish.incompatibility) {
                if (isAquariumContainsFishOfAType(incompatibleFish.getFishType())) {
                    return false;
                }
            }
            addNewTypeInFishTypesSet(newFishType);
            return true;
        } else if (fish instanceof MelanohromisyFish) {
            for (var incompatibleFish : MelanohromisyFish.incompatibility) {
                if (isAquariumContainsFishOfAType(incompatibleFish.getFishType())) {
                    return false;
                }
            }
            addNewTypeInFishTypesSet(newFishType);
            return true;
        } else if (fish instanceof SwordtailFish) {
            for (var incompatibleFish : SwordtailFish.incompatibility) {
                if (isAquariumContainsFishOfAType(incompatibleFish.getFishType())) {
                    return false;
                }
            }
            addNewTypeInFishTypesSet(newFishType);
            return true;
        }
        return false;
    }

    public void tryToPlantFishInAquarium(AquariumFish fish) {
        if (isFishCompatible(fish)) {
            aquarium.plantFish(fish);
            System.out.println(fish.getName() + " has planted");
        } else {
            System.out.println(fish.getName() + " hasn't planted");
        }
    }

    public void getSpecialInformationAboutTypesOfFishInAquarium() {
        for (var fish : fishTypesInAquarium) {
            AquariumFish aquariumFish = aquarium.findFishByType(fish);
            if (fish != null) {
                aquariumFish.specialBehavior();
            }
        }
    }
}
