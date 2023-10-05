public class MelanohromisyFish extends AquariumFish{
    public MelanohromisyFish(String name, String age, String color) {
        super(name, age, color);
    }

    @Override
    public String getFishType() {
        return "MelanohromisyFish";
    }

    @Override
    public String getFoodType() {
        return "Small molluscs, worms, invertebrates";
    }

    @Override
    public void specialBehavior() {
        System.out.println(getFishType()+" has glowing stripes on the sides");
    }
}