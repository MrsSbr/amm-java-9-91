package Common;

import lombok.Data;

@Data
public class Pair<L, R> {
    private L first;
    private R second;

    public Pair() { }

    public Pair(L first, R second) {
        this.first = first;
        this.second = second;
    }
}
