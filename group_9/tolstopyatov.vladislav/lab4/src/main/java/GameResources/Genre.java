package GameResources;

import java.util.Arrays;
import java.util.Optional;

public enum Genre {
    STRATEGY("Стратегия"),
    HORROR("Хоррор"),
    SLASHER("Слэшер"),
    GLOBAL_STRATEGY("Глобальная стратегия"),
    RPG("Ролевая игра"),
    SHOOTER("ШУТЕР");

    private final String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Optional<Genre> find(String genreName) {
        return Arrays.stream(values())
                .filter(genre -> genre.value.equals(genreName))
                .findFirst();
    }
}

