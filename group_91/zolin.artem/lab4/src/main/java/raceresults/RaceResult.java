package raceresults;

import java.time.LocalDate;

public record RaceResult(LocalDate raceDate, String nameOfFirst, String nameOfSecond, String nameOfThird) {
}
