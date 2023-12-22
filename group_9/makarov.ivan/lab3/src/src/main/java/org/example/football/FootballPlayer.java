package org.example.football;


public class FootballPlayer {
    private int number;
    private int votes;

    public FootballPlayer(int number) {
        this.number = number;
        this.votes = 0;
    }

    public int getNumber() {
        return number;
    }

    public int getVotes() {
        return votes;
    }

    public void addVote() {
        votes++;
    }
}
