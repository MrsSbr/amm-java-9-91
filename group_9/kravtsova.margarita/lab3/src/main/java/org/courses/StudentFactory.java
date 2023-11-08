package org.courses;

import java.util.*;


public class StudentFactory {
    private static final List<String> MAN_NAMES;
    private static final List<String> WOMAN_NAMES;
    private static final List<String> SURNAMES;
    static {
        MAN_NAMES = List.of("Иван", "Петр", "Александр", "Владимир", "Глеб", "Борис", "Даниил", "Клим", "Антон");
        WOMAN_NAMES = List.of("Дарья", "Софья", "Ольга", "Маргарита", "Надежда", "Кристина", "Светлана", "Анна", "Ирина");
        SURNAMES = List.of("Петров", "Иванов", "Сидоров", "Алексеев", "Кравцов", "Медведев", "Захаров", "Назаров", "Михайлов");
    }
    public static Student generateStudent() {
        Random rand = new Random();
        Map<CoursesTaught, Boolean> feedback = new HashMap<>();
        Arrays.stream(CoursesTaught.values())
                .forEach(subject -> feedback.put(subject, rand.nextBoolean()));
        boolean isFemale = rand.nextBoolean();// 0 - мужчина, 1 - женщина
        return new StudentBuilder()
                .withName((!isFemale) ? MAN_NAMES.get(rand.nextInt(MAN_NAMES.size())) : WOMAN_NAMES.get(rand.nextInt(WOMAN_NAMES.size())))
                .withSurname(SURNAMES.get(rand.nextInt(SURNAMES.size())) + ((isFemale) ? "а" : ""))
                .withPatronymic(MAN_NAMES.get(rand.nextInt(MAN_NAMES.size())) + ((!isFemale) ?  "ович" : "овна"))
                .withFeedback(feedback)
                .withNumberRecordBook(rand.nextInt(89999999)+10000000)
                .build();
    }
}
