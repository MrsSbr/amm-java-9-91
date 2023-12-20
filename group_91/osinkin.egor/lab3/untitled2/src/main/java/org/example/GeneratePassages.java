package org.example;

import java.util.*;
import java.util.stream.IntStream;

public class GeneratePassages {
    public static final int countFlightOfDay = 10;

    public static List<Integer> generatePassages() {
        List<Integer> passages = new ArrayList<Integer>();
        Random random = new Random();
        Integer passage = random.nextInt() % 10 + 1;
        while (passage != 0) {
            passages.add(passage);
            passage = random.nextInt() % 10;
        }
        return passages;
    }

    public static List<Integer> generatePassagesWithStream() {
        Random random = new Random();
        List<Integer> res = new ArrayList<Integer>();
        var wrapper = new Object() {
            boolean flag = true;
        };
        IntStream numStream = random.ints(1, 10);
        numStream.forEach(elem -> {
            if (elem != 0 && wrapper.flag) {
                res.add(elem);
            } else {
                wrapper.flag = false;
            }
        });
        return res;
    }

    public static void generateFlights(Collection<Flight> res) {

        Random random = new Random();
        int idFlight;
        int day, month, year;
        int count = random.nextInt() % 4900 + 100;
        List<Integer> passages;
        for (int i = 0; i < count; i++) {
            Calendar date = generateDate(random);
            for (int j = 0; j < GeneratePassages.countFlightOfDay; j++) {
                passages = generatePassages();
                res.add(new Flight(j, date, passages));
            }
        }
    }

    public static Calendar generateDate(Random random) {
        int year, month, day;
        Calendar now = GregorianCalendar.getInstance();
        year = random.nextInt() % (now.get(Calendar.YEAR) - 2011) + 2011;
        month = random.nextInt() % now.get(Calendar.MONTH) + 1;
        day = random.nextInt(now.get(Calendar.DAY_OF_MONTH)) % now.get(Calendar.DAY_OF_MONTH) + 1;
        return new GregorianCalendar(year, month, day);
    }

    public static Flight generateFlight() {
        Random random = new Random();
        Calendar date = generateDate(random);
        return new Flight(random.nextInt(), date, generatePassages());
    }

}
