package Tools;

import Exceptions.NotValidDateOfCompletionException;
import Exceptions.NotValidEstimationException;
import Exceptions.NotValidGameTimeInHoursException;
import Exceptions.NotValidGenreException;
import Exceptions.NotValidTitleException;
import GameResources.Estimation;
import GameResources.Genre;

import java.time.LocalDate;

public class CheckValidFields {
    public CheckValidFields() {
    }

    public void checkValidTitle(String title) {
        if (title.isEmpty()) {
            throw new NotValidTitleException("Пустое название!");
        }
    }

    public void checkValidGenre(String genre) {
        if (!Genre.find(genre).isPresent()) {
            throw new NotValidGenreException("Не найден заданный жанр!");
        }
    }

    public void checkValidDateOfCompletion(LocalDate date) {
        if (date.getYear() > LocalDate.now().getYear()) {
            throw new NotValidDateOfCompletionException("Некорректная дата!");
        }
    }

    public void checkGameTimeInHours(Integer gameTime) {
        if (gameTime < 0) {
            throw new NotValidGameTimeInHoursException("Некорректное время игры в часах!");
        }
    }

    public void checkValidEstimation(Integer estimation) {
        if (!Estimation.find(estimation).isPresent()) {
            throw new NotValidEstimationException("Некорректная оценка игры!");
        }
    }
}
