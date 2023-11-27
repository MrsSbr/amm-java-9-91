package Service.MusicService.Factory;

import lombok.Data;

@Data
public class Pair<L, R> {
    private L compositionName;
    private R groupName;

    public Pair() { }

    public Pair(L compositionName, R groupName) {
        this.compositionName = compositionName;
        this.groupName = groupName;
    }
}
