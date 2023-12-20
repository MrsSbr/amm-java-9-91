package org.example;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.IntStream;

public class BicycleRaceFactory {
    private static final int MAX_COUNT = 50;

    public static BicycleRace createBicycleRace() {
        Random random = new Random();

        List<Integer> numbersParticipant = new ArrayList<Integer>();
        IntStream tmpStream = random
                .ints(1, 100 + 1)
                .distinct()
                .limit(random.nextInt(MAX_COUNT) + 3);
        tmpStream.forEach(numbersParticipant::add);

        //Итоговые места
        List<Integer> uniqueFinalNumber = new ArrayList<Integer>();
        tmpStream = random
                .ints(1, numbersParticipant.size() + 1)
                .distinct()
                .limit(numbersParticipant.size());
        tmpStream.forEach(uniqueFinalNumber::add);

        Map<Integer, Integer> finalList = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbersParticipant.size(); i++) {
            finalList.put(uniqueFinalNumber.get(i), numbersParticipant.get(i)); //Ключ -> место, значение -> участник
        }
        LocalDate dateRace = betweenRandom();

        return new BicycleRace(finalList, numbersParticipant, dateRace);
    }

    public static LocalDate betweenRandom() {
        Random random = new Random();
        int year = 1990 + random.nextInt(33);
        int month = 1 + random.nextInt(12);
        int maxDayInMonth = new GregorianCalendar(year, month - 1, 1).getActualMaximum(Calendar.DAY_OF_MONTH);
        int day = 1 + random.nextInt(maxDayInMonth);
        return LocalDate.of(year, month, day);
    }
}
