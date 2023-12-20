package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeaPlantationFunctionality {
    public List<Integer> findTheMostPlenteousYears(Collection<TeaPackage> teaPackages) {
        List<Integer> years = new ArrayList<>();

        Arrays.stream(TeaType.values())
                    .forEach(type -> years.add(theMostPlenteousYear(teaPackages, type)));
        return years;
    }

    public List<TeaType> findTeaTypesHarvestedIn2018(Collection<TeaPackage> teaPackages) {
        List<TeaType> teaTypes = new ArrayList<>();

        teaPackages.stream()
                    .filter(x -> !teaTypes.contains(x.getTeaType()) && x.getHarvestingYear() == 2018)
                    .forEach(x -> teaTypes.add(x.getTeaType()));
        return teaTypes;
    }

    public List<Integer> findMaxWeightForEachTeaType(Collection<TeaPackage> teaPackages) {
        List<TeaType> teaTypes = Arrays.stream(TeaType.values()).toList();

        return teaTypes.stream()
                .map(x -> teaPackages.stream()
                .filter(i -> i.getTeaType().getTitle().equals(x.getTitle()))
                .map(TeaPackage::getWeight)
                .max(Integer::compare)
                .orElse(0)).collect(Collectors.toList());
    }

    private Integer theMostPlenteousYear(Collection<TeaPackage> teaPackages, TeaType teaType) {
        Map<Integer, Integer> weightSumInEachYear = new HashMap<>();
        Integer year = 0;

        teaPackages
                .forEach((teaPackage)->{
                    if (teaPackage.getTeaType().getTitle().equals(teaType.getTitle())) {
                        if (weightSumInEachYear.containsKey(teaPackage.getHarvestingYear())) {
                            weightSumInEachYear.compute(teaPackage.getHarvestingYear(),
                                    (key, value) -> value += teaPackage.getWeight());
                        } else {
                            weightSumInEachYear.compute(teaPackage.getHarvestingYear(),
                                    (key, value) -> teaPackage.getWeight());
                        }
                    }
                });

        int maxWeight = weightSumInEachYear.values().stream().max(Integer::compare).orElse(0);
        var keys = weightSumInEachYear.keySet();

        for (Integer key : keys) {
            if (weightSumInEachYear.get(key).equals(maxWeight)) {
                year = key;
            }
        }
        return year;
    }
}