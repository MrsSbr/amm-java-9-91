package dinosaurs;

import java.util.Objects;

public class Ankylosaurus extends Dinosaur implements HerbivorousDinosaur {

    private final int armorThickness;

    public Ankylosaurus(String name, int age, int armorThickness) {
        super(name, age);
        this.armorThickness = armorThickness;
    }

    public int getArmorThickness() {
        return armorThickness;
    }

    @Override
    public void roar() {
        System.out.println("Анкилозавр " + getName() + " рычит.");
    }

    @Override
    public void graze() {
        System.out.println("Анкилозавр " + getName() + " пасется. " +
                "Он в безопасности благодаря своей броне толщиной " + getArmorThickness() + " мм.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ankylosaurus)) return false;
        Ankylosaurus other = (Ankylosaurus) o;
        return super.equals(o) && armorThickness == other.armorThickness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), armorThickness);
    }

    @Override
    public String toString() {
        return super.toString() + " Вид: Анкилозавр. Толщина брони: " + getArmorThickness() + " мм.";
    }

}
