package org.patients;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class RandomPatient {
    private static final List<String> MAN_NAMES;
    private static final List<String> WOMAN_NAMES;
    private static final List<String> SURNAMES;

    static {
        MAN_NAMES = List.of("Иван", "Александр", "Антон", "Константин",
                "Олег", "Артем", "Артур", "Виктор", "Владимир", "Владислав", "Кирилл");
        WOMAN_NAMES = List.of("Елена", "Алёна", "Людмила", "Анастасия", "Татьяна",
                "Анна", "Мария", "Вера", "Надежда", "Александра", "Диана");
        SURNAMES = List.of("Иванов", "Петров", "Алексеев", "Михайлов", "Дмитриев",
                "Демидов", "Туманов", "Александров", "Сафронов", "Скворцов");
    }

    public static Patient generatePatient() {
        Random random = new Random();
        boolean isFemale = random.nextBoolean();

        int year = 1900 + random.nextInt(123); // случайный год от 1900 до 2023
        int month = 1 + random.nextInt(12); // случайный месяц от 1 до 12
        int maxDay = new GregorianCalendar(year, month - 1, 1).getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = 1 + random.nextInt(maxDay); // случайный день от 1 до последнего дня месяца

        if (!isFemale) {
            return new Patient(SURNAMES.get(random.nextInt(SURNAMES.size())),
                    MAN_NAMES.get(random.nextInt(MAN_NAMES.size())),
                    MAN_NAMES.get(random.nextInt(MAN_NAMES.size())) + "ович",
                    FluorogramResult.randomResult(), LocalDate.of(year, month, day));
        } else {
            return new Patient(SURNAMES.get(random.nextInt(SURNAMES.size())) + "а",
                    WOMAN_NAMES.get(random.nextInt(WOMAN_NAMES.size())),
                    MAN_NAMES.get(random.nextInt(MAN_NAMES.size())) + "овна",
                    FluorogramResult.randomResult(), LocalDate.of(year, month, day));
        }
    }
}