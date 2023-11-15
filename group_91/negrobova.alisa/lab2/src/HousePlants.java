import Plants.*;

public class HousePlants {

    public static void main(String[] args) {
        PlantCollection collection = new PlantCollection();
        try {

            Flower rose = new Flower("Rose", 20, "Red");
            Cactus cactus = new Cactus("Cactus", 10, 50);

            collection.addPlant(rose);
            collection.addPlant(cactus);
        } catch (IllegalArgumentException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        System.out.println("Before watering:");
        collection.printPlants();

        collection.waterPlants();

        System.out.println("After watering:");
        collection.printPlants();
    }
}

