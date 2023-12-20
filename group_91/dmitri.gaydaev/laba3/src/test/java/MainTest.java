import org.example.Hunt;
import org.example.Tribe;
import org.example.TribeInterface;
import org.example.TribeMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//public class MainTest {
//    private List<Hunt> hunts;
//
//    @BeforeEach
//    void setUp() {
//        hunts = new ArrayList<>();
//        hunts.add(new Hunt("Hunter1", 1200, 2021, 5, 10));
//        hunts.add(new Hunt("Hunter2", 1500, 2021, 6, 20));
//        hunts.add(new Hunt("Hunter3", 1800, 2021, 7, 30));
//        hunts.add(new Hunt("Hunter1", 1000, 2022, 8, 15));
//        hunts.add(new Hunt("Hunter2", 1300, 2022, 9, 25));
//        hunts.add(new Hunt("Hunter3", 1600, 2022, 10, 5));
//        hunts.add(new Hunt("Hunter4", 2000, 2022, 11, 15));
//        hunts.add(new Hunt("Hunter5", 2200, 2022, 12, 25));
//    }
//
//    @Test
//    void testGetHunters() {
//        List<String> expected = new ArrayList<>();
//        expected.add("Hunter1");
//        expected.add("Hunter2");
//        expected.add("Hunter3");
//        expected.add("Hunter4");
//        expected.add("Hunter5");
//        List<String> actual = Main.getHunters(hunts);
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetTotalWeight() {
//        int expected = 5500;
//        int actual = Main.getTotalWeight(hunts, 2022, 9, 1);
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetHunterWeights() {
//        String input = "2021 1 1\n";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        List<String> expected = new ArrayList<>();
//        expected.add("Hunter1: 2200");
//        expected.add("Hunter2: 2800");
//        expected.add("Hunter3: 3400");
//        expected.add("Hunter4: 2000");
//        expected.add("Hunter5: 2200");
//        List<String> actual = Main.getHunterWeights(hunts);
//        Assertions.assertEquals(expected, actual);
//    }
//}

//public class TrideMainTest {
//
//    @Test
//    public void testGetHunters() {
//        List<Hunt> hunts = new ArrayList<>();
//        hunts.add(new Hunt("Hunter1", 1000, 2020, Month.JANUARY.getValue(), 1));
//        hunts.add(new Hunt("Hunter2", 500, 2020, Month.JANUARY.getValue(), 1));
//        hunts.add(new Hunt("Hunter3", 750, 2020, Month.JANUARY.getValue(), 1));
//        hunts.add(new Hunt("Hunter1", 800, 2020, Month.JANUARY.getValue(), 2));
//        hunts.add(new Hunt("Hunter2", 600, 2020, Month.JANUARY.getValue(), 2));
//        List<String> expected = new ArrayList<>();
//        expected.add("Hunter1");
//        expected.add("Hunter2");
//        expected.add("Hunter3");
//      ;
//        List<String> actual = Tribe.getHunters(hunts);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGetTotalWeight() {
//        List<Hunt> hunts = new ArrayList<>();
//        hunts.add(new Hunt("Hunter1", 1000, 2020, Month.JANUARY.getValue(), 1));
//        hunts.add(new Hunt("Hunter2", 500, 2020, Month.JANUARY.getValue(), 1));
//        hunts.add(new Hunt("Hunter3", 750, 2020, Month.JANUARY.getValue(), 1));
//        hunts.add(new Hunt("Hunter1", 800, 2020, Month.JANUARY.getValue(), 2));
//        hunts.add(new Hunt("Hunter2", 600, 2020, Month.JANUARY.getValue(), 2));
//        hunts.add(new Hunt("Hunter1", 1200, 2019, Month.DECEMBER.getValue(), 31));
//        hunts.add(new Hunt("Hunter2", 800, 2019, Month.DECEMBER.getValue(), 31));
//        int expected = 2000;
//        int actual = TribeMain.getTotalWeight(hunts, 2020, Month.JANUARY.getValue(), 1);
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testGetHunterWeights() {
//        List<Hunt> hunts = new ArrayList<>();
//        hunts.add(new Hunt("Hunter1", 1000, 2020, Month.JANUARY.getValue(), 1));
//        hunts.add(new Hunt("Hunter2", 500, 2020, Month.JANUARY.getValue(), 1));
//        hunts.add(new Hunt("Hunter3", 750, 2020, Month.JANUARY.getValue(), 1));
//        hunts.add(new Hunt("Hunter1", 800, 2020, Month.JANUARY.getValue(), 2));
//        hunts.add(new Hunt("Hunter2", 600, 2020, Month.JANUARY.getValue(), 2));
//        List<String> expected = new ArrayList<>();
//        expected.add("Hunter1: 1800");
//        expected.add("Hunter2: 1100");
//        expected.add("Hunter3: 750");
//        List<String> actual = TribeMain.getHunterWeights(hunts);
//        assertEquals(expected, actual);
//    }
//}

public class MainTest {
    @Test
    public void testGetHuntersWithNullList() {
        Tribe huntingStatistics = new Tribe();
        List<Hunt> hunts = null;
        assertThrows(NullPointerException.class, () -> {
            huntingStatistics.getHunters(hunts);
        });
    }

    @Test
    public void testGetHuntersWithEmptyHunters() {
        Tribe huntingStatistics = new Tribe();
        List<Hunt> hunts = new ArrayList<>();
        hunts.add(new Hunt("", 100,2020, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt(null, 200, 2021, Month.JANUARY.getValue(), 2));
        List<String> expectedHunters = Arrays.asList("", null);
        List<String> actualHunters = huntingStatistics.getHunters(hunts);
        assertEquals(expectedHunters, actualHunters);
    }
    @Test
    public void testGetTotalWeight() {
        Tribe huntingStatistics = new Tribe();
        List<Hunt> hunts = new ArrayList<>();
        hunts.add(new Hunt("John", 100, 2018, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Mike", 200, 2019, Month.JANUARY.getValue(), 2));
        hunts.add(new Hunt("John", 150, 2020, Month.JANUARY.getValue(), 3));
        int expectedTotalWeight = 350;
        int actualTotalWeight = huntingStatistics.getTotalWeight(hunts, 2021, 1, 1);
        assertEquals(expectedTotalWeight, actualTotalWeight);
    }

    @Test
    public void testGetTotalWeightEmptyList() {
        Tribe huntingStatistics = new Tribe();
        List<Hunt> hunts = new ArrayList<>();
        int expectedTotalWeight = 0;
        int actualTotalWeight = huntingStatistics.getTotalWeight(hunts, 2021, 1, 1);
        assertEquals(expectedTotalWeight, actualTotalWeight);
    }
    @Test
    public void testGetHunterWeights() {
        Tribe huntingStatistics = new Tribe();
        List<Hunt> hunts = new ArrayList<>();
        hunts.add(new Hunt("John", 100, 2018, Month.JANUARY.getValue(), 1));
        hunts.add(new Hunt("Mike", 200, 2019, Month.FEBRUARY.getValue(), 1));
        hunts.add(new Hunt("John", 150, 2020, Month.MARCH.getValue(), 1));
        List<String> expectedHunterWeights = Arrays.asList("Mike: 200", "John: 250");
        List<String> actualHunterWeights = huntingStatistics.getHunterWeights(hunts);
        assertEquals(expectedHunterWeights, actualHunterWeights);
    }

    @Test
    public void testGetHunterWeightsEmptyList() {
        Tribe huntingStatistics = new Tribe();
        List<Hunt> hunts = new ArrayList<>();
        List<String> expectedHunterWeights = new ArrayList<>();
        List<String> actualHunterWeights = huntingStatistics.getHunterWeights(hunts);
        assertEquals(expectedHunterWeights, actualHunterWeights);
    }





}




