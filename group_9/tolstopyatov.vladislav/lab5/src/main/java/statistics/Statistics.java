package statistics;

import java.io.PrintStream;

public class Statistics {
    private final long totalTime;

    public Statistics(long totalTime) {
        this.totalTime = totalTime;
    }

    public void print(PrintStream out) {
        out.printf("%s: %d %s", "Время выполнения", totalTime, "наносекунд.");
    }
}
