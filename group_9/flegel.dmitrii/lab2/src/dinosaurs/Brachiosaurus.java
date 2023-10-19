package dinosaurs;

import java.util.Objects;

public class Brachiosaurus extends Dinosaur implements HerbivorousDinosaur {

    private final int neckLength;

    public Brachiosaurus(String name, int age, int neckLength) {
        super(name, age);
        this.neckLength = neckLength;
    }

    public int getNeckLength() {
        return neckLength;
    }

    @Override
    public void roar() {
        System.out.println("Брахиозавр " + getName() + " рычит.");
    }

    @Override
    public void graze() {
        System.out.println("Брахиозавр " + getName() + " пасется. " +
                "Он добирается до верхушек деревьев благодаря шее длиной " + getNeckLength() + " м.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brachiosaurus other)) return false;
        return super.equals(o) && neckLength == other.neckLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), neckLength);
    }

    @Override
    public String toString() {
        return super.toString() + " Вид: Брахиозавр. Длина шеи: " + getNeckLength() + " м.";
    }

}
