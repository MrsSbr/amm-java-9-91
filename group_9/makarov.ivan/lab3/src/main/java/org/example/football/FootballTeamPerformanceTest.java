package org.example.football;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FootballTeamPerformanceTest {
    public static void main(String[] args) {
        Collection<FootballPlayer> arrayListPlayers = createCollection(ArrayList::new, 22);
        Collection<FootballPlayer> linkedListPlayers = createCollection(LinkedList::new, 22);
        Collection<FootballPlayer> vectorPlayers = createCollection(Vector::new, 22);

        performance(arrayListPlayers);
        performance(linkedListPlayers);
        performance(vectorPlayers);
    }

    private static <T extends Collection<FootballPlayer>> T createCollection(Supplier<T> factory, int size) {
        return Stream.generate(() -> new FootballPlayer(0))
                .limit(size)
                .collect(factory, Collection::add, Collection::addAll);
    }

    private static void performance(Collection<FootballPlayer> players) {
        FootballTeam footballTeam = new FootballTeam(22);
        int numFans = 3000;

        long finalTime = 0;
        long startTime;
        long endTime;

        for (int i = 0; i < numFans; ++i) {
            startTime = System.nanoTime();

            footballTeam.collectFanVotes(1);
            footballTeam.findMostPopularPlayers();
            footballTeam.findPlayersWithNoVotes();
            footballTeam.findVotedPlayers();

            endTime = System.nanoTime();

            finalTime += endTime - startTime;
        }

        double nanosecondsToMilliseconds = 1e6;
        double timeToMilliseconds = finalTime / (numFans * nanosecondsToMilliseconds);

        System.out.println(players.getClass().getSimpleName() + ": " + timeToMilliseconds + " миллисекунд.");
    }
}

