package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudentStatistics {
    public static final int TOTAL_STUDENTS = 100000;
    private final Collection<Student> students;

    public StudentStatistics(Collection<Student> students) {
        this.students = students;
    }

    // количество билетов, заказанных на каждый спектакль;
    public List<Integer> numberOfTicketsBookedForEachShow() {
        // создаём список-счётчик для всех спектаклей
        List<Integer> numberOfTickets = new ArrayList<>(Collections.nCopies(ShowName.values().length, 0));

        students.stream()
                .flatMap(st -> st.getShowsName().stream()) // преобразуем поток студентов в поток спектаклей
                .forEach(show -> {
                    int index = Arrays.asList(ShowName.values())
                            .indexOf(show);
                    if (index != -1) {
                        numberOfTickets.set(index, numberOfTickets.get(index) + 1);
                    }
                });

        return numberOfTickets;
    }

    // самый популярный спектакль (следует учесть вариант, что может быть несколько таких спектаклей);
    public List<ShowName> theMostPopularShow() {
        List<Integer> numberOfTickets = numberOfTicketsBookedForEachShow();
        int max = Collections.max(numberOfTickets);

        return IntStream.range(0, numberOfTickets.size())
                .filter(i -> numberOfTickets.get(i) == max) // добавление в список спектаклей у которых максимальное кол-во билетов
                .mapToObj(i -> ShowName.values()[i]) // преобразуем поток индексов в поток спектакль
                .collect(Collectors.toList());
    }

    // спектакль (спектакли), на который решили приобрести билеты
    public List<ShowName> showForWhichPurchasedTickets() {
        List<Integer> numberOfTickets = numberOfTicketsBookedForEachShow();

        return IntStream.range(0, numberOfTickets.size())
                .filter(i -> numberOfTickets.get(i) > 0)// добавление в список спектаклей у которых куплен хоть 1 билет
                .mapToObj(i -> ShowName.values()[i]) // преобразуем поток индексов в поток спектакль
                .collect(Collectors.toList());
    }

    public static List<Student> addStudents() {
        List<Student> studentList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        printSecondMenu();
        int choiceIn = Input.getIntInRange(1, 2);
        if (choiceIn == 1) {
            System.out.println("Добавление студентов");
            while (true) {
                Set<ShowName> showsForStudent = new HashSet<>();// Множества, чтобы не повторялись спектакли т.к. можно купить только 1 билет
                System.out.println("Доступные спектакли для добавления:\n" + Arrays.toString(ShowName.values()));
                System.out.println("Введите спектакли на которые пошёл ученик (\"конец\"  для конца ввода):");
                String str = in.nextLine();
                while (!str.equalsIgnoreCase("конец")) {
                    showsForStudent.add(ShowName.valueOf(str));// добавление спектакля в множество
                    str = in.nextLine();
                }

                studentList.add(new Student(showsForStudent));// добавляем нового студента со списком спектаклей на которые он идёт

                System.out.println("Добавить ещё ученика?(да/нет)");
                String choice = in.nextLine();
                if (choice.equalsIgnoreCase("нет")) {
                    break;
                }
            }
        } else {
            studentList = (List<Student>) randomAddStudents(ArrayList::new);
        }
        return studentList;
    }

    private static void printSecondMenu() {
        System.out.println("\n\n1. Ввод с клавиатуры ");
        System.out.println("2. Случайное заполнение");
    }

    public static Collection<Student> randomAddStudents(Supplier<Collection<Student>> collectionFactory) {
        Collection<Student> studentCollection = collectionFactory.get();
        Random rand = new Random();
        int cntOfValues = ShowName.values().length;
        IntStream.range(0, StudentStatistics.TOTAL_STUDENTS)
                .mapToObj(i -> {
                    int numOfShows = rand.nextInt(1, cntOfValues);
                    Set<ShowName> showsForStudent = Stream
                            .generate(() -> ShowName.values()[rand.nextInt(0, cntOfValues)])
                            .distinct()// генерация уникальных спектаклей на которые ученик купил билет
                            .limit(numOfShows)
                            .collect(Collectors.toSet());
                    return new Student(showsForStudent);
                })
                .forEach(studentCollection::add);
        return studentCollection;
    }
}