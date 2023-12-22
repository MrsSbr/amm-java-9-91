package org.example;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class TortureConsule {
    private static final TortureStatistics tortureStatistics = new TortureStatistics();
    private static final Logger logger = Logger.getLogger(TortureConsule.class.getName());

    public static void main(String[] args) {
        logger.info("Приложение начало работать");
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
                    logger.severe(e.getMessage());
                    System.out.println(e.getMessage());
                }
            }
            logger.info("Файл был считан");
        } catch (FileNotFoundException e) {
            System.out.println("Файл увы не найден: " + e.getMessage());
            logger.severe("Файл увы не найден: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            logger.severe("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        printStatistics(records);
        logger.info("Анализ успешно завершён");
    }

    private static void printStatistics(List<StudentRecord> records) {
        System.out.println("Количество пересдач по инструменту:");
        Map<TortureTool, Long> resitsByTool = tortureStatistics.countResitsByTool(records);
        resitsByTool.forEach((tool, count) -> System.out.println(tool.getDisplayName() + ": " + count));

        System.out.println("\nСуммарное время пыток каждого студента:");
        Map<String, Integer> totalTimeByStudent = tortureStatistics.calculateTotalTortureTime(records);
        totalTimeByStudent.forEach((name, time) -> System.out.println(name + ": " + time + " минут"));

        System.out.println("\nСтуденты, пытанные всеми инструментами и сдавшие лабораторную:");
        List<String> studentsPassedAll = tortureStatistics.studentsTorturedByAllToolsAndPassed(records);
        studentsPassedAll.forEach(System.out::println);
    }
}
