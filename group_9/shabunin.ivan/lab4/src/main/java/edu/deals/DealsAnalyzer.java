package edu.deals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jetbrains.annotations.NotNull;

public class DealsAnalyzer {
    private static final Logger logger = LogManager.getLogger(DealsAnalyzer.class.getName());
    private final List<Deal> deals;

    public DealsAnalyzer(@NotNull List<Deal> deals) {
        logger.info("Создание анализатора сделок.");
        this.deals = deals;
    }

    public Optional<String> findMostEffectiveManagerOverPastMonth() {
        logger.info("Вызов метода, находящего самого эффективного менеджера за последний месяц.");

        return deals.stream()
                .filter(deal -> deal.date().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(Deal::manager, Collectors.summingDouble(Deal::amount)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    public Map<String, Double> collectStatisticsOnIncomeFromEachBuyer() {
        logger.info("Вызов метода, собирающего статистику по доходу от каждого клиента.");

        return deals.stream()
                .collect(Collectors.groupingBy(Deal::buyer, Collectors.summingDouble(Deal::amount)));
    }

    public Optional<Month> findMostProfitableMonthOverPastYear() {
        logger.info("Вызов метода, находящего самый прибыльный месяц за последний год.");

        return deals.stream()
                .filter(deal -> deal.date().isAfter(LocalDate.now().minusYears(1)))
                .collect(Collectors.groupingBy(deal -> deal.date().getMonth(), Collectors.summingDouble(Deal::amount)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}