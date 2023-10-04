import java.util.Objects;

public class Triceratops extends Dinosaur implements HerbivorousDinosaur {

    private final int numberOfHorns;

    public Triceratops(String name, int age, int numberOfHorns) {
        super(name, age);
        this.numberOfHorns = numberOfHorns;
    }

    public int getNumberOfHorns() {
        return numberOfHorns;
    }

    @Override
    public void roar() {
        System.out.println("Трицератопс " + getName() + " рычит.");
    }

    @Override
    public void graze() {
        System.out.println("Трицератопс " + getName() + " пасется. " +
                "Он в безопасности благодаря своим рогам в количестве " + getNumberOfHorns());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triceratops)) return false;
        Triceratops other = (Triceratops) o;
        return super.equals(o) && numberOfHorns == other.numberOfHorns;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfHorns);
    }

    @Override
    public String toString() {
        return super.toString() + " Вид: Трицератопс. Количество рогов: " + getNumberOfHorns();
    }
    
}
