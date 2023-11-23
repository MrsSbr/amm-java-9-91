package util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomUtil {

    private static final int DEFAULT_BOUND = 1000;

    private static final Random RANDOM = new Random();

    public static int getNext(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int getNext() {
        return RANDOM.nextInt(DEFAULT_BOUND);
    }
}
