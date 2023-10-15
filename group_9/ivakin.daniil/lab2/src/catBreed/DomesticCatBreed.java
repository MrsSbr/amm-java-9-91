package catBreed;

import java.util.Objects;

public abstract class DomesticCatBreed extends CatBreed {
    private String name;

    public DomesticCatBreed(String color, int age, String name) {
        super(color, age);
        this.name = name;
    }

    public void askEat() {
        System.out.println(name + "screams loudly asking for food");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DomesticCatBreed that = (DomesticCatBreed) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "DomesticCatBreed{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
