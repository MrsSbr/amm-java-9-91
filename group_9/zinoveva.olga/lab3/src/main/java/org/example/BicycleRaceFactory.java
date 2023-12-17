package org.example;

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
    private static final Calendar FIRST = new GregorianCalendar(1980, Calendar.JANUARY, 1);
    private static final Calendar SECOND = GregorianCalendar.getInstance();

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
        Calendar dateRace = between(FIRST, SECOND, random);

        return new BicycleRace(finalList, numbersParticipant, dateRace);
    }

    public static Calendar between(Calendar first, Calendar second, Random random) {
        int newYear = first.get(Calendar.YEAR) + random.nextInt(0, second.get(Calendar.YEAR));
        int newMonth = first.get(Calendar.MONTH) + random.nextInt(0, 11);
        int newDay = first.get(Calendar.DAY_OF_MONTH) + random.nextInt(0, 11);
        Calendar res = new GregorianCalendar(newYear, newMonth, newDay);
        if (res.compareTo(GregorianCalendar.getInstance()) > 0) {
            res = GregorianCalendar.getInstance();
        }
        return res;
    }
}
