package util;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.MONTHS;


//чтобы в stream api поукуратнее было + тестов можно налупить + можно добавлять проверки
@UtilityClass
public class LocalDateUtil {
    public static boolean dateIsCorrectMonth(LocalDate localDate, int month) {
        return MONTHS.between(localDate, LocalDate.now()) <= month;
    }
}
