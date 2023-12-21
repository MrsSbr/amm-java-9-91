import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import poultryFarm.BirdType;
import poultryFarm.PoultryFarmProduction;
import poultryFarm.PoultryFarmStatistics;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PoultryFarmProductionTest {

    private final static List<Supplier<Collection<PoultryFarmProduction>>> COLLECTIONS;
    private final static List<PoultryFarmProduction> POULTRY_FARM_PRODUCTIONS_LIST;
    private final static List<BirdType> BIRD_TYPES_BY_CONDITION_LIST;
    private final static List<BirdType> EMPTY_BIRD_TYPES_BY_CONDITION_LIST;
    private final static List<PoultryFarmProduction> EMPTY_POULTRY_FARM_PRODUCTIONS_LIST;
    private final static List<PoultryFarmProduction> POULTRY_FARM_PRODUCTIONS_WITHOUT_ANY_ACCOUNTING_BY_COND_LIST;
    private final static Optional<Month> THE_MOST_PRODUCTIVE_MONTH;
    private final static int TOTAL_NUMBER_OF_EGGS_PRODUCED;

    static {
        COLLECTIONS = List.of(
                ArrayList::new,
                LinkedList::new,
                Vector::new,
                HashSet::new,
                LinkedHashSet::new);

        EMPTY_POULTRY_FARM_PRODUCTIONS_LIST = Collections.emptyList();
        EMPTY_BIRD_TYPES_BY_CONDITION_LIST = Collections.emptyList();

        POULTRY_FARM_PRODUCTIONS_LIST = List.of(
                new PoultryFarmProduction(BirdType.CHICKEN, 10, LocalDate.of(2023, 11, 30)),
                new PoultryFarmProduction(BirdType.CHICKEN, 8, LocalDate.of(2023, 12, 1)),
                new PoultryFarmProduction(BirdType.CHICKEN, 7, LocalDate.of(2023, 11, 30)),
                new PoultryFarmProduction(BirdType.DUCK, 10, LocalDate.of(2023, 11, 30)),
                new PoultryFarmProduction(BirdType.CHICKEN, 4, LocalDate.of(2023, 10, 1)),
                new PoultryFarmProduction(BirdType.CHICKEN, 4, LocalDate.of(2023, 9, 2)),
                new PoultryFarmProduction(BirdType.DUCK, 6, LocalDate.of(2023, 8, 3)),
                new PoultryFarmProduction(BirdType.TURKEY, 4, LocalDate.of(2023, 7, 4)),
                new PoultryFarmProduction(BirdType.TURKEY, 5, LocalDate.of(2023, 6, 5)),
                new PoultryFarmProduction(BirdType.CHICKEN, 4, LocalDate.of(2023, 5, 6)),
                new PoultryFarmProduction(BirdType.DUCK, 5, LocalDate.of(2023, 4, 7)),
                new PoultryFarmProduction(BirdType.CHICKEN, 6, LocalDate.of(2023, 3, 8)),
                new PoultryFarmProduction(BirdType.DUCK, 5, LocalDate.of(2023, 2, 9)),
                new PoultryFarmProduction(BirdType.TURKEY, 5, LocalDate.of(2023, 1, 15)));

        TOTAL_NUMBER_OF_EGGS_PRODUCED = 83;

        THE_MOST_PRODUCTIVE_MONTH = Optional.of(Month.NOVEMBER);

        BIRD_TYPES_BY_CONDITION_LIST = List.of(BirdType.CHICKEN);

        POULTRY_FARM_PRODUCTIONS_WITHOUT_ANY_ACCOUNTING_BY_COND_LIST = List.of(
                new PoultryFarmProduction(BirdType.CHICKEN, 10, LocalDate.of(2022, 11, 23)),
                new PoultryFarmProduction(BirdType.CHICKEN, 5, LocalDate.of(2022, 12, 1)),
                new PoultryFarmProduction(BirdType.CHICKEN, 7, LocalDate.of(2022, 11, 15)),
                new PoultryFarmProduction(BirdType.DUCK, 1, LocalDate.of(2022, 12, 2)));
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
    void getListOfBirdsTypesByCondition(Supplier<Collection<PoultryFarmProduction>> supplier) {
        PoultryFarmStatistics statistics = new PoultryFarmStatistics(supplier, POULTRY_FARM_PRODUCTIONS_LIST);
        var result = statistics.getBirdTypesByCond();
        assertEquals(BIRD_TYPES_BY_CONDITION_LIST, result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void getListOfBirdsTypesByConditionInEmptyCollection(Supplier<Collection<PoultryFarmProduction>> supplier) {
        PoultryFarmStatistics statistics = new PoultryFarmStatistics(supplier, EMPTY_POULTRY_FARM_PRODUCTIONS_LIST);
        var result = statistics.getBirdTypesByCond();
        assertEquals(EMPTY_BIRD_TYPES_BY_CONDITION_LIST, result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void getListOfBirdsTypesWithoutAnyAccountingByCond(Supplier<Collection<PoultryFarmProduction>> supplier) {
        PoultryFarmStatistics statistics = new PoultryFarmStatistics(supplier, POULTRY_FARM_PRODUCTIONS_WITHOUT_ANY_ACCOUNTING_BY_COND_LIST);
        var result = statistics.getBirdTypesByCond();
        assertEquals(EMPTY_BIRD_TYPES_BY_CONDITION_LIST, result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void getTheMostProductiveMonth(Supplier<Collection<PoultryFarmProduction>> supplier) {
        PoultryFarmStatistics statistics = new PoultryFarmStatistics(supplier, POULTRY_FARM_PRODUCTIONS_LIST);
        var result = statistics.getTheMostProductiveMonth();
        assertEquals(THE_MOST_PRODUCTIVE_MONTH, result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void getTheMostProductiveMonthInEmptyCollection(Supplier<Collection<PoultryFarmProduction>> supplier) {
        PoultryFarmStatistics statistics = new PoultryFarmStatistics(supplier, EMPTY_POULTRY_FARM_PRODUCTIONS_LIST);
        var result = statistics.getTheMostProductiveMonth();
        assertEquals(Optional.empty(), result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void getTotalNumberOfEggsProduced(Supplier<Collection<PoultryFarmProduction>> supplier) {
        PoultryFarmStatistics statistics = new PoultryFarmStatistics(supplier, POULTRY_FARM_PRODUCTIONS_LIST);
        var result = statistics.getTotalNumberOfEggsProduced();
        assertEquals(TOTAL_NUMBER_OF_EGGS_PRODUCED, result);
    }

    @ParameterizedTest
    @MethodSource("getCollections")
    void getTotalNumberOfEggsProducedInEmptyList(Supplier<Collection<PoultryFarmProduction>> supplier) {
        PoultryFarmStatistics statistics = new PoultryFarmStatistics(supplier, EMPTY_POULTRY_FARM_PRODUCTIONS_LIST);
        var result = statistics.getTotalNumberOfEggsProduced();
        assertEquals(0, result);
    }

}