package statistics;

import java.io.PrintStream;
import java.lang.reflect.Method;

public class MethodStat {   // статистика по одному методу
    private final long totalTime;

    private final Method method;

    public MethodStat(long totalTime, Method method) {
        this.totalTime = totalTime;
        this.method = method;
    }

    public void print(PrintStream out) {
        out.printf("%s: %s\n", "Метод:", method.getName());
        out.printf("%s: %d %s", "Время выполнения", totalTime, "наносекунд.\n");
    }
}