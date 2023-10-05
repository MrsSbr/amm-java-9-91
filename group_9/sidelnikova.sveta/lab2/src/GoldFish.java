public class GoldFish extends AquariumFish{
    public GoldFish(String name, String age, String color) {
        super(name, age, color);
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
}
