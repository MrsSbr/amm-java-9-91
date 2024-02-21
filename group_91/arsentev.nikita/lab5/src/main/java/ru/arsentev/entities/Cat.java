package ru.arsentev.entities;

import java.util.Objects;

public class Cat {
    private String name;
    private int age;
    private double weight;
    private Color color;
    private Gender gender;
    private boolean isPleased;

    public Cat() {
    }

    public Cat(String name, int age, double weight, Color color, Gender gender, boolean isPleased) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.gender = gender;
        this.isPleased = isPleased;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender male) {
        this.gender = male;
    }

    public boolean getIsPleased() {
        return isPleased;
    }

    public void setIsPleased(boolean pleased) {
        isPleased = pleased;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", color=" + color +
                ", gender=" + gender +
                ", isPleased=" + isPleased +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Cat cat)) {
            return false;
        }
        return getAge() == cat.getAge()
                && Double.compare(getWeight(), cat.getWeight()) == 0
                && isPleased == cat.isPleased
                && Objects.equals(getName(), cat.getName())
                && getColor() == cat.getColor() && getGender() == cat.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getWeight(), getColor(), getGender(), isPleased);
    }
}
