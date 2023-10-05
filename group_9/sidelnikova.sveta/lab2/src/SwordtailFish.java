public class SwordtailFish extends AquariumFish {

    public SwordtailFish(String name, String age, String color) {
        super(name, age, color);
    }

    @Override
    public String getFishType() {
        return "SwordtailFish";
    }

    @Override
    public String getFoodType() {
        return "Flake feed and granules, small animals and insects, fresh vegetables";
    }

    @Override
    public void specialBehavior() {
        System.out.println(getFishType() + " is very peaceful");
    }
}
