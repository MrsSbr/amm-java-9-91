package org.example.service;

import  org.example.model.MilkRecord;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class MilkRecordService {

  //    1. Найти лучший месяц по соотношению количество корма/количество молока
  public Month bestMonthForFeedCountToMilkCount(Collection<MilkRecord> records) {
    Map<LocalDate, Double> monthRatios = records.stream()
            .collect(Collectors.groupingBy(
                    record -> LocalDate.of(record.getDate().getYear(), record.getDate().getMonth(), 1),
                    Collectors.averagingDouble(record -> (double) record.getFeedCount() / record.getMilkCount())
            ));
    List<Map.Entry<LocalDate, Double>> sortedList = monthRatios.entrySet().stream()
            .sorted(Comparator.comparingDouble(Map.Entry::getValue))
            .toList();
    Month result = sortedList.get(0).getKey().getMonth();
    System.out.println("RESULT 'bestMonthForFeedCountToMilkCount': " + result);
    return result;
  }

  //    2. Сколько, в среднем, в неделю коровы дают молока
  public double averageWeeklyMilkCount(Collection<MilkRecord> records) {
    double result = records.stream()
            .collect(Collectors.groupingBy(
                    record -> record.getDate().with(DayOfWeek.MONDAY),
                    Collectors.averagingDouble(MilkRecord::getMilkCount)
            ))
            .values()
            .stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);
    System.out.println("RESULT 'averageWeeklyMilkCount': " + result);
    return result;
  }

  //    3. Суммарный объем съеденного корма
  public int eatenFeedCountSum(Collection<MilkRecord> records) {
    int result = records.stream()
            .map(MilkRecord::getFeedCount)
            .reduce(0, Integer::sum);
    System.out.println("RESULT 'eatenFeedCountSum': " + result);
    return result;
  }
}
