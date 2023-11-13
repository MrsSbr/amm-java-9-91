package org.example;

import java.util.Set;

public class Student {
    private final Set<ShowName> showsName; //Список спектаклей, на которые студент куптл билеты

    public Student(Set<ShowName> showsName) {
        this.showsName = showsName;
    }

    public Set<ShowName> getShowsName() {
        return showsName;
    }
}