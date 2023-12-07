import SacrificesOfThePriests.AccountingForSacrifice;
import SacrificesOfThePriests.TlalocStatistics;
import SacrificesOfThePriests.VictimType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
import java.util.stream.Stream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        NON_ANIMAL_SACRIFICES = List.of(new AccountingForSacrifice(VictimType.PERSON, 5, LocalDate.of(2018, 9, 11)),
                new AccountingForSacrifice(VictimType.PERSON, 6, LocalDate.of(2017, 10, 14)),
                new AccountingForSacrifice(VictimType.MATERIAL_OBJECT, 3, LocalDate.of(2004, 7, 3)),
                new AccountingForSacrifice(VictimType.MATERIAL_OBJECT, 5, LocalDate.of(2018, 11, 11)));

        ACCOUNTING_FOR_SACRIFICES_WITH_RAIN_THE_NEXT_DAY = List.of(new AccountingForSacrifice(VictimType.PERSON, 1, LocalDate.of(2003, 3, 4)),
                new AccountingForSacrifice(VictimType.MATERIAL_OBJECT, 1, LocalDate.of(2003, 2, 15)));

        LIST_WHERE_HUMAN_SACRIFICES_IS_MORE_EFFECTIVE_THAN_ANIMAL = List.of(new AccountingForSacrifice(VictimType.PERSON, 5, LocalDate.of(2002, 8, 14)),
                new AccountingForSacrifice(VictimType.ANIMAL, 10, LocalDate.of(2003, 2, 25)),
                new AccountingForSacrifice(VictimType.ANIMAL, 10, LocalDate.of(1998, 4, 27)),
                new AccountingForSacrifice(VictimType.PERSON, 5, LocalDate.of(1993, 6, 17)));

        LIST_WHERE_ANIMAL_SACRIFICES_IS_MORE_EFFECTIVE_THAN_HUMAN = List.of(new AccountingForSacrifice(VictimType.PERSON, 7, LocalDate.of(2002, 8, 14)),
                new AccountingForSacrifice(VictimType.ANIMAL, 5, LocalDate.of(2003, 2, 25)));
    }


    static Stream<Arguments> getCollections() {
        return Stream.of(
                Arguments.of(COLLECTIONS.get(0)),
                Arguments.of(COLLECTIONS.get(1)),
                Arguments.of(COLLECTIONS.get(2)),
                Arguments.of(COLLECTIONS.get(3)),
                Arguments.of(COLLECTIONS.get(4))
        );
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void getCountOfAccountingForSacrificesWithRainTheNextDay(Supplier<Collection<AccountingForSacrifice>> supplier) {
        TlalocStatistics statistic = new TlalocStatistics(supplier, ACCOUNTING_FOR_SACRIFICES_WITH_RAIN_THE_NEXT_DAY);
        int result = statistic.theNumberOfSacrificesAfterWhichRainFellTheNextDay();
        assertEquals(ACCOUNTING_FOR_SACRIFICES_WITH_RAIN_THE_NEXT_DAY.size(), result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void getCountOfAccountingForSacrificesWithRainTheNextDayInEmptyCollection(Supplier<Collection<AccountingForSacrifice>> supplier) {
        TlalocStatistics statistic = new TlalocStatistics(supplier, EMPTY_ACCOUNTING_FOR_SACRIFICES);
        int result = statistic.theNumberOfSacrificesAfterWhichRainFellTheNextDay();
        assertEquals(EMPTY_ACCOUNTING_FOR_SACRIFICES.size(), result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void checkThatHumanSacrificesIsMoreEffectiveThanAnimal(Supplier<Collection<AccountingForSacrifice>> supplier) {
        TlalocStatistics statistic = new TlalocStatistics(supplier, LIST_WHERE_HUMAN_SACRIFICES_IS_MORE_EFFECTIVE_THAN_ANIMAL);
        boolean result = statistic.isTheHumanSacrificesIsMoreEffectiveThanAnimal();
        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void checkThatAnimalSacrificesIsMoreEffectiveThanHuman(Supplier<Collection<AccountingForSacrifice>> supplier) {
        TlalocStatistics statistic = new TlalocStatistics(supplier, LIST_WHERE_ANIMAL_SACRIFICES_IS_MORE_EFFECTIVE_THAN_HUMAN);
        boolean result = statistic.isTheHumanSacrificesIsMoreEffectiveThanAnimal();
        assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void checkThatAnimalSacrificesIsMoreEffectiveThanHumanInEmptyCollection(Supplier<Collection<AccountingForSacrifice>> supplier) {
        TlalocStatistics statistic = new TlalocStatistics(supplier, EMPTY_ACCOUNTING_FOR_SACRIFICES);
        boolean result = statistic.isTheHumanSacrificesIsMoreEffectiveThanAnimal();
        assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void findLastMonthWithoutAnimalSacrifice(Supplier<Collection<AccountingForSacrifice>> supplier) {
        TlalocStatistics statistic = new TlalocStatistics(supplier, NON_ANIMAL_SACRIFICES);
        Month result = statistic.theLastMonthInWhichThereWereNoAnimalSacrifices();
        assertEquals(lastMonthWithoutAnimalSacrifice, result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void findLastMonthWithoutAnimalSacrificeInEmptyCollection(Supplier<Collection<AccountingForSacrifice>> supplier) {
        TlalocStatistics statistic = new TlalocStatistics(supplier, EMPTY_ACCOUNTING_FOR_SACRIFICES);
        assertThrows(NoSuchElementException.class, statistic::theLastMonthInWhichThereWereNoAnimalSacrifices);
    }

}
