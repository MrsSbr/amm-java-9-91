package service;

import entities.PreparedDrinkAccounting;
import localdatetime.LocalDateTimeUtil;

import java.util.*;
import java.util.stream.Collectors;

public class SolverServiceImpl implements SolverService {

    public static final int MIN_HOUR_BY_COND = 7;
    public static final int MAX_HOUR_BY_COND = 12;

    // Для каждого напитка, узнать среднее время приготовления
    @Override
    public Map<String, Double> getAvgTimeOfPrepForEachDrink(List<PreparedDrinkAccounting> list) {
        if (Objects.isNull(list)){
            throw new IllegalArgumentException("List can not be null");
        }
        return list.stream()
                .collect(Collectors.groupingBy(
                PreparedDrinkAccounting::getDrinkName,
                        Collectors.averagingInt(PreparedDrinkAccounting::getTimeOfPreparationInSeconds)
        ));
    }

    // Найти самый загруженный час по будням
    @Override
    public Optional<Integer> getTheBusiestHourOnRoutineDays(List<PreparedDrinkAccounting> list) {
        if (Objects.isNull(list)){
            throw new IllegalArgumentException("List can not be null");
        }
        return list.stream()
                .filter(entry -> LocalDateTimeUtil.isWorkday(entry.getDateOfPreparation()))
                .collect(Collectors.groupingBy(
                        entry -> entry.dateOfPreparation.getHour(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // Найти напитки, которые чаще всего заказывают с 7 до 12 утра
    @Override
    public List<String> getMostOftenOrderedDrinksByCond(List<PreparedDrinkAccounting> list) {
        if (Objects.isNull(list)){
            throw new IllegalArgumentException("List can not be null");
        }
        Map<String, Long> map = list.stream()
                .filter(entry -> LocalDateTimeUtil.isHourOfPrepByCond(entry.getDateOfPreparation(),
                        MIN_HOUR_BY_COND, MAX_HOUR_BY_COND))
                .collect(Collectors.groupingBy(
                        entry -> entry.drinkName,
                        Collectors.counting()
                ));
        Optional<Long> max = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue);
        if (max.isPresent()){
            return map.entrySet()
                    .stream()
                    .filter(entry -> Objects.equals(entry.getValue(), max.get()))
                    .map(Map.Entry::getKey)
                    .toList();
        }
        return List.of();
    }

    // Найти напиток с наилучшим соотношением цена/время
    @Override
    public Optional<String> getDrinkWithTheBestRatio(List<PreparedDrinkAccounting> list) {
        if (Objects.isNull(list)){
            throw new IllegalArgumentException("List can not be null");
        }
        return list.stream()
                .collect(Collectors.groupingBy(
                        PreparedDrinkAccounting::getDrinkName,
                        Collectors.averagingDouble(entry -> entry.price / entry.timeOfPreparationInSeconds)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}