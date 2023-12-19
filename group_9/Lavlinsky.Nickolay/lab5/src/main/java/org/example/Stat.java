package org.example;

public class Stat {
    private long totalTime = 0;
    private int callCount = 0;

    public void record(long time) {
        totalTime += time;
        callCount++;
    }

    public void print(java.io.PrintStream out) {
        out.println("Total time: " + totalTime + " ms");
        out.println("Call count: " + callCount);
    }
}

