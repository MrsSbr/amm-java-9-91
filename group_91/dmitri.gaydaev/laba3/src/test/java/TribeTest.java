import org.example.Tribe;
import org.junit.jupiter.api.Assertions;
import org.example.Hunt;
import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TribeTest {

    @Test
    public void testGetHunters() {
        List<Hunt> hunts = new ArrayList<>();
        hunts.add(new Hunt("Hunter1", 1000, 2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Hunter2", 500, 2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Hunter3", 750, 2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Hunter1", 800, 2020, Month.JANUARY.getValue(), 2));
        hunts.add(new Hunt("Hunter2", 600, 2020, Month.JANUARY.getValue(), 2));
        List<String> expected = new ArrayList<>();
        expected.add("Hunter1");
        expected.add("Hunter2");
        expected.add("Hunter3");
        List<String> actual = Tribe.getHunters(hunts);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetTotalWeight() {
        List<Hunt> hunts = new ArrayList<>();
        hunts.add(new Hunt("Hunter1", 1000, 2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Hunter2", 500, 2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Hunter3", 750, 2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Hunter1", 800, 2020, Month.JANUARY.getValue(), 2));
        hunts.add(new Hunt("Hunter2", 600, 2020, Month.JANUARY.getValue(), 2));
        hunts.add(new Hunt("Hunter1", 1200, 2019, Month.DECEMBER.getValue(), 31));
        hunts.add(new Hunt("Hunter2", 800, 2019, Month.DECEMBER.getValue(), 31));
        int expected = 2000;
        int actual = Tribe.getTotalWeight(hunts, 2020, Month.JANUARY.getValue(), 1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetHunterWeights() {
        List<Hunt> hunts = new ArrayList<>();
        hunts.add(new Hunt("Hunter1", 1000, 2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Hunter2", 500, 2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Hunter3", 750, 2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Hunter1", 800, 2020, Month.JANUARY.getValue(), 2));
        hunts.add(new Hunt("Hunter2", 600, 2020, Month.JANUARY.getValue(), 2));
        List<String> expected = new ArrayList<>();
        expected.add("Hunter1: 1800");
        expected.add("Hunter2: 1100");
        expected.add("Hunter3: 750");
        List<String> actual = Tribe.getHunterWeights(hunts);
        assertEquals(expected, actual);
    }
}