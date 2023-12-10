package example;

import lombok.Data;

import java.util.Objects;

@Data
public class Cat {
    private String name;
    private int age;
    private Gender Gender;
    private String breed;
    private boolean defertilized;

    public Cat() {
    }

    public Cat(String name, int age, Gender gender, String breed, boolean defertilized) {
        this.name = name;
        this.age = age;
        this.Gender = gender;
        this.breed = breed;
        this.defertilized = defertilized;
    }
}
