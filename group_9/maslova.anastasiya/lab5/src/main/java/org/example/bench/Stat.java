package org.example.bench;

import java.io.PrintStream;
import java.util.Map;

public record Stat(Map<String, Long> stats) {

    public void print(PrintStream out) {
        stats.forEach((method, time) -> out.println(method + " занял " + time + " миллисекунд"));
    }
}
