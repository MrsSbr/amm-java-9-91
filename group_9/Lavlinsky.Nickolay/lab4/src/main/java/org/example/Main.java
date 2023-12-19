package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StudentRecord> records = new ArrayList<>();

        System.out.println("Введите путь к файлу со студентами:");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    StudentRecord record = StudentRecordParser.parseFromString(line);
                    records.add(record);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        printStatistics(records);
    }

    private static void printStatistics(List<StudentRecord> records) {
        System.out.println("Количество пересдач по инструменту:");
        Map<TortureTool, Long> resitsByTool = TortureStatistics.countResitsByTool(records);
        resitsByTool.forEach((tool, count) -> System.out.println(tool.getDisplayName() + ": " + count));

        System.out.println("\nСуммарное время пыток каждого студента:");
        Map<String, Integer> totalTimeByStudent = TortureStatistics.calculateTotalTortureTime(records);
        totalTimeByStudent.forEach((name, time) -> System.out.println(name + ": " + time + " минут"));

        System.out.println("\nСтуденты, пытанные всеми инструментами и сдавшие лабораторную:");
        List<String> studentsPassedAll = TortureStatistics.studentsTorturedByAllToolsAndPassed(records);
        studentsPassedAll.forEach(System.out::println);
    }
}
