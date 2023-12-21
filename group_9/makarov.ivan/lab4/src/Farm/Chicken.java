package Farm;

import java.util.Objects;

public class Chicken extends Animal implements FarmCreature {
    private boolean isEggProducing;

    public Chicken(String name, String breed, boolean isEggProducing) {
        super(name, breed);
        this.isEggProducing = isEggProducing;
    }

    public boolean isEggProducing() {
        return isEggProducing;
    }

    public void setEggProducing(boolean eggProducing) {
        isEggProducing = eggProducing;
    }

    @Override
    public void makeSound() {
        System.out.println("КО-КО-КО");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (!super.equals(object)) {
            return false;
        }

        Chicken chicken = (Chicken) object;

        return Objects.equals(isEggProducing, chicken.isEggProducing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isEggProducing);
    }
}