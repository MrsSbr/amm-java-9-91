import Court.CourtLog;
import Court.Lawsuit;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.HashSet;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourtLogTest {
    private static final List<Supplier<Collection<Lawsuit>>> COLLECTIONS;
    private static final List<Lawsuit> EMPTY_LAWSUITS;
    public static final List<Lawsuit> LAWSUITS;
    public static final List<String> UNSUITED_PEOPLE;

    public static final int UNSUITED_PEOPLE_COUNT;
    public static final List<String> PEOPLE_WITH_SEVERAL_CLAUSES_IN_TEN_YEARS;
    public static final List<String> PEOPLE_WITH_SEVERAL_SUITS_IN_THREE_YEARS;

    static {
        COLLECTIONS = List.of(
                ArrayList::new,
                LinkedList::new,
                Vector::new,
                HashSet::new,
                LinkedHashSet::new
        );

        EMPTY_LAWSUITS = Collections.emptyList();

        LAWSUITS = List.of(
                new Lawsuit("Name1", "Name2",
                        LocalDate.of(2010, 1, 10), 13, true),
                new Lawsuit("Name1", "Name2",
                        LocalDate.of(2020, 3, 11), 22, true),
                new Lawsuit("Name2", "Name1",
                        LocalDate.of(2021, 4, 3), 5, false),
                new Lawsuit("Name3", "Name4",
                        LocalDate.of(2023, 3, 1), 1, false),
                new Lawsuit("Name5", "Name6",
                        LocalDate.of(2022, 1, 1), 11, false),
                new Lawsuit("Name5", "Name6",
                        LocalDate.of(2022, 4, 13), 11, false),
                new Lawsuit("Name5", "Name6",
                        LocalDate.of(2022, 8, 21), 11, true),
                new Lawsuit("Name7", "Name8",
                        LocalDate.of(2022, 11, 5), 5, true),
                new Lawsuit("Name7", "Name9",
                        LocalDate.of(2022, 12, 13), 6, false),
                new Lawsuit("Name10", "Name11",
                        LocalDate.of(2023, 5, 6), 15, false)
        );

        UNSUITED_PEOPLE = List.of(
                "Name1",
                "Name3",
                "Name4",
                "Name5",
                "Name7",
                "Name9",
                "Name10",
                "Name11"
        );

        UNSUITED_PEOPLE_COUNT = UNSUITED_PEOPLE.size();

        PEOPLE_WITH_SEVERAL_CLAUSES_IN_TEN_YEARS = List.of(
                "Name1",
                "Name2",
                "Name7"
        );

        PEOPLE_WITH_SEVERAL_SUITS_IN_THREE_YEARS = List.of(
                "Name7",
                "Name5"
        );
    }

    @Test
    void getUnsuitedPeopleCount() {
        COLLECTIONS.stream()
                .map(collection -> new CourtLog(collection, LAWSUITS))
                .map(CourtLog::getUnsuitedPeopleCount)

                .forEach(result -> assertEquals(UNSUITED_PEOPLE_COUNT, result));
    }

    @Test
    void getUnsuitedPeopleCountInEmptyCollection() {
        COLLECTIONS.stream()
                .map(collection -> new CourtLog(collection, EMPTY_LAWSUITS))
                .map(CourtLog::getUnsuitedPeopleCount)
                .forEach(result -> assertEquals(0, result));
    }

    @Test
    void getPeopleWithClausesInTenYears() {
        COLLECTIONS.stream()
                .map(collection -> new CourtLog(collection, LAWSUITS))
                .map(CourtLog::getPeopleWithSeveralClausesInTenYears)
                .map(ArrayList::new)
                .forEach(result -> assertTrue(PEOPLE_WITH_SEVERAL_CLAUSES_IN_TEN_YEARS.size() == result.size() &&
                        PEOPLE_WITH_SEVERAL_CLAUSES_IN_TEN_YEARS.containsAll(result) &&
                        result.containsAll(PEOPLE_WITH_SEVERAL_CLAUSES_IN_TEN_YEARS)));
    }

    @Test
    void getPeopleWithClausesInTenYearsInEmptyCollection() {
        COLLECTIONS.stream()
                .map(collection -> new CourtLog(collection, EMPTY_LAWSUITS))
                .map(CourtLog::getPeopleWithSeveralClausesInTenYears)
                .map(ArrayList::new)
                .forEach(result -> assertEquals(Collections.emptyList(), result));
    }

    @Test
    void getPeopleWithSuitsInThreeYears() {
        COLLECTIONS.stream()
                .map(collection -> new CourtLog(collection, LAWSUITS))
                .map(CourtLog::getPeopleWithSeveralSuitsInThreeYears)
                .map(ArrayList::new)
                .forEach(result -> assertTrue(PEOPLE_WITH_SEVERAL_SUITS_IN_THREE_YEARS.size() == result.size() &&
                        PEOPLE_WITH_SEVERAL_SUITS_IN_THREE_YEARS.containsAll(result) &&
                        result.containsAll(PEOPLE_WITH_SEVERAL_SUITS_IN_THREE_YEARS)));
    }

    @Test
    void getPeopleWithSuitsInThreeYearsInEmptyCollection() {
        COLLECTIONS.stream()
                .map(collection -> new CourtLog(collection, EMPTY_LAWSUITS))
                .map(CourtLog::getPeopleWithSeveralSuitsInThreeYears)
                .map(ArrayList::new)
                .forEach(result -> assertEquals(Collections.emptyList(), result));
    }
}
