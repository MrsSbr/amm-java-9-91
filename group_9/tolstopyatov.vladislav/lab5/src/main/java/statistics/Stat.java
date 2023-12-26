package statistics;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Stat { // статистика по одному интерфейсу
    private final List<MethodStat> stat;

    public Stat() {
        this.stat = new ArrayList<>();
    }

    public Stat(List<MethodStat> stat) {
        this.stat = stat;
    }

    public List<MethodStat> getStat() {
        return stat;
    }

    public void print(PrintStream out) {
        for (MethodStat methodStat : stat) {
            methodStat.print(out);
        }
    }
}
