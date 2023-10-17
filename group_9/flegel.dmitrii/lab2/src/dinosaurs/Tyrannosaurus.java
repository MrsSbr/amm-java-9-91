package dinosaurs;

import java.util.Objects;

public class Tyrannosaurus extends Dinosaur {

    private int numberOfVictims;

    public Tyrannosaurus(String name, int age, int numberOfVictims) {
        super(name, age);
        this.numberOfVictims = numberOfVictims;
    }

    public int getNumberOfVictims() {
        return numberOfVictims;
    }

    @Override
    public void roar() {
        System.out.println("Тираннозавр " + getName() + " рычит.");
    }

    public boolean hunt(Dinosaur dinosaur) {
        System.out.println("Тираннозавр " + getName() + " охотится.");
        if (dinosaur instanceof HerbivorousDinosaur herbivorousDinosaur) {
           System.out.println("Он замечает жертву: " + dinosaur.toString());
           if(dinosaur instanceof Brachiosaurus brachiosaurus) {
               System.out.println(dinosaur.getName() + " не может защититься. " +
                       "Тиранозавр " + this.getName() + " его съедает.");
               ++numberOfVictims;
               return true;
           }
           else {
               System.out.println(dinosaur.getName() + " смог защититься от атаки.");
               return false;
           }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tyrannosaurus)) return false;
        Tyrannosaurus other = (Tyrannosaurus) o;
        return super.equals(o) && numberOfVictims == other.numberOfVictims;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfVictims);
    }

    @Override
    public String toString() {
        return super.toString() + " Вид: Тираннозавр. Количество жертв: " + getNumberOfVictims();
    }

}
