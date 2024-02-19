package org.courses;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentStatisticsTest {
    private final List<Appointment> appointments = List.of(
            new Appointment(LocalDate.of(2023, 11, 22), Doctor.IVANOVA,  Specialization.THERAPIST, "Куропаткин Иван", 1500),
            new Appointment(LocalDate.of(2024, 2, 12), Doctor.PETROV,  Specialization.GASTROENTEROLOGIST, "Куропаткин Иван", 2900),
            new Appointment(LocalDate.of(2023, 8, 22), Doctor.KIRILLOV,  Specialization.CARDIOLOGIST, "Куропаткин Иван", 2700),
            new Appointment(LocalDate.of(2024, 1, 15), Doctor.AFANASEFA,  Specialization.NEUROLOGIST, "Куропаткин Иван", 2200),
            new Appointment(LocalDate.of(2024, 1, 10), Doctor.SOKOLOVA,  Specialization.OPHTHALMOLOGIST, "Куропаткин Иван", 2200),
            new Appointment(LocalDate.of(2023, 8, 7), Doctor.ZYEVA,  Specialization.DERMATOLOGIST, "Куропаткин Иван", 2000),
            new Appointment(LocalDate.of(2022, 7, 7), Doctor.LAPINA,  Specialization.NEUROLOGIST, "Куропаткин Иван", 2600),
            new Appointment(LocalDate.of(2023, 7, 6), Doctor.SIDOROV,  Specialization.THERAPIST, "Куропаткин Иван", 1300),
            new Appointment(LocalDate.of(2023, 2, 7), Doctor.SEMENOV,  Specialization.CARDIOLOGIST, "Куропаткин Иван", 1800),
            new Appointment(LocalDate.of(2024, 1, 15), Doctor.AFANASEFA, Specialization.NEUROLOGIST, "Кузнецов Владимир", 2200),
            new Appointment(LocalDate.of(2022, 9, 15), Doctor.AFANASEFA, Specialization.NEUROLOGIST, "Кузнецов Владимир", 2200),
            new Appointment(LocalDate.of(2022, 6, 17), Doctor.PETROV, Specialization.OPHTHALMOLOGIST, "Снегирев Павел", 2500),
            new Appointment(LocalDate.of(2022, 8, 20), Doctor.PETROV, Specialization.OPHTHALMOLOGIST, "Артемова Анастасия", 2300),
            new Appointment(LocalDate.of(2023, 10, 27), Doctor.PETROV, Specialization.OPHTHALMOLOGIST, "Маркова Виктория", 2400)
    );

    private AppointmentStatistics statistics = new AppointmentStatistics();

    @Test
    void revenueBySpecialization() {
        assertEquals(Map.of(Specialization.THERAPIST, 2800,
                Specialization.GASTROENTEROLOGIST, 2900,
                Specialization.CARDIOLOGIST, 2700,
                Specialization.NEUROLOGIST, 4400,
                Specialization.DERMATOLOGIST, 2000,
                Specialization.OPHTHALMOLOGIST, 4600), statistics.revenueBySpecialization(appointments));
    }

    @Test
    void revenueBySpecializationEmptyList() {
        assertEquals(new HashMap<>(), statistics.revenueBySpecialization(new ArrayList<>()));
    }

    @Test
    void patientsOfAllDoctors() {
        assertEquals(List.of("Куропаткин Иван"), statistics.patientsOfAllDoctors(appointments));
    }

    @Test
    void patientsOfAllDoctorsEmptyList() {
        assertEquals(new ArrayList<>(), statistics.patientsOfAllDoctors(new ArrayList<>()));
    }

    @Test
    void patientsFromLastYear() {
        assertEquals(Map.of(Doctor.IVANOVA, new HashSet<String>(),
                Doctor.PETROV, new HashSet<String>(List.of("Снегирев Павел", "Артемова Анастасия")),
                Doctor.SOKOLOVA, new HashSet<String>(),
                Doctor.KIRILLOV, new HashSet<String>(),
                Doctor.AFANASEFA, new HashSet<String>(),
                Doctor.ZYEVA, new HashSet<String>(),
                Doctor.LAPINA, new HashSet<String>(List.of("Куропаткин Иван")),
                Doctor.SIDOROV, new HashSet<String>(),
                Doctor.SEMENOV, new HashSet<String>(List.of("Куропаткин Иван"))), statistics.patientsFromLastYear(appointments));
    }

    @Test
    void patientsFromLastYearEmptyList() {
        assertEquals(new HashMap<>(), statistics.patientsFromLastYear(new ArrayList<>()));
    }
}