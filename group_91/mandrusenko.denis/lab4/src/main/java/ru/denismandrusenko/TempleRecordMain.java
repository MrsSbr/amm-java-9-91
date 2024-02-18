package ru.denismandrusenko;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TempleRecordMain {
    private static final Logger logger = Logger.getLogger(TempleRecordMain.class.getSimpleName());
    private static final Path PATH = Paths.get("src/main/resources/temples.txt");
    public static void main(String[] args) {
        try {
            List<TempleRecord> temples = TempleRecordReader.read(PATH);
            TempleRecordTask templeRecordTask = new TempleRecordTask(temples);

            List<String> donorsInAllTemples = templeRecordTask.findDonorsInAllTemples();
            System.out.println("Список людей, кто жертвовал во всех храмах: " + donorsInAllTemples);

            String mostWorshippedGod = templeRecordTask.findMostWorshippedGod();
            System.out.println("Бог, которому поклоняется наибольшее количество римлян: " + mostWorshippedGod);

            String templeWithLeastDonation = templeRecordTask.findTempleWithLeastDonation();
            System.out.println("Храм, которому пожертвовали наименьшую сумму: " + templeWithLeastDonation);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ошибка чтения файла: ", e.getMessage());
        }
    }
}