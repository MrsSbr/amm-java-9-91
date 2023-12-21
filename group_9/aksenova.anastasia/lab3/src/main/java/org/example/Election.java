package org.example;

import java.util.List;
import java.util.Scanner;

public class Election {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> votes = VotingSimulator.simulateVotingResults(300);

        int threshold = (int) (0.1 * votes.size());

        List<Integer> candidateVotes = VoteCounter.countVotes(votes);

        int maxVotes = RepresentativeSelector.selectRepresentative(candidateVotes);

        boolean success = maxVotes >= threshold;
        System.out.println("Удалось ли выбрать представителя: " + success);

        PerformanceTester.testCollectionPerformance(votes);
    }
}
