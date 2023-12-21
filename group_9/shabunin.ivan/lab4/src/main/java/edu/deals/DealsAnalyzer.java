package edu.deals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

public class DealsAnalyzer {
    private final List<Deal> deals;

    public DealsAnalyzer(@NotNull List<Deal> deals) {
        this.deals = deals;
    }

    public Optional<String> findMostEffectiveManagerOverPastMonth() {
        return deals.stream()
                .filter(deal -> deal.date().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(Deal::manager, Collectors.summingDouble(Deal::amount)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public Map<String, Double> collectStatisticsOnIncomeFromEachBuyer() {
        return deals.stream()
                .collect(Collectors.groupingBy(Deal::buyer, Collectors.summingDouble(Deal::amount)));
    }

    public Optional<Month> findMostProfitableMonthOverPastYear() {
        return deals.stream()
                .filter(deal -> deal.date().isAfter(LocalDate.now().minusYears(1)))
                .collect(Collectors.groupingBy(deal -> deal.date().getMonth(), Collectors.summingDouble(Deal::amount)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
