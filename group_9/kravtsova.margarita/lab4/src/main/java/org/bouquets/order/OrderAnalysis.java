package org.bouquets.order;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderAnalysis {
    private List<Order> orders;
    public OrderAnalysis(List<Order> orders) {
        this.orders = orders;
    }
    public Collection<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public List<Month> monthMostDiverseFlowers() {                                         //найти месяцы в которые заказывают букеты, состоящие из наиболее разнообразных цветов
       Map<Month, Set<FlowersType>> monthWithFlowers = new HashMap<>();
       for(Month month : Month.values()) {
           monthWithFlowers.put(month, new HashSet<>());
       }
       orders.forEach(order -> order.getFlowers().forEach(flower -> monthWithFlowers.get(order.getDatePurchase().getMonth())
                                                                                    .add(flower)));
       int maxCountFlowers = monthWithFlowers.values().stream()
                                                      .map(Set::size)
                                                      .max(Comparator.naturalOrder())
                                                      .orElseThrow();
       return monthWithFlowers.entrySet().stream()
                                         .filter(month -> month.getValue().size() == maxCountFlowers)
                                         .map(Map.Entry::getKey)
                                         .collect(Collectors.toList());
    }
    public Map<BouquetType,Integer> floristEarnings() {
        //найти сколько заработал флорист по каждому типу букетов за последний год
        Map<BouquetType,Integer> earnings = new HashMap<>();
        LocalDate date = LocalDate.now().minusYears(1);
        orders.stream()
              .filter(order -> order.getDatePurchase().isAfter(date))
              .forEach(order -> earnings.merge(order.getBouquetType(), order.getPrice(), Integer::sum));
        return earnings;
    }
    public Map<FlowersType, ReceivingType> receivingFlowers() {                           //для каждого цветка узнать его чаще доставляют (1) или забирают самовывозом (-1)
        Map<FlowersType,Integer> receiving = new HashMap<>();
        orders.forEach(order -> order.getFlowers().forEach(flower -> receiving.merge(flower,
                                                            order.getReceivingType().equals(ReceivingType.DELIVERY) ? 1 : -1, Integer::sum)));
        return receiving.entrySet().stream()
                                   .map(flower -> Map.entry(flower.getKey(),flower.getValue() > 0
                                           ? ReceivingType.DELIVERY : ReceivingType.MANUALLY))
                                   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
