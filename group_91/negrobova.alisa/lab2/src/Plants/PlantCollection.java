package Plants;

import java.util.ArrayList;
import java.util.List;

public class PlantCollection {
    private final List<Plant> plants;

    public PlantCollection() {
        plants = new ArrayList<>();
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void waterPlants() {
        for (Plant plant : plants) {
            if (plant instanceof Waterable) {
                ((Waterable) plant).water();
            }
        }
    }
    public void printPlants() {
        for (Plant plant : plants) {
            System.out.println(plant.toString());
        }
    }
}
