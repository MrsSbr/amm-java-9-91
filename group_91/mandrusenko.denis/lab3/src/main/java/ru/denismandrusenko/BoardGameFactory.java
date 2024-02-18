package ru.denismandrusenko;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class BoardGameFactory {
    private static final List<String> titles;

    static {
        titles = List.of("Monopoly", "Scrabble", "Risk",
                "Chess", "Catan", "Ticket to Ride", "Clue", "Codenames",
                "Pandemic", "The Settlers of Catan", "Battleship",
                "Trivial Pursuit", "Connect Four", "Jenga", "Uno",
                "Dominion", "Taboo", "Carcassonne", "The Game of Life");
    }

    public static BoardGame generateBoardGame() {
        Random random = new Random();

        double price = 1000 + random.nextInt(3000);
        int year = 2018 + random.nextInt(6);
        int month = 1 + random.nextInt(12);
        int maxDay = new GregorianCalendar(year, month - 1, 1).getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = 1 + random.nextInt(maxDay);

        return new BoardGame(titles.get(random.nextInt(titles.size())),
                Genre.getRandom(), price, LocalDate.of(year, month, day));
    }
}