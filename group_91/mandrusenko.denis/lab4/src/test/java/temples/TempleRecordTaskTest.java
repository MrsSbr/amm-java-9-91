package temples;

import org.junit.jupiter.api.Test;
import ru.denismandrusenko.TempleRecord;
import ru.denismandrusenko.TempleRecordTask;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TempleRecordTaskTest {

    @Test
    public void testFindDonorsInAllTemples_CommonDonors() {
        List<TempleRecord> temples = Arrays.asList(
                new TempleRecord("Temple1", "God1", "Donor1", 100),
                new TempleRecord("Temple1", "God2", "Donor1", 200),
                new TempleRecord("Temple1", "God3", "Donor1", 300)
        );
        TempleRecordTask task = new TempleRecordTask(temples);
        List<String> result = task.findDonorsInAllTemples();
        assertEquals(1, result.size());
        assertEquals("Donor1", result.get(0));
    }

    @Test
    public void testFindMostWorshippedGod() {
        List<TempleRecord> temples = Arrays.asList(
                new TempleRecord("Temple1", "God1", "Donor1", 100),
                new TempleRecord("Temple2", "God1", "Donor2", 200),
                new TempleRecord("Temple3", "God2", "Donor3", 300)
        );
        TempleRecordTask task = new TempleRecordTask(temples);
        String result = task.findMostWorshippedGod();
        assertEquals("God1", result);
    }

    @Test
    public void testFindTempleWithLeastDonation() {
        List<TempleRecord> temples = Arrays.asList(
                new TempleRecord("Temple1", "God1", "Donor1", 100),
                new TempleRecord("Temple2", "God2", "Donor2", 200),
                new TempleRecord("Temple3", "God3", "Donor3", 300)
        );
        TempleRecordTask task = new TempleRecordTask(temples);
        String result = task.findTempleWithLeastDonation();
        assertEquals("Temple1", result);
    }

    @Test
    public void testFindTempleWithLeastDonation_EmptyList() {
        List<TempleRecord> temples = List.of();
        TempleRecordTask task = new TempleRecordTask(temples);
        String result = task.findTempleWithLeastDonation();
        assertEquals("", result);
    }

    @Test
    public void testFindMostWorshippedGod_EqualCounts() {
        List<TempleRecord> temples = Arrays.asList(
                new TempleRecord("Temple1", "God1", "Donor1", 100),
                new TempleRecord("Temple2", "God2", "Donor2", 200),
                new TempleRecord("Temple3", "God1", "Donor3", 300)
        );
        TempleRecordTask task = new TempleRecordTask(temples);
        String result = task.findMostWorshippedGod();
        assertEquals("God1", result);
    }

    @Test
    public void testFindMostWorshippedGod_EmptyList() {
        List<TempleRecord> temples = List.of();
        TempleRecordTask task = new TempleRecordTask(temples);
        String result = task.findMostWorshippedGod();
        assertEquals("", result);
    }

    @Test
    public void testFindDonorsInAllTemples_NoCommonDonors() {
        List<TempleRecord> temples = Arrays.asList(
                new TempleRecord("Temple1", "God1", "Donor1", 100),
                new TempleRecord("Temple2", "God2", "Donor2", 200),
                new TempleRecord("Temple3", "God3", "Donor3", 300)
        );
        TempleRecordTask task = new TempleRecordTask(temples);
        List<String> result = task.findDonorsInAllTemples();
        assertEquals(0, result.size());
    }

    @Test
    public void testFindMostWorshippedGod_NoTemples() {
        List<TempleRecord> temples = List.of();
        TempleRecordTask task = new TempleRecordTask(temples);
        String result = task.findMostWorshippedGod();
        assertEquals("", result);
    }
}