package org.example;

import java.util.List;
import java.util.Scanner;

public class TribeMain {
    public static void main(String[] args) {
        Tribe tribe = new Tribe();
        List<Hunt> huntsLinked = tribe.createHuntsListLinled();

        List<Hunt> hunts = tribe.createHuntsList();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате ГГГГ ММ ДД: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        System.out.println("Имена охотников, которые добывали мясо:");
        List<String> hunters = tribe.getHunters(hunts);
        hunters.forEach(System.out::println);
        System.out.println("Общее количество мяса за 3 года от указанной даты: " + tribe.getTotalWeight(hunts, year, month, day));
        System.out.println("Сколько мяса добыл каждый охотник:");
        List<String> hunterWeights = tribe.getHunterWeights(hunts);
        hunterWeights.forEach(System.out::println);
    }
}
