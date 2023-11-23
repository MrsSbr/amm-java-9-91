package Farm;

import java.util.Objects;

public class Cow extends Animal implements FarmLivestock {
    private boolean isMilkProducing;

    public Cow(String name, String breed, boolean isMilkProducing) {
        super(name, breed);
        this.isMilkProducing = isMilkProducing;
    }

    public boolean isMilkProducing() {
        return isMilkProducing;
    }

    public void setMilkProducing(boolean milkProducing) {
        isMilkProducing = milkProducing;
    }

    @Override
    public void farmfunction() {
        System.out.println("Я могу давать молоко или мясо:(");
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

        Cow cow = (Cow) object;

        return Objects.equals(isMilkProducing, cow.isMilkProducing);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isMilkProducing);
    }
}