package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class ElectionTest {

    @Test
    public void testSimulateVotingResults() {
        List<Integer> votes = VotingSimulator.simulateVotingResults(10);
        Assertions.assertEquals(10, votes.size()) ;
    }

    @Test
    public void testCountVotes() {
        List<Integer> votes = Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 3, 1);
        List<Integer> candidateVotes = VoteCounter.countVotes(votes);
        Assertions.assertEquals(4, candidateVotes.get(0));
        Assertions.assertEquals(3, candidateVotes.get(1));
        Assertions.assertEquals(3, candidateVotes.get(2));
    }

    @Test
    public void testSelectRepresentative() {
        List<Integer> candidateVotes = Arrays.asList(4, 3, 5, 2, 1, 0, 7, 6, 9, 8, 11, 10);
        int maxVotes = RepresentativeSelector.selectRepresentative(candidateVotes);
        Assertions.assertEquals(11, maxVotes);
    }

    @Test
    public void testTestCollectionPerformance() {
        List<Integer> votes = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assertions.assertDoesNotThrow(() -> PerformanceTester.testCollectionPerformance(votes));
    }
}