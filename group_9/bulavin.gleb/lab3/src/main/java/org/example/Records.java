package org.example;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Records {
    private final Collection<CourtCase> records;

    public Records(Collection<CourtCase> records) {
        this.records = records;
    }

    public Collection<CourtCase> getRecordings() {
        return records;
    }

    public Collection<String> getConvictedPeople() {
        long RECORDS_PERIOD = 3;
        LocalDate firstDateRecordsPeriod = LocalDate.now().minusYears(RECORDS_PERIOD + 1);
        return records.stream()
                .filter(record -> record.getResult() == TrialVerdict.CONVICTED && record.getEventDate().isAfter(firstDateRecordsPeriod))
                .collect(groupingBy(CourtCase::getDefendantName, counting()))
                .entrySet().stream()
                .filter(convictedResult -> convictedResult.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Collection<Integer> getYearWithHighestPercentageAcquittals() {
        List<CourtCase> recordsWithHighestPercentageAcquittals = records.stream()
                .collect(groupingBy(record -> record.getEventDate().getYear()))
                .entrySet().stream()
                .max((firstRecords, secondRecords) -> comparePercentageAcquittals(firstRecords.getValue(), secondRecords.getValue()))
                .map(Map.Entry::getValue).orElse(null);
        if(recordsWithHighestPercentageAcquittals == null) {
            return Collections.emptyList();
        }
        double highestPercentage = getPercentageAcquittals(recordsWithHighestPercentageAcquittals);

        return records.stream()
                .collect(groupingBy(record -> record.getEventDate().getYear()))
                .entrySet().stream()
                .filter(convictedResult -> getPercentageAcquittals(convictedResult.getValue()) == highestPercentage)
                .map(Map.Entry::getKey).toList();
    }

    private static double getPercentageAcquittals(List<CourtCase> records) {
        long countAcquittals = records.stream()
                .filter(record -> record.getResult() == TrialVerdict.ACQUITTED)
                .count();
        double countAllRecords = records.size();
        return countAcquittals / countAllRecords;
    }

    private static int comparePercentageAcquittals(List<CourtCase> firstRecords, List<CourtCase> secondRecords) {
        double firstPercentage = getPercentageAcquittals(firstRecords);
        double secondPercentage = getPercentageAcquittals(secondRecords);
        return Double.compare(firstPercentage, secondPercentage);
    }

    public Collection<String> getDefendantAndPlaintiffPeople() {
        Collection<String> defendantNames = records.stream()
                .map(CourtCase::getDefendantName)
                .toList();
        return records.stream()
                .map(CourtCase::getPlaintiffName)
                .filter(defendantNames::contains)
                .toList();
    }
}
