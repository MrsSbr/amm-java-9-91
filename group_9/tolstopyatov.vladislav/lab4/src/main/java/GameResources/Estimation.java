package GameResources;

import java.util.Arrays;
import java.util.Optional;

public enum Estimation {
    IMPOSSIBLE_TO_PLAY(1),
    BAD(2),
    NORMAL(3),
    GOOD(4),
    EXCELLENT(5);
    private final int value;

    private Estimation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Optional<Estimation> find(int estimationInt) {
        return Arrays.stream(values())
                .filter(estimation -> estimation.value == estimationInt)
                .findFirst();
    }

}
