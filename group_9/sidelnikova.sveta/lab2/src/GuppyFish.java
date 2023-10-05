public class GuppyFish extends AquariumFish {

    public GuppyFish(String name, String age, String color) {
        super(name, age, color);
    }

    @Override
    public String getFishType(){
        return "GuppyFish";
    }

    @Override
    public String getFoodType() {
        return "Flake feed and granules, small animals and insects, fresh vegetables";
    }

    @Override
    public void specialBehavior() {
        System.out.println(getFishType() + " breeds very quickly");
    }

}