package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CultureDepartmentService {

    public static void printMainMenu() {
        System.out.println("\n\n1. Проверка работы");
        System.out.println("2. Ввод случайных чисел и сравнение коллекций");
        System.out.println("0. Выход");
    }

    private static void printSecondMenu() {
        System.out.println("\n1. Ввод с клавиатуры ");
        System.out.println("2. Случайное заполнение");
    }

    public static void testing() {
        List<Student> studentList = new ArrayList<>();
        addStudents(studentList); // заполнение студентами

        StudentStatistics studentStatistics = new StudentStatistics(studentList);

        System.out.println("Количество билетов, заказанных на каждый спектакль");
        List<Integer> numberOfTickets = studentStatistics.numberOfTicketsBookedForEachShow();
        IntStream.range(0, numberOfTickets.size())
                .mapToObj(i -> "Спектакль " + ShowName.values()[i].getShowTitle() + " кол-во билетов: " + numberOfTickets.get(i))
                .forEach(System.out::println);

        System.out.println("\nСамый популярный спектакль (следует учесть вариант, что может быть несколько таких спектаклей)");
        studentStatistics.theMostPopularShow()
                .stream()
                .map(showName -> showName.getShowTitle() + " ")
                .forEach(System.out::print);

        System.out.println("\n\nСпектакль (спектакли), на который решили приобрести билеты");
        studentStatistics.showForWhichPurchasedTickets()
                .stream()
                .map(showName -> showName.getShowTitle() + "; ")
                .forEach(System.out::print);
    }

    private static void addStudents(List<Student> studentList) {
        Scanner in = new Scanner(System.in);
        printSecondMenu();
        int choiceIn = Input.getIntInRange(1, 2);
        if (choiceIn == 1) {
            System.out.println("Добавление студентов");
            while (true) {
                Set<ShowName> showsForStudent = new HashSet<>(); // множества, чтобы не повторялись спектакли т.к. можно купить только 1 билет
                System.out.println("Доступые спектакли для добавления:\n" + Arrays.toString(ShowName.values()));
                System.out.println("Введите спектакли на которые пошёл ученик (\"конец\"  для конца ввода):");
                String str = in.nextLine();
                while (!str.equalsIgnoreCase("конец")) {
                    showsForStudent.add(ShowName.valueOf(str)); // добавление спектакля в множество
                    str = in.nextLine();
                }

                studentList.add(new Student(showsForStudent));// добавляем нового студента со списком спектаклей на которые он идёт

                System.out.println("Добавть ещё ученика?(да/нет)");
                String choice = in.nextLine();
                if (choice.equalsIgnoreCase("нет")) {
                    break;
                }
            }
        } else {
            randomAddStudents(studentList);
        }
    }

    public static void performanceTest() {
        compareOnArray();
        compareOnList();
    }

    private static void compareOnArray() {
        System.out.println("На массиве:");
        long startTime = System.currentTimeMillis();

        List<Student> studentList = new ArrayList<>();
        execute(startTime, studentList);
    }

    private static void compareOnList() {
        System.out.println("\nНа списке:");
        long startTime = System.currentTimeMillis();

        List<Student> studentList = new LinkedList<>();
        execute(startTime, studentList);
    }

    private static void execute(long startTime, List<Student> studentList) {
        randomAddStudents(studentList);
        long endCreating = System.currentTimeMillis();

        StudentStatistics studentStatistics = new StudentStatistics(studentList);

        studentStatistics.numberOfTicketsBookedForEachShow();
        studentStatistics.theMostPopularShow();
        studentStatistics.showForWhichPurchasedTickets();

        long endTime = System.currentTimeMillis();

        System.out.println("Время создания в миллисекундах: " + (endCreating - startTime));
        System.out.println("Время выполнения в миллисекундах: " + (endTime - endCreating));
    }


    private static void randomAddStudents(List<Student> studentList) {
        Random rand = new Random();
        int cntOfValues = ShowName.values().length;
        IntStream.range(0, StudentStatistics.TOTAL_STUDENTS)
                .mapToObj(i -> {
                    int numOfShows = rand.nextInt(1, cntOfValues);
                    Set<ShowName> showsForStudent = Stream
                            .generate(() -> ShowName.values()[rand.nextInt(0, cntOfValues)])
                            .distinct() // генерация уникальных спектаклей на котрые ученик купил билет
                            .limit(numOfShows)
                            .collect(Collectors.toSet());
                    return new Student(showsForStudent);
                })
                .forEach(studentList::add);
    }
}