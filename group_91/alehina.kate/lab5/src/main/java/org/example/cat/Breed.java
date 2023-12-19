package org.example.cat;

public enum Breed {
    ABYSSINIAN ("Абиссинская"),
    ASIAN ("Азиатская"),
    BENGALI ("Бенгальская"),
    BOMBAY ("Бомбейская"),
    HAVANA ("Гавана"),
    YORK ("Йорк"),
    MUNCHKIN ("Манчкин"),
    PERSIAN ("Персидская"),
    RAGDOLL ("Рэгдолл"),
    THAI ("Тайская"),
    AEGEAN ("Эгейская");

    private final String breed;
    Breed (String name) {
        this.breed = name;
    }
    public String getBreed() {
        return breed;
    }
}
