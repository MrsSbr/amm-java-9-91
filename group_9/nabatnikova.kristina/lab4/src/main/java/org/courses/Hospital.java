package org.courses;

import java.nio.file.Path;
import java.util.List;

public class Hospital {
    private static final Path PATH = Path.of("group_9/nabatnikova.kristina/lab4/src/main/resources/appointment.txt");

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        List<Appointment> appointments = fileReader.readAppointmentRecordsFromFile(PATH);
        AppointmentStatistics statistics = new AppointmentStatistics();

        //1. Для каждой специализации найти сумму дохода за последний год.
        System.out.println("Сумма дохода за последний год по каждой специализации: \n"
                + statistics.revenueBySpecialization(appointments));


        //2. Найти пациентов, которые были у всех врачей.
        System.out.println("Пациенты, которые были у всех врачей: \n"
                + statistics.patientsOfAllDoctors(appointments));

        //3. Для каждого врача найти всех пациентов, которые были на приеме в прошлом году, но не были в этом.
        System.out.println("Пациенты, которые были на приеме в прошлом году, но не были в этом: \n"
                + statistics.patientsFromLastYear(appointments));
    }
}