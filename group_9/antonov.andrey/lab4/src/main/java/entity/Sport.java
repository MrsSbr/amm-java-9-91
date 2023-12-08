package entity;

import java.util.Arrays;
import java.util.Optional;
import lombok.Getter;

@Getter
public enum Sport {
    RUNNING("Бег"),
    SWIMMING("Плавание"),
    SKI("Лыжи");

    private final String description;

    Sport(final String name) {
        this.description = name;
    }

    public static Optional<Sport> find(String sportName) {
        return Arrays.stream(values())
            .filter(sport -> sport.description.equals(sportName))
            .findFirst();
    }
}
