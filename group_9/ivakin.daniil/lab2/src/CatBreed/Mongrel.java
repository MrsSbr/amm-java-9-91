package CatBreed;

public class Mongrel extends DomesticCatBreed{
    public Mongrel(String color, int age, String name) {
        super(color, age, name);
    }

    @Override
    public void makeSound() {
        System.out.println("Mongrel cat meows while looking for you");
    }

    @Override
    public void tryPet() {
        System.out.println("Mongrel cat bites your fingers gently");
    }

    @Override
    public void eat() {
        System.out.println("Mongrel cat swallows everything you gave it");
    }

    @Override
    public String toString() {
        return "Mongrel{}" + super.toString();
    }
}
