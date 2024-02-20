package org.example;

import java.util.List;
import java.util.Random;

public class CatExhibitionDemo {
    public static void main(String[] args) {
        CatExhibition exhibition = new CatExhibition();
        Random random = new Random();

        // Симуляция выставки и победителей
        for (int i = 0; i < 400; i++) {
            String name = "Cat" + i;
            String breed = "Breed" + (random.nextInt(4) + 1); // Случайная порода от 1 до 4
            String gender = random.nextBoolean() ? "Male" : "Female"; // Случайный пол

            Cat cat = new Cat(name, breed, gender);
            exhibition.addWinner(cat);
        }

        // Вывод статистики
        List<Cat> winners = exhibition.getWinners();

        // Подсчет соотношения котов и кошек
        long maleWinners = winners.stream().filter(cat -> cat.getGender().equals("Male")).count();
        long femaleWinners = winners.size() - maleWinners;
        System.out.println("Male winners: " + maleWinners);
        System.out.println("Female winners: " + femaleWinners);

        // Статистика побед по породам
        for (int i = 1; i <= 4; i++) {
            final int breedNumber = i;
            long breedWinners = winners.stream().filter(cat -> cat.getBreed().equals("Breed" + breedNumber)).count();
            System.out.println("Breed" + breedNumber + " winners: " + breedWinners);
        }

        // Список кошек, победивших хотя бы один раз
        System.out.println("List of cats who won at least once:");
        winners.stream()
                .map(Cat::getName)
                .distinct()
                .forEach(System.out::println);
    }
}
