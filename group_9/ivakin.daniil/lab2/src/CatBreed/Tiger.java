package CatBreed;

public class Tiger extends WildCatBreed {

    public Tiger(String color, int age, int aggroLvl) {
        super(color, age, aggroLvl);
    }

    @Override
    public void hunt() {
        System.out.println("Tiger stalks his prey and slowly approaches it");
    }

    @Override
    public void makeSound() {
        if (getAggroLvl() > 10) {
            System.out.println("Tiger roars loudly");
        } else {
            System.out.println("Tiger yawns");
        }
    }

    @Override
    public void tryPet() {
        if (getAggroLvl() > 10) {
            System.out.println("Tiger bites your hand");
        } else {
            System.out.println("Tiger doesn't response");
        }
    }

    @Override
    public void eat() {
        System.out.println("Tiger bites off chunk of meat");
    }

    @Override
    public String toString() {
        return "Tiger{}" + super.toString();
    }
}
