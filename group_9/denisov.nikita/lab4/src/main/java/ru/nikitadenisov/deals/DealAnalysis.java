package ru.nikitadenisov.deals;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class DealAnalysis {
    private static final Logger logger = Logger.getLogger(DealAnalysis.class.getSimpleName());
    private final List<Deal> deals;

    public DealAnalysis(List<Deal> deals) {
        this.deals = deals;
    }

    // Найти самого эффективного менеджера за последний месяц.
    public Optional<String> findMostEffectiveManagerOverPastMonth() {
        logger.info("Поиск самого эффективного менеджера за последний месяц.");

        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        Map<String, Double> managerTotalAmount =
                deals.stream()
                        .filter(deal -> deal.getServiceDate().isAfter(lastMonth))
                        .collect(Collectors.groupingBy(Deal::getManager, Collectors.summingDouble(Deal::getDealAmount)));

        return managerTotalAmount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // Статистика по доходу от каждого клиента.
    public Map<String, Double> calculateIncomeByClient() {
        logger.info("Статистика по доходу от каждого клиента.");

        return deals.stream()
                .collect(Collectors.groupingBy(Deal::getBuyer, Collectors.summingDouble(Deal::getDealAmount)));
    }

    // Самый прибыльный месяц за последний год.
    public Optional<Month> findMostProfitableMonthLastYear() {
        logger.info("Самый прибыльный месяц за последний год.");

        LocalDate lastYear = LocalDate.now().minusYears(1);

        return deals.stream()
                .filter(deal -> deal.getServiceDate().isAfter(lastYear))
                .collect(Collectors.groupingBy(
                        deal -> Month.from(deal.getServiceDate()),
                        Collectors.summingDouble(Deal::getDealAmount)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
