package org.example;
import java.util.ArrayList;
import java.util.List;

public class VotingSimulator {

    public static List<Integer> simulateVotingResults(int numStudents) {
        List<Integer> votes = new ArrayList<>();
        for (int i = 0; i < numStudents; i++) {
            votes.add((int) (Math.random() * 12) + 1);
        }
        return votes;
    }
}
