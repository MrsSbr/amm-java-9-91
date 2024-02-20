public class GardenDemo {
    public static void main(String[] args) {
        Flower rose = new Flower("Rose", 1, "Red");
        Vegetable carrot = new Vegetable("Carrot", 1, "Root");

        System.out.println(rose.toString());
        System.out.println(carrot.toString());

        rose.grow();
        carrot.grow();

        rose.giveWater();
        carrot.giveWater();

        rose.harvest();
        carrot.harvest();

        System.out.println("Are the plants equal? " + rose.equals(carrot));
    }
}
