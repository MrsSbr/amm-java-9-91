package org.example.cat;

import java.util.Objects;

public class Cat {
    private final String name;
    private int age;
    private final Gender gender;
    private final Breed breed;
    private boolean defertilized;

    public Cat()
    {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.breed = null;
        this.defertilized = false;
    }

    public Cat(String name, int age, Gender gender, Breed breed, boolean defertilized)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.defertilized = defertilized;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Breed getBreed() {
        return breed;
    }

    public boolean isDefertilized() {
        return defertilized;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDefertilized(boolean defertilized) {
        this.defertilized = defertilized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && defertilized == cat.defertilized
                && Objects.equals(name, cat.name) && gender == cat.gender
                && Objects.equals(breed, cat.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender, breed, defertilized);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", breed='" + breed + '\'' +
                ", defertilized=" + defertilized +
                '}';
    }
}
