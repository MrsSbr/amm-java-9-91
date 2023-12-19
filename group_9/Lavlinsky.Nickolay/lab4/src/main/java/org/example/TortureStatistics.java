package org.example;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TortureStatistics {

    // Метод для подсчета количества пересдач для каждого инструмента
    public static Map<TortureTool, Long> countResitsByTool(List<StudentRecord> records) {
        return records.stream()
                .filter(StudentRecord::isResit)
                .collect(Collectors.groupingBy(StudentRecord::getTortureTool, Collectors.counting()));
    }

    // Метод для вычисления суммарного времени пыток для каждого студента
    public static Map<String, Integer> calculateTotalTortureTime(List<StudentRecord> records) {
        return records.stream()
                .collect(Collectors.groupingBy(StudentRecord::getName,
                        Collectors.summingInt(StudentRecord::getDuration)));
    }

    // Метод для получения списка студентов, пытанных всеми инструментами и сдавших лабораторную
    public static List<String> studentsTorturedByAllToolsAndPassed(List<StudentRecord> records) {
        // Создаем набор всех инструментов из перечисления TortureTool
        Set<TortureTool> allTools = EnumSet.allOf(TortureTool.class);

        return records.stream()
                .filter(r -> !r.isResit())
                .collect(Collectors.groupingBy(StudentRecord::getName,
                        Collectors.mapping(StudentRecord::getTortureTool, Collectors.toSet())))
                .entrySet().stream()
                .filter(e -> e.getValue().containsAll(allTools))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}