package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class VotingSimulator {

    public static List<Integer> simulateVotingResults(int numStudents) {
        return IntStream.range(0, numStudents)
                .mapToObj(i -> (int) (Math.random() * 12) + 1)
                .collect(Collectors.toList());
    }
}
