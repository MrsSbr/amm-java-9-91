import java.util.*;

public class Aquarium {
    ArrayList<AquariumFish> fishes;
    float waterTemperature;
    float pH;
    float oxygenConcentration;

    Aquarium(float waterTemperature, float oxygenConcentration, float pH) {
        fishes=new ArrayList<>();
        this.waterTemperature = waterTemperature;
        this.oxygenConcentration = oxygenConcentration;
        this.pH = pH;
    }
    public void plantFish(AquariumFish fish) {
        fishes.add(fish);
    }
    public void feedFish(String str) {
        for (var fish:fishes) {
            if (fish.getFoodType().contains(str))
            {
                fish.eat();
            }
        }
    }
    public AquariumFish findFishByType(String type)
    {
        for (var fish: fishes){
            if (type.equals(fish.getFishType()))
                return fish;
        }
        return null;
    }

}
