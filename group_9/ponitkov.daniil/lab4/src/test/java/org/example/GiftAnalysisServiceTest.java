package org.example;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GiftAnalysisServiceTest {
    private final GiftAnalysisService service = new GiftAnalysisService();

    @Test
    public void testGetYearsEmptyList() {
        assertTrue(service.getYears(new ArrayList<>()).isEmpty());
    }

    @Test
    public void testGetYearsSingleElement() {
        List<Gift> gifts = Collections.singletonList(new Gift(2020, GiftSize.MEDIUM, 2.5, GiftType.TOY, "Red"));
        assertEquals(Collections.singleton(2020), service.getYears(gifts));
    }

    @Test
    public void testGetYearsMultipleElements() {
        List<Gift> gifts = List.of(
                new Gift(2020, GiftSize.MEDIUM, 2.5, GiftType.TOY, "Red"),
                new Gift(2021, GiftSize.LARGE, 3.0, GiftType.BOOK, "Blue"),
                new Gift(2020, GiftSize.SMALL, 1.0, GiftType.GAME, "Green")
        );
        Set<Integer> expectedYears = new HashSet<>(Arrays.asList(2020, 2021));
        assertEquals(expectedYears, service.getYears(gifts));
    }

    @Test
    public void testGetMaxWeightsEmptyList() {
        assertTrue(service.getMaxWeights(new ArrayList<>()).isEmpty());
    }

    @Test
    public void testGetMaxWeightsSingleElement() {
        List<Gift> gifts = Collections.singletonList(new Gift(2020, GiftSize.MEDIUM, 2.5, GiftType.TOY, "Red"));
        Map<String, Double> expected = Collections.singletonMap("Red", 2.5);
        assertEquals(expected, service.getMaxWeights(gifts));
    }

    @Test
    public void testGetMaxWeightsMultipleElements() {
        List<Gift> gifts = List.of(
                new Gift(2020, GiftSize.MEDIUM, 2.5, GiftType.TOY, "Red"),
                new Gift(2021, GiftSize.LARGE, 3.5, GiftType.BOOK, "Blue"),
                new Gift(2022, GiftSize.SMALL, 4.0, GiftType.GAME, "Red")
        );
        Map<String, Double> expected = new HashMap<>();
        expected.put("Red", 4.0);
        expected.put("Blue", 3.5);
        assertEquals(expected, service.getMaxWeights(gifts));
    }

    @Test
    public void testGetTotalWeightsEmptyList() {
        assertTrue(service.getTotalWeights(new ArrayList<>()).isEmpty());
    }

    @Test
    public void testGetTotalWeightsSingleElement() {
        List<Gift> gifts = Collections.singletonList(new Gift(2020, GiftSize.MEDIUM, 2.5, GiftType.TOY, "Red"));
        Map<GiftType, Double> expected = Collections.singletonMap(GiftType.TOY, 2.5);
        assertEquals(expected, service.getTotalWeights(gifts));
    }

    @Test
    public void testGetTotalWeightsMultipleElements() {
        List<Gift> gifts = List.of(
                new Gift(2020, GiftSize.MEDIUM, 2.5, GiftType.TOY, "Red"),
                new Gift(2021, GiftSize.LARGE, 3.0, GiftType.TOY, "Blue"),
                new Gift(2022, GiftSize.SMALL, 1.5, GiftType.GAME, "Green")
        );
        Map<GiftType, Double> expected = new HashMap<>();
        expected.put(GiftType.TOY, 5.5);
        expected.put(GiftType.GAME, 1.5);
        assertEquals(expected, service.getTotalWeights(gifts));
    }
}