package main.java.org.example;
import java.util.ArrayList;
import java.util.List;

public class VoteCounter {

    public static List<Integer> countVotes(List<Integer> votes) {
        List<Integer> candidateVotes = new ArrayList<>(12);
        for (int i = 0; i < 12; i++) {
            candidateVotes.add(0);
        }
        for (Integer vote : votes) {
            candidateVotes.set(vote - 1, candidateVotes.get(vote - 1) + 1);
        }
        return candidateVotes;
    }
}
