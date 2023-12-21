package Tools;

import Exceptions.NotValidDateOfCompletionException;
import Exceptions.NotValidEstimationException;
import Exceptions.NotValidGameTimeInHoursException;
import Exceptions.NotValidGenreException;
import Exceptions.NotValidTitleException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckValidFieldsTest {
    private static final String NOT_VALID_TITLE = "";
    private static final String NOT_VALID_GENRE_VALUE = "error";
    private static final LocalDate NOT_VALID_DATE_OF_COMPLETION = LocalDate.of(2025, 1, 25);
    private static final Integer NOT_VALID_GAME_TIME_IN_HOURS = -1;
    private static final Integer NOT_VALID_ESTIMATION_VALUE = 6;

    private final CheckValidFields checker = new CheckValidFields();

    @Test
    void checkValidTitle() {
        assertThrows(NotValidTitleException.class, () -> {
            checker.checkValidTitle(NOT_VALID_TITLE);
        });
    }

    @Test
    void checkValidGenre() {
        assertThrows(NotValidGenreException.class, () -> {
            checker.checkValidGenre(NOT_VALID_GENRE_VALUE);
        });
    }

    @Test
    void checkValidTimeInHours() {
        assertThrows(NotValidDateOfCompletionException.class, () -> {
            checker.checkValidDateOfCompletion(NOT_VALID_DATE_OF_COMPLETION);
        });
    }

    @Test
    void checkValidDateOfCompletion() {
        assertThrows(NotValidGameTimeInHoursException.class, () -> {
            checker.checkGameTimeInHours(NOT_VALID_GAME_TIME_IN_HOURS);
        });
    }

    @Test
    void checkValidEstimation() {
        assertThrows(NotValidEstimationException.class, () -> {
            checker.checkValidEstimation(NOT_VALID_ESTIMATION_VALUE);
        });
    }
}
