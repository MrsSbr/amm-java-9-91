package org.example;
import java.util.List;

public class RepresentativeSelector {

    public static int selectRepresentative(List<Integer> candidateVotes) {
        return candidateVotes.stream().max(Integer::compare).orElse(0);
    }
}

