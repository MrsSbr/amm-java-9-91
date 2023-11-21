package Court;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class LawsuitFactory {
    private static final List<String> NAMES;

    static {
        NAMES = List.of(
                "Незнайка",
                "Знайка",
                "Пилюлькин",
                "Винтик",
                "Шпунтик",
                "Сахарин Сахариныч Сиропчик",
                "Пулька",
                "Тюбик",
                "Гусля",
                "Торопыжка",
                "Ворчун",
                "Молчун",
                "Пончик",
                "Растеряйка",
                "Авоська",
                "Небоська"
        );
    }

    private static LocalDate getRandomDate() {
        Random rand = new Random();
        long minDay = LocalDate.of(1970, 1, 1).toEpochDay();
        long maxDay = LocalDate.of(2023, 1, 1).toEpochDay();
        //long randomDay = minDay + rand.nextLong(maxDay-minDay);
        long randomDay = minDay + rand.nextLong() % (maxDay - minDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    public Lawsuit getLawsuit() {
        Random rand = new Random();
        return new Lawsuit(NAMES.get(rand.nextInt(NAMES.size())),
                NAMES.get(rand.nextInt(NAMES.size())),
                getRandomDate(),
                rand.nextInt(100),
                rand.nextBoolean());
    }
}
