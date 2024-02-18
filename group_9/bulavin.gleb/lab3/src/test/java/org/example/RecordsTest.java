package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class RecordsTest {

    static final Collection<CourtCase> testCases = List.of(
            new CourtCase("Jack", "John", LocalDate.of(2023, 1, 1), 76, TrialVerdict.CONVICTED),
            new CourtCase("John", "Mia", LocalDate.of(2021, 1, 1), 123, TrialVerdict.ACQUITTED),
            new CourtCase("Jack", "Alice", LocalDate.of(2021, 1, 1),45, TrialVerdict.CONVICTED),
            new CourtCase("Bob","John",  LocalDate.of(2020, 1, 1), 228, TrialVerdict.ACQUITTED),
            new CourtCase("John","Bob",  LocalDate.of(2020, 1, 1), 52, TrialVerdict.CONVICTED),
            new CourtCase("Bob","Chris",  LocalDate.of(2019, 1, 1), 85, TrialVerdict.CONVICTED)
    );
    static Records getRecords() {
        return new Records(testCases);
    }

    @Test
    void testGetConvictedPeopleWithEmptyRecords() {
        Records records = new Records(Collections.emptyList());

        Collection<String> convictedPeople = records.getConvictedPeople();
        Assertions.assertTrue(convictedPeople.isEmpty());
    }

    @Test
    void testGetYearWithHighestPercentageAcquittalsWithEmptyRecords() {
        Records records = new Records(Collections.emptyList());

        Assertions.assertEquals(Collections.emptyList(), records.getYearWithHighestPercentageAcquittals());
    }

    @Test
    void testGetDefendantAndPlaintiffPeopleWithEmptyRecords() {
        Records records = new Records(Collections.emptyList());

        Collection<String> defendantAndPlaintiffPeople = records.getDefendantAndPlaintiffPeople();
        Assertions.assertTrue(defendantAndPlaintiffPeople.isEmpty());
    }

    @Test
    void testGetYearWithHighestPercentageAcquittalsWithEqualPercentages() {
        Records records = getRecords();
        Collection<Integer> yearWithHighestPercentageAcquittals = records.getYearWithHighestPercentageAcquittals();
        Collection<Integer> result = Arrays.asList(2021, 2020);

        boolean isCollectionsAreEqual = result.containsAll(yearWithHighestPercentageAcquittals)
                && yearWithHighestPercentageAcquittals.containsAll(result);
        Assertions.assertTrue(isCollectionsAreEqual);
    }

    @Test
    void testGetConvictedPeople() {
        Records records = getRecords();
        Collection<String> convictedPeople = records.getConvictedPeople();
        Collection<String> result = List.of("Jack");

        boolean isCollectionsAreEqual = result.containsAll(convictedPeople)
                && convictedPeople.containsAll(result);
        Assertions.assertTrue(isCollectionsAreEqual);
    }

    @Test
    void testDefendantAndPlaintiffPeople() {
        Records records = getRecords();
        Collection<String> convictedPeople = records.getDefendantAndPlaintiffPeople();
        Collection<String> result = List.of("Bob", "John");

        boolean isCollectionsAreEqual = result.containsAll(convictedPeople)
                && convictedPeople.containsAll(result);
        Assertions.assertTrue(isCollectionsAreEqual);
    }


}
