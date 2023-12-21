package entity;

import java.util.Arrays;
import java.util.Optional;
import lombok.Getter;

@Getter
public enum Country {
    RUSSIA("Россия"),
    USA("Сша"),
    BELARUS("Беларусь"),
    UKRAINE("Украина");

    private final String description;

    Country(final String name) {
        this.description = name;
    }

    public static Optional<Country> find(String countryName) {
        return Arrays.stream(values())
            .filter(country -> country.description.equals(countryName))
            .findFirst();
    }
}
