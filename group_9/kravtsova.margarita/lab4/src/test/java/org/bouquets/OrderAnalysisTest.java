package org.bouquets;

import org.bouquets.order.BouquetType;
import org.bouquets.order.FlowersType;
import org.bouquets.order.Order;
import org.bouquets.order.OrderAnalysis;
import org.bouquets.order.ReceivingType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OrderAnalysisTest {
    OrderAnalysis orderAnalysis = new OrderAnalysis(List.of(
            new Order(LocalDate.of(2023, 1, 15),
                    BouquetType.JUBILEE,
                    List.of(FlowersType.ASTER, FlowersType.CHAMOMILE, FlowersType.ROSE,
                            FlowersType.LILY, FlowersType.ROSE, FlowersType.PEONY, FlowersType.ASTER),
                    800,
                    ReceivingType.DELIVERY),
            new Order(LocalDate.of(2022, 12, 30),
                    BouquetType.NEW_YEAR,
                    List.of(FlowersType.GYPSOFHILA, FlowersType.LILY, FlowersType.ROSE),
                    400,
                    ReceivingType.MANUALLY),
            new Order(LocalDate.of(2023, 2, 24),
                    BouquetType.BOX,
                    List.of(FlowersType.PEONY, FlowersType.LILY, FlowersType.ROSE,
                            FlowersType.HYDRANGEA, FlowersType.ROSE, FlowersType.ASTER, FlowersType.CHRYSANTHEMUM),
                    1000,
                    ReceivingType.DELIVERY),
            new Order(LocalDate.of(2023, 4, 13),
                    BouquetType.WEDDING,
                    List.of(FlowersType.PEONY, FlowersType.CHAMOMILE, FlowersType.ROSE, FlowersType.CHAMOMILE,
                            FlowersType.ROSE, FlowersType.CHAMOMILE, FlowersType.CHAMOMILE, FlowersType.PEONY,
                            FlowersType.ROSE, FlowersType.PEONY, FlowersType.LILY),
                    6000,
                    ReceivingType.DELIVERY),
            new Order(LocalDate.of(2023, 6, 21),
                    BouquetType.BUSINESS,
                    List.of(FlowersType.LILY, FlowersType.LILY, FlowersType.LILY,
                            FlowersType.LILY, FlowersType.LILY),
                    2000,
                    ReceivingType.MANUALLY),
            new Order(LocalDate.of(2023, 6, 10),
                    BouquetType.ROMANTIC,
                    List.of(FlowersType.ROSE, FlowersType.LILY, FlowersType.CHRYSANTHEMUM, FlowersType.CHAMOMILE,
                            FlowersType.PEONY, FlowersType.TULIP, FlowersType.ASTER),
                    4000,
                    ReceivingType.MANUALLY)));
    OrderAnalysis orderAnalysisEmptyContainer = new OrderAnalysis(new ArrayList<>());
    OrderAnalysis orderAnalysisEmptyListFlowers = new OrderAnalysis(List.of(
            new Order(LocalDate.of(2023, 5, 19),
                    BouquetType.JUBILEE,
                    List.of(),
                    1000,
                    ReceivingType.DELIVERY),
            new Order(LocalDate.of(2023, 8, 3),
                    BouquetType.JUBILEE,
                    List.of(),
                    4000,
                    ReceivingType.MANUALLY),
            new Order(LocalDate.of(2023, 3, 20),
                    BouquetType.BOX,
                    List.of(),
                    3000,
                    ReceivingType.DELIVERY)));
    @Test
    void monthMostDiverseFlowers() {
        assertEquals(List.of(Month.JUNE), orderAnalysis.monthMostDiverseFlowers());
    }

    @Test
    void floristEarnings() {
        assertEquals(Map.of(BouquetType.JUBILEE, 800,
                            BouquetType.NEW_YEAR, 400,
                            BouquetType.BOX, 1000,
                            BouquetType.WEDDING, 6000,
                            BouquetType.BUSINESS, 2000,
                            BouquetType.ROMANTIC, 4000), orderAnalysis.floristEarnings());
    }

    @Test
    void receivingFlowers() {
        assertEquals(Map.of(FlowersType.ASTER, ReceivingType.DELIVERY,
                            FlowersType.CHAMOMILE, ReceivingType.DELIVERY,
                            FlowersType.ROSE, ReceivingType.DELIVERY,
                            FlowersType.LILY, ReceivingType.MANUALLY,
                            FlowersType.PEONY, ReceivingType.DELIVERY,
                            FlowersType.GYPSOFHILA, ReceivingType.MANUALLY,
                            FlowersType.HYDRANGEA, ReceivingType.DELIVERY,
                            FlowersType.CHRYSANTHEMUM, ReceivingType.MANUALLY,
                            FlowersType.TULIP, ReceivingType.MANUALLY), orderAnalysis.receivingFlowers());
    }

    @Test
    void monthMostDiverseFlowersEmptyContainer() {
        List<Month> actualResult = orderAnalysisEmptyContainer.monthMostDiverseFlowers();
        assertEquals(Month.values().length, actualResult.size());
        assertTrue(actualResult.containsAll(Arrays.stream(Month.values()).toList()));
    }

    @Test
    void floristEarningsEmptyContainer() {
        assertEquals(new HashMap<>(), orderAnalysisEmptyContainer.floristEarnings());
    }

    @Test
    void receivingFlowersEmptyContainer() {
        assertEquals(new HashMap<>(), orderAnalysisEmptyContainer.receivingFlowers());
    }
    @Test
    void monthMostDiverseFlowersEmptyListFlowers() {
        List<Month> actualResult = orderAnalysisEmptyListFlowers.monthMostDiverseFlowers();
        assertEquals(Month.values().length, actualResult.size());
        assertTrue(actualResult.containsAll(Arrays.stream(Month.values()).toList()));
    }
    @Test
    void receivingFlowersEmptyListFlowers() {
        assertEquals(new HashMap<>(), orderAnalysisEmptyListFlowers.receivingFlowers());
    }
}