package test.java.org.example;

import main.java.org.example.PerformanceTester;
import main.java.org.example.RepresentativeSelector;
import main.java.org.example.VoteCounter;
import main.java.org.example.VotingSimulator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

class ElectionTest {

    @Test
    void testSimulateVotingResults() {
        List<Integer> votes = VotingSimulator.simulateVotingResults(10);
        assertEquals(10, votes.size());
    }

    @Test
    void testCountVotes() {
        List<Integer> votes = Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 3, 1);
        List<Integer> candidateVotes = VoteCounter.countVotes(votes);
        assertEquals(4, candidateVotes.get(0));
        assertEquals(3, candidateVotes.get(1));
        assertEquals(3, candidateVotes.get(2));
    }

    @Test
    void testSelectRepresentative() {
        List<Integer> candidateVotes = Arrays.asList(4, 3, 5, 2, 1, 0, 7, 6, 9, 8, 11, 10);
        int maxVotes = RepresentativeSelector.selectRepresentative(candidateVotes);
        assertEquals(11, maxVotes);
    }

    @Test
    void testTestCollectionPerformance() {
        List<Integer> votes = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        assertDoesNotThrow(() -> PerformanceTester.testCollectionPerformance(votes));
    }
}