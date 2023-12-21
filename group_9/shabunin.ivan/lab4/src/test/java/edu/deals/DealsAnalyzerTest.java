package edu.deals;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DealsAnalyzerTest {
    private DealsAnalyzer dealsAnalyzer;
    private DealsAnalyzer emptyAnalyzer;

    @BeforeEach
    public void setUp() {
        List<Deal> deals = new ArrayList<>() {{
            // Сделки, к-рые были совершены в течение последнего месяца
            add(new Deal("Иванов",
                    "Покупалкин",
                    1000,
                    LocalDate.now().minusDays(8)));
            add(new Deal("Иванов",
                    "Покупалкин",
                    5000,
                    LocalDate.now()));
            add(new Deal("Петров",
                    "Палкин",
                    750,
                    LocalDate.now().minusDays(19)));
            add(new Deal("Козлов",
                    "Олухов",
                    10000,
                    LocalDate.now().minusDays(10)));

            // Сделки, к-рые были совершены 1,5 и 2,5 месяца назад соответственно
            add(new Deal("Петров",
                    "Олухов",
                    20000,
                    LocalDate.now().minusMonths(1).minusDays(15)));
            add(new Deal("Иванов",
                    "Палкин",
                    5000,
                    LocalDate.now().minusMonths(2).minusDays(15)));

            // Сделки, к-рые были совершены более года назад
            add(new Deal("Иванов",
                    "Олухов",
                    50000,
                    LocalDate.now().minusYears(1).minusDays(2)));
            add(new Deal("Петров",
                    "Покупалкин",
                    1000,
                    LocalDate.now().minusMonths(14)));
        }};

        dealsAnalyzer = new DealsAnalyzer(deals);

        emptyAnalyzer = new DealsAnalyzer(new ArrayList<>());
    }

    @Test
    public void testFindMostEffectiveManagerOverPastMonth() {
        String result = dealsAnalyzer.findMostEffectiveManagerOverPastMonth().orElse("");
        String expected = "Козлов";
        assertThat(result).isEqualTo(expected);

        assertThat(emptyAnalyzer.findMostEffectiveManagerOverPastMonth()).isEmpty();
    }

    @Test
    public void testCollectStatisticsOnIncomeFromEachBuyer() {
        Map<String, Double> result = dealsAnalyzer.collectStatisticsOnIncomeFromEachBuyer();
        Map<String, Double> expected = new HashMap<>() {{
            put("Покупалкин", 7000.0);
            put("Палкин", 5750.0);
            put("Олухов", 80000.0);
        }};
        assertThat(result).containsExactlyInAnyOrderEntriesOf(expected);

        assertThat(emptyAnalyzer.collectStatisticsOnIncomeFromEachBuyer()).isEmpty();
    }

    @Test
    public void testFindMostProfitableMonthOverPastYear() {
        Month result = dealsAnalyzer.findMostProfitableMonthOverPastYear().get();
        Month expected = LocalDate.now().minusMonths(1).minusDays(15).getMonth();
        assertThat(result).isEqualTo(expected);

        assertThat(emptyAnalyzer.findMostProfitableMonthOverPastYear()).isEmpty();
    }

}
