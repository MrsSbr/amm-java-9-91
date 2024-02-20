package org.example;

public class Cat {
    private String name;
    private String breed;
    private String gender;

    public Cat(String name, String breed, String gender) {
        this.name = name;
        this.breed = breed;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getGender() {
        return gender;
    }
}
