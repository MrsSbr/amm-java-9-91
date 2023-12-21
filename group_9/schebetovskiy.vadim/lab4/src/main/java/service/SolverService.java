package service;

import entities.Drinks;
import entities.PreparedDrinkAccounting;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface SolverService {

    // Для каждого напитка узнать среднее время приготовления
    Map<String, Double> getAvgTimeOfPrepForEachDrink(final List<PreparedDrinkAccounting> list);

    // Найти самый загруженный час по будням
    Optional<Integer> getTheBusiestHourOnRoutineDays(final List<PreparedDrinkAccounting> list);

    // Найти напитки, которые чаще всего заказывают с 7 до 12 утра
    List<String> getMostOftenOrderedDrinksByCond(final List<PreparedDrinkAccounting> list);

    // Найти напиток с наилучшим соотношением цена/время
    Optional<String> getDrinkWithTheBestRatio(final List<PreparedDrinkAccounting> list);
}
