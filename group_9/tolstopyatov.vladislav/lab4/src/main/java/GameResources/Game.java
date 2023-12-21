package GameResources;

import java.time.LocalDate;
import java.util.Objects;

public class Game {
    private final String title; // название игры
    private final Genre genre;  // жанр игры
    private final LocalDate dateOfCompletion; // дата завершения прохождения
    private final int gameTimeInHours;        // игровое время на прохождение в часах(классический учет)
    private final Estimation estimation;      // оценка игры от 1 до 5

    public Game(String title, Genre genre, LocalDate dateOfCompletion, int gameTimeInHours, Estimation estimation) {
        this.title = title;
        this.genre = genre;
        this.dateOfCompletion = dateOfCompletion;
        this.gameTimeInHours = gameTimeInHours;
        this.estimation = estimation;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public LocalDate getDateOfCompletion() {
        return dateOfCompletion;
    }

    public int getGameTimeInHours() {
        return gameTimeInHours;
    }

    public Estimation getEstimation() {
        return estimation;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Game game = (Game) object;
        return gameTimeInHours == game.gameTimeInHours &&
                Objects.equals(title, game.title) &&
                genre == game.genre &&
                Objects.equals(dateOfCompletion, game.dateOfCompletion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, genre, dateOfCompletion) +
                322 * Objects.hashCode(gameTimeInHours);
    }

    @Override
    public String toString() {
        return "Game{" +
                "Название='" + title + '\'' +
                ", Жанр = " + genre +
                ", Дата завершения прохождения = " + dateOfCompletion +
                ", Время прохождения в часах = " + gameTimeInHours +
                ", Оценка = " + estimation +
                '}';
    }
}
