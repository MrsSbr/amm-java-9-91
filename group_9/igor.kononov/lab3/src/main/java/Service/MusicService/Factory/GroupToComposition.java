package Service.MusicService.Factory;

import lombok.Data;

@Data
public class GroupToComposition<L, R> {
    private L compositionName;
    private R groupName;

    public GroupToComposition() { }

    public GroupToComposition(L compositionName, R groupName) {
        this.compositionName = compositionName;
        this.groupName = groupName;
    }
}
