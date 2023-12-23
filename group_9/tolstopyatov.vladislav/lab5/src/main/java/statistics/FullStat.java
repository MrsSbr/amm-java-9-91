package statistics;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FullStat { // вся статистика (в случае нескольких интерфейсов с аннотацией)
    private final HashMap<Object, ArrayList<MethodStat>> statistics;

    public FullStat() {
        this.statistics = new HashMap<>();
    }

    public HashMap<Object, ArrayList<MethodStat>> getStatistics() {
        return statistics;
    }

    public void print(PrintStream out) {
        for (Map.Entry<Object, ArrayList<MethodStat>> entry : statistics.entrySet()) {
            ArrayList<MethodStat> stat = entry.getValue();
            for (MethodStat st : stat) {
                st.print(out);
            }
        }
    }
}
