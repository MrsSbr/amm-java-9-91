package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.Math.abs;

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
            LocalDate date = generateDate(random);
            for (int j = 0; j < GeneratePassages.countFlightOfDay; j++) {
                passages = generatePassages();
                res.add(new Flight(j, date, passages));
            }
        }
    }

    public static LocalDate generateDate(Random random) {
        int year, month, day;
        LocalDate now = LocalDate.now();
        year = abs(random.nextInt()) % (now.getYear() - 2011) + 2011;
        month = abs(random.nextInt()) % now.getMonthValue() + 1;
        day = abs(random.nextInt()) % now.getDayOfMonth() + 1;
        return LocalDate.of(year, month, day);
    }

    public static Flight generateFlight() {
        Random random = new Random();
        LocalDate date = generateDate(random);
        return new Flight(random.nextInt(), date, generatePassages());
    }

}
