package org.sql.queries.cat;

public enum Gender {
    MALE("Мужской"),
    FEMALE("Женский");
    private final String gender;
    Gender(String name) {
        this.gender = name;
    }
    public String getGender() {
        return gender;
    }

}
