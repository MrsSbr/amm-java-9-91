package catBreed;

public class Sphinx extends DomesticCatBreed {
    public Sphinx(int age, String name) {
        super("Colorless", age, name);
    }

    @Override
    public void askEat() {
        System.out.println(getName() + "bumps your leg asking for food");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + "purrs deeply seeking your attention");
    }

    @Override
    public void tryPet() {
        System.out.println(getName() + "rubs against your hand");
    }

    @Override
    public void eat() {
        System.out.println(getName() +  " filters bowl, choosing only meat");
    }

    @Override
    public String toString() {
        return "Siamese{} " + super.toString();
    }
}
