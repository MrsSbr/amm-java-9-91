package localdatetime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class LocalDateTimeUtil {
    public static boolean isHourOfPrepByCond(LocalDateTime dateTime, int minHour, int maxHour) {
        return dateTime.getHour() >= minHour && dateTime.getHour() <= maxHour;
    }

    public static boolean isWorkday(LocalDateTime dateTime) {
        return dateTime.getDayOfWeek() != DayOfWeek.SUNDAY && dateTime.getDayOfWeek() != DayOfWeek.SATURDAY;
    }
}

