import org.example.model.MilkRecord;
import org.example.service.MilkRecordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

class MilkRecordServiceTest {

    private final MilkRecordService service = new MilkRecordService();

    @Test
    void bestMonthForFeedCountToMilkCount() {
        List<MilkRecord> list = new ArrayList<>();
        MilkRecord mr1 = getRecord(
                LocalDate.of(2023, 1, 4), 2, 100
        );
        MilkRecord mr2 = getRecord(
                LocalDate.of(2023, 1, 5), 3, 900
        );
        MilkRecord mr3 = getRecord(
                LocalDate.of(2023, 2, 1), 100, 50
        );
        MilkRecord mr4 = getRecord(
                LocalDate.of(2023, 2, 3), 50, 1
        );
        MilkRecord mr5 = getRecord(
                LocalDate.of(2023, 3, 23), 50, 60
        );
        list.add(mr1);
        list.add(mr2);
        list.add(mr3);
        list.add(mr4);
        list.add(mr5);

        Month actualMonth = service.bestMonthForFeedCountToMilkCount(list);

        Assertions.assertNotNull(actualMonth);
        Assertions.assertEquals(Month.JANUARY, actualMonth);
    }

    @Test
    void averageWeeklyMilkCount() {
        List<MilkRecord> list = new ArrayList<>();
        int count = 100;
        int milkPerDay = 14;
        for (int i = 0; i < count; i ++) {
            MilkRecord record = getRecord(
                    LocalDate.of(2023, 1, 1).plusDays(i), 0, milkPerDay
            );
            list.add(record);
        }
        double expected = 14;

        double actual = service.averageWeeklyMilkCount(list);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void eatenFeedCountSum() {
        List<MilkRecord> list = new ArrayList<>();
        int count = 50;
        int feedPerRecord = 25;
        for (int i = 0; i < count; i++) {
            list.add(getRecord(LocalDate.now(), feedPerRecord, 0));
        }
        int expectedFeedCount = count * feedPerRecord;

        int actualFeedCount = service.eatenFeedCountSum(list);

        Assertions.assertEquals(expectedFeedCount, actualFeedCount);
    }

    private MilkRecord getRecord(LocalDate date, int feed, int milk) {
        MilkRecord mr = new MilkRecord();
        mr.setDate(date);
        mr.setFeedCount(feed);
        mr.setMilkCount(milk);
        return mr;
    }
}
