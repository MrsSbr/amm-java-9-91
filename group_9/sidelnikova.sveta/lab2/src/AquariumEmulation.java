import java.util.*;

public class AquariumEmulation {
    static Map<String, Set<String>> compatibility = new HashMap<>();
    final private Aquarium aquarium;
    public AquariumEmulation(Aquarium aquarium)
    {
        this.aquarium=aquarium;
    }
    void addToCompatibilityMap(AquariumFish fish) {
        if (fish instanceof GoldFish) {
            compatibility.put("GoldFish", new HashSet<>() {{
                add("GuppyFish");
                add("SwordtailFish");
            }});
        }
        else if (fish instanceof GuppyFish){
            compatibility.put("GuppyFish", new HashSet<>() {{
                add("GoldFish");
                add("SwordtailFish");
            }});
        }
        else if (fish instanceof SwordtailFish){
            compatibility.put("SwordtailFish", new HashSet<>() {{
                add("GoldFish");
                add("GuppyFish");
            }});
        }
        else if (fish instanceof MelanohromisyFish){
            compatibility.put("MelanohromisyFish", new HashSet<>());
        }
    }
    public boolean isFishCompatible(AquariumFish fish) {
        //значит, рыба уже живет в аквариуме
        if (compatibility.containsKey(fish.getFishType()))
        {
            return true;
        }
        else {
            for (var entry:compatibility.entrySet()
            ) {
                if (!entry.getValue().contains(fish.getFishType())){
                    return false;
                }
            }
            addToCompatibilityMap(fish);
        }
        return true;
    }
    public void tryToPlantFishInAquarium(AquariumFish fish) {
        if (isFishCompatible(fish)) {
            aquarium.plantFish(fish);
            System.out.println(fish.getName() + " has planted");
        }
        else System.out.println(fish.getName() + " hasn't planted");
    }

    public void specialInformationAboutFishesInAquarium() {
        for (var key:compatibility.keySet()
        ) {
            AquariumFish fish = aquarium.findFishByType(key);
            fish.specialBehavior();
        }
    }
}
