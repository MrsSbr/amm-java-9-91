import Farm.Animal;
import Farm.Chicken;
import Farm.Cow;

public class FarmAnimals {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Cow("Bessie", "Holstein", true),
                new Chicken("Clucky", "Rhode Island Red", true),
        };


        for (Animal animal : animals) {
            if (animal instanceof Cow cow) {
                if (cow.isMilkProducing())
                    System.out.println("Корова для молока");
                else
                    System.out.println("Корова для мяса");
            } else if (animal instanceof Chicken chicken)
                if (chicken.isEggProducing())
                    System.out.println("Курица для яиц");
                else
                    System.out.println("Курица для мяса");
            System.out.println(animal);
            animal.makeSound();
            System.out.println();
        }
    }
}