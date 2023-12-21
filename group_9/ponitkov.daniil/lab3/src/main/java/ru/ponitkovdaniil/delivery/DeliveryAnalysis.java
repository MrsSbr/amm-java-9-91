package ru.ponitkovdaniil.delivery;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeliveryAnalysis {
    private final Collection<DeliveryRecord> deliveryRecords;

    public DeliveryAnalysis(Collection<DeliveryRecord> deliveryRecords) {
        this.deliveryRecords = deliveryRecords;
    }

    public double calculateAverageDeliveryTime() {
        return deliveryRecords.stream()
                .collect(Collectors.averagingDouble(DeliveryRecord::getDeliveryTime));
    }
    public List<LocalDate> findMaxOrderDaysLastMonth() {
        LocalDate lastMonthStart = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate lastMonthEnd = LocalDate.now().withDayOfMonth(1);

        Map<LocalDate, Long> orderCounts = deliveryRecords.stream()
                .filter(record -> record.getOrderDate().isAfter(lastMonthStart) && record.getOrderDate().isBefore(lastMonthEnd))
                .collect(Collectors.groupingBy(DeliveryRecord::getOrderDate, Collectors.counting()));

        long maxOrders = orderCounts.values().stream()
                .max(Comparator.naturalOrder())
                .orElse(0L);

        return orderCounts.entrySet().stream()
                .filter(entry -> entry.getValue() == maxOrders)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public double calculateTotalWeight() {
        return deliveryRecords.stream()
                .mapToDouble(DeliveryRecord::getWeight)
                .sum();
    }
}