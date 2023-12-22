package example;

import lombok.Data;

@Data
public class Cat {
    private String name;
    private int age;
    private Gender gender;
    private String breed;
    private boolean defertilized;

    public Cat() {
    }

    public Cat(String name, int age, Gender gender, String breed, boolean defertilized) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.breed = breed;
        this.defertilized = defertilized;
    }
}
