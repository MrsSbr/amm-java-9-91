package org.bouquets.order;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderFactory {
    private static final List<String> flowers = List.of("Роза","Тюльпан","Хризантема","Астра","Ирис","Лилия",
            "Гортензия","Пион","Ромашка","Гипсофила","Лаванда","Мимоза","Гвоздика","Гладиолус");
    public static Order createOrder() {
        OrderBuilder builder = new OrderBuilder();
        Random rand = new Random();
        List<String> flowersInBouquet = new ArrayList<>();
        int n = rand.nextInt(3,12);
        for(int i = 0; i < n; i++) {
            flowersInBouquet.add(flowers.get(rand.nextInt(0,14)));
        }
        return builder.setDatePurchase(LocalDate.of(rand.nextInt(2022,2024),
                                                    Month.values()[(rand.nextInt(0,12))],
                                                    rand.nextInt(1,28)))
                      .setBouquetType(BouquetType.values()[rand.nextInt(0,6)])
                      .setFlowers(flowersInBouquet)
                      .setPrice(rand.nextInt(600,5000))
                      .setReceivingType(ReceivingType.values()[rand.nextInt(0,2)])
                      .buildOrder();
    }
}
