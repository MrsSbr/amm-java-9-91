package ru.denismandrusenko;

import java.util.Objects;
import java.time.LocalDate;

public class BoardGame {
    private final String title;
    private final Genre genre;
    private final double price;
    private final LocalDate date;

    public BoardGame(String title, Genre genre, double price, LocalDate date) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardGame game = (BoardGame) o;
        return Objects.equals(title, game.title) &&
                Objects.equals(genre, game.genre) &&
                Objects.equals(price, game.price) &&
                Objects.equals(date, game.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, price, date);
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price='" + price + '\'' +
                ", date=" + date +
                '}';
    }
}