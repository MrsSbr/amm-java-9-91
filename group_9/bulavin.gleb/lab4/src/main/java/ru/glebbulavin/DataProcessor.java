package ru.glebbulavin;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DataProcessor {

    private final Collection<SaleRecord> records;

    DataProcessor(Collection<SaleRecord> records) {
        this.records = records;
    }

    public Map<String, String> findMaxMarkupDealershipPerCar() {
        return records.stream()
                .collect(Collectors.groupingBy(SaleRecord::getCarName,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(SaleRecord::getMarkup)),
                                record -> record.map(SaleRecord::getDealershipName).orElse(null)
                        )));
    }

    public String findDealershipWithMostUniqueConfigurations() {
        long RECORDS_PERIOD = 3;
        LocalDate firstDateRecordsPeriod = LocalDate.now().minusYears(RECORDS_PERIOD + 1);
        return records.stream()
                .filter(record -> record.getDate().isAfter(firstDateRecordsPeriod))
                .collect(Collectors.groupingBy(record -> record.getDealershipName() + "_" + record.getCarName()
                                + "_" + record.getConfiguration(),
                        Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.groupingBy(entry -> entry.getKey().split("_")[0], Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Map<String, BigDecimal> calculateTotalEarningsPerDealership() {
        return records.stream()
                .collect(Collectors.groupingBy(SaleRecord::getDealershipName,
                        Collectors.reducing(BigDecimal.ZERO, SaleRecord::getMarkup, BigDecimal::add)));
    }
}
