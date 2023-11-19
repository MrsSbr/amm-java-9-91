import SacrificesOfThePriests.AccountingForSacrifice;
import SacrificesOfThePriests.Sacrifice;
import SacrificesOfThePriests.TlalocStatistics;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TlalocStatisticsTest {

    private final static List<Supplier<Collection<AccountingForSacrifice>>> COLLECTIONS;
    private final static List<AccountingForSacrifice> EMPTY_ACCOUNTING_FOR_SACRIFICES;
    private final static List<AccountingForSacrifice> NON_ANIMAL_SACRIFICES;
    private static final List<AccountingForSacrifice> ACCOUNTING_FOR_SACRIFICES_WITH_RAIN_THE_NEXT_DAY;
    private static final List<AccountingForSacrifice> LIST_WHERE_HUMAN_SACRIFICES_IS_MORE_EFFECTIVE_THAN_ANIMAL;
    private static final List<AccountingForSacrifice> LIST_WHERE_ANIMAL_SACRIFICES_IS_MORE_EFFECTIVE_THAN_HUMAN;
    private static final Month lastMonthWithoutAnimalSacrifice = Month.NOVEMBER;

    static {

        COLLECTIONS = List.of(
                ArrayList::new,
                LinkedList::new,
                Vector::new,
                HashSet::new,
                LinkedHashSet::new);

        EMPTY_ACCOUNTING_FOR_SACRIFICES = Collections.emptyList();

        NON_ANIMAL_SACRIFICES = List.of(new AccountingForSacrifice(new Sacrifice("человек", "женщина"), 5, LocalDate.of(2018, 9, 11)),
                new AccountingForSacrifice(new Sacrifice("человек", "девушка"), 6, LocalDate.of(2017, 10, 14)),
                new AccountingForSacrifice(new Sacrifice("человек", "мужчина"), 3, LocalDate.of(2004, 7, 3)),
                new AccountingForSacrifice(new Sacrifice("человек", "женщина"), 5, LocalDate.of(2018, 11, 11)));

        ACCOUNTING_FOR_SACRIFICES_WITH_RAIN_THE_NEXT_DAY = List.of(new AccountingForSacrifice(new Sacrifice("человек", "мужчина"), 1, LocalDate.of(2003, 3, 4)),
                new AccountingForSacrifice(new Sacrifice("животное", "кот"), 1, LocalDate.of(2003, 2, 15)));

        LIST_WHERE_HUMAN_SACRIFICES_IS_MORE_EFFECTIVE_THAN_ANIMAL = List.of(new AccountingForSacrifice(new Sacrifice("человек", "мужчина"), 5, LocalDate.of(2002, 8, 14)),
                new AccountingForSacrifice(new Sacrifice("животное", "бык"), 10, LocalDate.of(2003, 2, 25)),
                new AccountingForSacrifice(new Sacrifice("животное", "свинья"), 10, LocalDate.of(1998, 4, 27)),
                new AccountingForSacrifice(new Sacrifice("человек", "женщина"), 5, LocalDate.of(1993, 6, 17)));

        LIST_WHERE_ANIMAL_SACRIFICES_IS_MORE_EFFECTIVE_THAN_HUMAN = List.of(new AccountingForSacrifice(new Sacrifice("человек", "мужчина"), 7, LocalDate.of(2002, 8, 14)),
                new AccountingForSacrifice(new Sacrifice("животное", "бык"), 5, LocalDate.of(2003, 2, 25)));

    }

    @Test
    @DisplayName("Find count of accounting for sacrifices with rain the next day")
    void getCountOfAccountingForSacrificesWithRainTheNextDay() {
        COLLECTIONS.stream().map(x -> new TlalocStatistics(x, ACCOUNTING_FOR_SACRIFICES_WITH_RAIN_THE_NEXT_DAY)).
                map(TlalocStatistics::theNumberOfSacrificesAfterWhichRainFellTheNextDay).
                forEach(x -> assertEquals(x, ACCOUNTING_FOR_SACRIFICES_WITH_RAIN_THE_NEXT_DAY.size()));
    }

    @Test
    @DisplayName("Find count of accounting for sacrifices with rain the next day in EMPTY List")
    void getCountOfAccountingForSacrificesWithRainTheNextDayInEmptyList() {
        COLLECTIONS.stream().map(x -> new TlalocStatistics(x, EMPTY_ACCOUNTING_FOR_SACRIFICES)).
                map(TlalocStatistics::theNumberOfSacrificesAfterWhichRainFellTheNextDay).
                forEach(x -> assertEquals(x, 0));
    }

    @Test
    @DisplayName("Check than human sacrifices is more effective than animal in LIST_WHERE_HUMAN_SACRIFICES_IS_MORE_EFFECTIVE_THAN_ANIMAL")
    void checkThatHumanSacrificesIsMoreEffectiveThanAnimal() {
        COLLECTIONS.stream().map(x -> new TlalocStatistics(x, LIST_WHERE_HUMAN_SACRIFICES_IS_MORE_EFFECTIVE_THAN_ANIMAL)).
                map(TlalocStatistics::IsTheHumanSacrificesIsMoreEffectiveThanAnimal).
                forEach(x -> assertEquals(x, Boolean.TRUE));
    }

    @Test
    @DisplayName("Check than animal sacrifices is more effective than human in LIST_WHERE_ANIMAL_SACRIFICES_IS_MORE_EFFECTIVE_THAN_HUMAN")
    void checkThatAnimalSacrificesIsMoreEffectiveThanHuman() {
        COLLECTIONS.stream().map(x -> new TlalocStatistics(x, LIST_WHERE_ANIMAL_SACRIFICES_IS_MORE_EFFECTIVE_THAN_HUMAN)).
                map(TlalocStatistics::IsTheHumanSacrificesIsMoreEffectiveThanAnimal).
                forEach(x -> assertEquals(x, Boolean.FALSE));
    }

    @Test
    @DisplayName("Check than human sacrifices is more effective than animal in EMPTY List")
    void checkThatHumanSacrificesIsMoreEffectiveThanAnimalInEmptyList() {
        COLLECTIONS.stream().map(x -> new TlalocStatistics(x, EMPTY_ACCOUNTING_FOR_SACRIFICES)).
                map(TlalocStatistics::IsTheHumanSacrificesIsMoreEffectiveThanAnimal).
                forEach(x -> assertEquals(x, Boolean.FALSE));
    }

    @Test
    @DisplayName("Find last month without animal sacrifice")
    void findLastMonthWithoutAnimalSacrifice() {
        COLLECTIONS.stream().map(x -> new TlalocStatistics(x, NON_ANIMAL_SACRIFICES)).
                map(TlalocStatistics::theLastMonthInWhichThereWereNoAnimalSacrifices).
                forEach(x -> assertEquals(x, lastMonthWithoutAnimalSacrifice));
    }
}
