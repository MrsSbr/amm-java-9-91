package Farm;

import java.util.Objects;

public abstract class Animal implements FarmLivestock {
    private String name;
    private String breed;

    public Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }


    @Override
    public String toString() {
        return name + " " + breed;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Animal animal = (Animal) object;

        return Objects.equals(name, animal.name) && Objects.equals(breed, animal.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, breed);
    }

}