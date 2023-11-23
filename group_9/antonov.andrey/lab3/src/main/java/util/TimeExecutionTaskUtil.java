package util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TimeExecutionTaskUtil {
    public static long get(Runnable runnable) {
        var start = System.nanoTime();
        runnable.run();
        var end = System.nanoTime();
        return end - start;
    }
}
