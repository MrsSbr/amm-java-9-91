package catBreed;

import java.util.Objects;

public abstract class CatBreed extends Animal {
    private final String color;
    private int age;

    public CatBreed(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatBreed catBreed = (CatBreed) o;
        return age == catBreed.age && Objects.equals(color, catBreed.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, age);
    }

    @Override
    public String toString() {
        return "CatBreed{" +
                "color='" + color + '\'' +
                ", age=" + age +
                '}';
    }
}
