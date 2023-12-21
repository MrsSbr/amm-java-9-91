package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class GiftAnalysisService {

    public Set<Integer> getYears(List<Gift> gifts) {
        return gifts.stream()
                .map(Gift::getYear)
                .collect(Collectors.toSet());
    }

    public Map<String, Double> getMaxWeights(List<Gift> gifts) {
        return gifts.stream()
                .collect(Collectors.groupingBy(Gift::getColor, Collectors.maxBy(Comparator.comparingDouble(Gift::getWeight))))
                        .entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get().getWeight()));
    }

    public Map<GiftType, Double> getTotalWeights(List<Gift> gifts) {
        return gifts.stream()
                .collect(Collectors.groupingBy(Gift::getType, Collectors.summingDouble(Gift::getWeight)));
    }
}