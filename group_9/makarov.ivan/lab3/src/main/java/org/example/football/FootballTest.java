package org.example.football;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class FootballTest {


    @Test
    public void testMultipleFanVotes() {
        FootballTeam footballTeam = new FootballTeam(5);
        footballTeam.collectFanVotes(1);
        footballTeam.collectFanVotes(2);
        footballTeam.collectFanVotes(3);

        assertEquals(Arrays.asList(1, 2, 3,4, 5), footballTeam.findVotedPlayers());
    }

    @Test
    public void testAllPlayersPopular() {
        FootballTeam footballTeam = new FootballTeam(4);
        footballTeam.collectFanVotes(1);
        footballTeam.collectFanVotes(2);
        footballTeam.collectFanVotes(3);
        footballTeam.collectFanVotes(4);

        assertEquals(Arrays.asList(), footballTeam.findPlayersWithNoVotes());
        assertEquals(Arrays.asList(1, 2, 3, 4), footballTeam.findVotedPlayers());
    }

    @Test
    public void testNoVotesForAnyPlayer() {
        FootballTeam footballTeam = new FootballTeam(3);

        List<Integer> allPlayers = Arrays.asList(1, 2, 3);

        assertEquals(allPlayers, footballTeam.findPlayersWithNoVotes());
    }
}
