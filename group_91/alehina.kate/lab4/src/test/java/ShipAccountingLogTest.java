import org.example.Citizenship;
import org.example.ShipAccountingLog;
import org.example.Entry;
import org.example.ShipClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShipAccountingLogTest {
    private final ShipAccountingLog shipAccountingLog = new ShipAccountingLog();
    private List<Entry> entryList;
    @BeforeEach
    void setup() {
        entryList = new ArrayList<>();
    }

    @Test
    public void testStatisticsOnShipsBoarded() {
        entryList.add(new Entry(
                LocalDate.of(2020, 4, 6),
                ShipClass.fromString("Бриг"),
                Citizenship.fromString("Англия"),
                new BigDecimal(6758),
                45,
                true));
        entryList.add(new Entry(
                LocalDate.of(2021, 3, 6),
                ShipClass.fromString("Бригантина"),
                Citizenship.fromString("Франция"),
                new BigDecimal(456),
                32,
                true));
        entryList.add(new Entry(
                LocalDate.of(2019, 5, 14),
                ShipClass.fromString("Каравелла"),
                Citizenship.fromString("Португалия"),
                new BigDecimal(3500),
                100,
                false));

        Map<Citizenship, Long> statisticsOnShipsBoarded = shipAccountingLog.statisticsOnShipsBoarded(entryList);

        Map<Citizenship, Long> statistics = new HashMap<>();
        statistics.put(Citizenship.ENGLAND, 1L);
        statistics.put(Citizenship.FRANCE, 1L);

        assertEquals(statistics, statisticsOnShipsBoarded);
    }

    @Test
    public void testStatisticsOnShipsBoardedEmpty() {
        Map<Citizenship, Long> statistics = shipAccountingLog.statisticsOnShipsBoarded(entryList);
        assertEquals(Map.of(), statistics);
    }

    @Test
    public void testTheLowestProfitableMonthInGold() {
        entryList.add(new Entry(
                LocalDate.of(2020, 4, 6),
                ShipClass.fromString("Бриг"),
                Citizenship.fromString("Англия"),
                new BigDecimal(6758),
                45,
                true));
        entryList.add(new Entry(
                LocalDate.of(2021, 3, 6),
                ShipClass.fromString("Бригантина"),
                Citizenship.fromString("Франция"),
                new BigDecimal(456),
                32,
                true));
        entryList.add(new Entry(
                LocalDate.of(2019, 5, 14),
                ShipClass.fromString("Каравелла"),
                Citizenship.fromString("Португалия"),
                new BigDecimal(3500),
                100,
                false));

        YearMonth lowestMonth = shipAccountingLog.theLowestProfitableMonthInGold(entryList);

        assertEquals(YearMonth.of(2021, 3), lowestMonth);
    }

    @Test
    public void testTheLowestProfitableMonthInGoldEmpty() {
        assertThrows(NoSuchElementException.class, () -> shipAccountingLog.theLowestProfitableMonthInGold(entryList));
    }


    @Test
    public void testTheLargestStocksOfRum() {
        entryList.add(new Entry(
                LocalDate.of(2020, 4, 6),
                ShipClass.fromString("Бриг"),
                Citizenship.fromString("Англия"),
                new BigDecimal(6758),
                45,
                true));
        entryList.add(new Entry(
                LocalDate.of(2021, 3, 6),
                ShipClass.fromString("Бригантина"),
                Citizenship.fromString("Франция"),
                new BigDecimal(456),
                32,
                true));
        entryList.add(new Entry(
                LocalDate.of(2022, 5, 14),
                ShipClass.fromString("Каравелла"),
                Citizenship.fromString("Португалия"),
                new BigDecimal(3500),
                100,
                false));

        List<Entry> largestStocks = shipAccountingLog.theLargestStocksOfRum(entryList);

        assertEquals(
                List.of(
                        new Entry(LocalDate.of(2022, 5, 14),
                                ShipClass.fromString("Каравелла"),
                                Citizenship.fromString("Португалия"),
                                new BigDecimal(3500),
                                100, false)
                ),
                largestStocks
        );
    }

    @Test
    public void testTheLargestStocksOfRumEmpty() {
        List<Entry> largestStocks = shipAccountingLog.theLargestStocksOfRum(entryList);
        assertEquals(List.of(), largestStocks);
    }
}
