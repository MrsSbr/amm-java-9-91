package deals;

import org.junit.jupiter.api.Test;
import ru.nikitadenisov.deals.Deal;
import ru.nikitadenisov.deals.DealAnalysis;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DealAnalysisTest {
    private static final List<Deal> DEALS = Arrays.asList(
            new Deal("Manager1", "Client1", 1000.0, LocalDate.now().minusDays(10)),
            new Deal("Manager2", "Client2", 1500.0, LocalDate.now().minusDays(5)),
            new Deal("Manager1", "Client1", 2000.0, LocalDate.now().minusDays(3))
    );

    @Test
    void findMostEffectiveManagerOverPastMonth() {
        DealAnalysis dealAnalysis = new DealAnalysis(DEALS);

        Optional<String> mostEffectiveManager = dealAnalysis.findMostEffectiveManagerOverPastMonth();

        assertTrue(mostEffectiveManager.isPresent());
        assertEquals("Manager1", mostEffectiveManager.get());
    }

    @Test
    void findMostEffectiveManagerOverPastMonthWithEmptyCollection() {
        DealAnalysis dealAnalysis = new DealAnalysis(Collections.emptyList());

        Optional<String> mostEffectiveManager = dealAnalysis.findMostEffectiveManagerOverPastMonth();

        assertFalse(mostEffectiveManager.isPresent());
    }

    @Test
    void findMostEffectiveManagerOverPastMonthWithNullCollection() {
        DealAnalysis dealAnalysis = new DealAnalysis(null);

        assertThrows(NullPointerException.class, dealAnalysis::findMostEffectiveManagerOverPastMonth);
    }

    @Test
    void calculateIncomeByClient() {
        DealAnalysis dealAnalysis = new DealAnalysis(DEALS);
        Map<String, Double> incomeByClient = dealAnalysis.calculateIncomeByClient();

        assertEquals(3000.0, incomeByClient.get("Client1"));
        assertEquals(1500.0, incomeByClient.get("Client2"));
    }

    @Test
    void calculateIncomeByClientWithEmptyCollection() {
        DealAnalysis dealAnalysis = new DealAnalysis(Collections.emptyList());
        Map<String, Double> incomeByClient = dealAnalysis.calculateIncomeByClient();

        assertEquals(Collections.emptyMap(), incomeByClient);
    }

    @Test
    void calculateIncomeByClientWithNullCollection() {
        DealAnalysis dealAnalysis = new DealAnalysis(null);

        assertThrows(NullPointerException.class, dealAnalysis::calculateIncomeByClient);
    }

    @Test
    void findMostProfitableMonthLastYear() {
        List<Deal> deals = Arrays.asList(
                new Deal("Manager1", "Client1", 1000.0, LocalDate.now().minusMonths(13)),
                new Deal("Manager2", "Client2", 1500.0, LocalDate.now().minusMonths(11)),
                new Deal("Manager1", "Client1", 2000.0, LocalDate.now().minusMonths(10))
        );

        DealAnalysis dealAnalysis = new DealAnalysis(deals);
        Optional<Month> mostProfitableMonth = dealAnalysis.findMostProfitableMonthLastYear();

        assertTrue(mostProfitableMonth.isPresent());
        assertEquals(LocalDate.now().minusMonths(10).getMonth(), mostProfitableMonth.get());
    }

    @Test
    void findMostProfitableMonthLastYearWithEmptyCollection() {
        DealAnalysis dealAnalysis = new DealAnalysis(Collections.emptyList());
        Optional<Month> mostProfitableMonth = dealAnalysis.findMostProfitableMonthLastYear();

        assertFalse(mostProfitableMonth.isPresent());
    }

    @Test
    void findMostProfitableMonthLastYearWithNullCollection() {
        DealAnalysis dealAnalysis = new DealAnalysis(null);

        assertThrows(NullPointerException.class, dealAnalysis::findMostProfitableMonthLastYear);
    }
}
