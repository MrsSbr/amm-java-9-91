package org.bouquets;

import org.bouquets.order.BouquetType;
import org.bouquets.order.Order;
import org.bouquets.order.OrderAnalysis;
import org.bouquets.order.ReceivingType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderAnalysisTest {
    List<Order> orders = List.of(new Order (LocalDate.of(2023,1,15),
                                            BouquetType.JUBILEE,
                                            List.of("Астра", "Ромашка","Роза","Лилия","Роза","Пион","Астра"),
                                            800,
                                            ReceivingType.DELIVERY),
                                 new Order (LocalDate.of(2022,12,30),
                                            BouquetType.NEW_YEAR,
                                            List.of("Гипсофила", "Лилия","Роза"),
                                            400,
                                            ReceivingType.MANUALLY),
                                 new Order (LocalDate.of(2023,2,24),
                                            BouquetType.BOX,
                                            List.of("Пион", "Лилия","Роза","Гортензия","Роза","Астра","Хризантема"),
                                            1000,
                                            ReceivingType.DELIVERY),
                                 new Order (LocalDate.of(2023,4,13),
                                            BouquetType.WEDDING,
                                            List.of("Пион", "Ромашка","Роза","Ромашка","Роза","Ромашка","Ромашка","Пион","Роза","Пион","Лилия"),
                                            6000,
                                            ReceivingType.DELIVERY),
                                 new Order (LocalDate.of(2023,6,21),
                                            BouquetType.BUSINESS,
                                            List.of("Лилия", "Лилия","Лилия","Лилия","Лилия"),
                                            2000,
                                            ReceivingType.MANUALLY),
                                 new Order (LocalDate.of(2023,6,10),
                                            BouquetType.ROMANTIC,
                                            List.of("Роза", "Лилия","Хризантема","Ромашка","Пион","Тюльпан","Астра"),
                                            4000,
                                            ReceivingType.MANUALLY));
    OrderAnalysis orderAnalysis = new OrderAnalysis(orders);
    @Test
    void monthMostDiverseFlowers() {
        assertEquals(List.of(Month.JUNE), orderAnalysis.monthMostDiverseFlowers());
    }

    @Test
    void floristEarnings() {
        assertEquals(Map.of(BouquetType.JUBILEE,800,
                            BouquetType.NEW_YEAR,400,
                            BouquetType.BOX,1000,
                            BouquetType.WEDDING,6000,
                            BouquetType.BUSINESS,2000,
                            BouquetType.ROMANTIC,4000),orderAnalysis.floristEarnings());
    }

    @Test
    void receivingFlowers() {
        assertEquals(Map.of("Астра",ReceivingType.DELIVERY,
                            "Ромашка",ReceivingType.DELIVERY,
                            "Роза",ReceivingType.DELIVERY,
                            "Лилия",ReceivingType.MANUALLY,
                            "Пион",ReceivingType.DELIVERY,
                            "Гипсофила",ReceivingType.MANUALLY,
                            "Гортензия",ReceivingType.DELIVERY,
                            "Хризантема",ReceivingType.MANUALLY,
                            "Тюльпан",ReceivingType.MANUALLY),orderAnalysis.receivingFlowers());
    }
}