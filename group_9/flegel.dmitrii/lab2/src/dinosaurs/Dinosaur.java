package dinosaurs;

import java.util.Objects;

public abstract class Dinosaur {

    private final String name;
    private final int age;

    public Dinosaur(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract void roar();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dinosaur other)) return false;
        return age == other.age && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Динозавр. Имя: " + name + ", Возраст: " + age;
    }
}
