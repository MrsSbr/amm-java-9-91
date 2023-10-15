package CatBreed;

import java.util.Objects;

public abstract class WildCatBreed extends CatBreed {
    private int aggroLvl;

    public WildCatBreed(String color, int age, int aggroLvl) {
        super(color, age);
        this.aggroLvl = aggroLvl;
    }

    public abstract void hunt();

    public int getAggroLvl() {
        return aggroLvl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WildCatBreed that = (WildCatBreed) o;
        return aggroLvl == that.aggroLvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), aggroLvl);
    }

    @Override
    public String toString() {
        return "WildCatBreed{" +
                "aggroLvl=" + aggroLvl +
                '}' + super.toString();
    }
}
