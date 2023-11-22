package Farm;

import java.util.Objects;

public class Chicken extends Animal implements FarmLivestock {
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
    public void farmfunction() {
        System.out.println("Я могу нести яйца или можете съесть меня:(");
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