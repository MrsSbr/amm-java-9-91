package util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class TimeExecutionUtil {
    public static long getExecutionTime(Runnable runnable) {
        var start = System.nanoTime();
        runnable.run();
        var end = System.nanoTime();
        return end - start;
    }
}
