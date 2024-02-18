package ru.denismandrusenko;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class TempleRecordTask {
    private static final Logger logger = Logger.getLogger(TempleRecordTask.class.getSimpleName());
    private final List<TempleRecord> temples;

    public TempleRecordTask(List<TempleRecord> temples) {
        this.temples = temples;
    }

    // Список людей, кто жертвовал во всех храмах
    public List<String> findDonorsInAllTemples() {
        Map<String, Long> donorsCountInAllTemples = temples.stream()
                .flatMap(temple -> temples.stream()
                        .filter(t -> t.getTemple().equals(temple.getTemple()))
                        .map(TempleRecord::getDonor)
                        .distinct()) // Учитываем только уникальных жертвующих в каждом храме
                .collect(Collectors.groupingBy(donor -> donor, Collectors.counting()));

        return donorsCountInAllTemples.entrySet().stream()
                .filter(entry -> entry.getValue() == temples.size())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    // Поиск бога, которому поклоняется наибольшее количество римлян
    public String findMostWorshippedGod() {
        logger.info("Поиск бога, которому поклоняется наибольшее количество римлян");
        return temples.stream()
                .collect(Collectors.groupingBy(TempleRecord::getGod, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    // Поиск храма, которому пожертвовали наименьшую сумму
    public String findTempleWithLeastDonation() {
        return temples.stream()
                .collect(Collectors.groupingBy(TempleRecord::getTemple, Collectors.summingInt(TempleRecord::getDonationAmount)))
                .entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }
}