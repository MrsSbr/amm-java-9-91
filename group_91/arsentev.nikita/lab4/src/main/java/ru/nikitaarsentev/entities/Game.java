package ru.nikitaarsentev.entities;

import java.util.Objects;

public class Game {
    protected final static int POINT_WIN = 3;
    protected final static int POINT_DRAW = 1;
    protected final static int POINT_LOSE = 0;
    private static int countGames = 0;
    private final int idGame;
    private final String homeTeam;
    private final String guestTeam;
    private final int scoreHome;
    private final int scoreGuest;

    public Game(String line) {
        idGame = countGames++;
        String[] parts = line.split(";");
        if (parts.length != 3 || parts[0].isEmpty() || parts[1].isEmpty() || parts[2].isEmpty()) {
            throw new IllegalArgumentException("Invalid format: " + line);
        }
        String[] scores = parts[2].split(":");
        if (scores.length != 2) {
            throw new IllegalArgumentException("Invalid format: " + line);
        }
        homeTeam = parts[0];
        guestTeam = parts[1];
        scoreHome = Integer.parseInt(scores[0]);
        scoreGuest = Integer.parseInt(scores[1]);
    }

    public int getIdGame() {
        return idGame;
    }

    private static int getPointTeam(int difference) {
        if (difference > 0) {
            return POINT_WIN;
        } else if (difference == 0) {
            return POINT_DRAW;
        }
        return POINT_LOSE;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getGuestTeam() {
        return guestTeam;
    }

    public int getScoreHome() {
        return scoreHome;
    }

    public int getScoreGuest() {
        return scoreGuest;
    }

    public int getPointHomeTeam() {
        return getPointTeam(scoreHome - scoreGuest);
    }

    public int getPointGuestTeam() {
        return getPointTeam(scoreGuest - scoreHome);
    }

    public int get0() {
        return 0;
    }

    public int isHomeTeamWinInt() {
        int difference = scoreHome - scoreGuest;
        if (difference > 0) {
            return 1;
        }
        return 0;
    }

    public boolean isHomeTeamWinBool() {
        return scoreHome - scoreGuest > 0;
    }

    public int isGuestTeamWinInt() {
        int difference = scoreHome - scoreGuest;
        if (difference < 0) {
            return 1;
        }
        return 0;
    }

    public boolean isGuestTeamWinBool() {
        return scoreHome - scoreGuest < 0;
    }

    public boolean isCleanSheetHomeTeam() {
        return scoreGuest == 0;
    }

    public boolean isGameWithWinner() {
        return scoreHome - scoreGuest != 0;
    }

    public String getWinner() {
        int difference = scoreHome - scoreGuest;
        if (difference > 0) {
            return homeTeam;
        } else if (difference < 0) {
            return guestTeam;
        }
        return null;
    }

    public String getLoser() {
        int difference = scoreHome - scoreGuest;
        if (difference < 0) {
            return homeTeam;
        } else if (difference > 0) {
            return guestTeam;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Game{" +
                "homeTeam='" + homeTeam + '\'' +
                ", guestTeam='" + guestTeam + '\'' +
                ", scoreHome=" + scoreHome +
                ", scoreGuest=" + scoreGuest +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Game game)) {
            return false;
        }
        return getIdGame() == game.getIdGame();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdGame());
    }
}
