package org.courses;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    private static final Path EXISTING_FILE = Path.of("group_9/nabatnikova.kristina/lab4/src/main/resources/appointments.txt");
    private static final Path NONEXISTING_FILE = Path.of("group_9/nabatnikova.kristina/lab4/src/main/resources/test.txt");
    private static final Path EMPTY_FILE = Path.of("group_9/nabatnikova.kristina/lab4/src/main/resources/empty_appointments.txt");

    private static final FileReader fileReader = new FileReader();

    @Test
    void readFromFile() {
        List<Appointment> appointments = List.of(
                new Appointment(LocalDate.of(2023, 8, 7), Doctor.SOKOLOVA,  Specialization.OPHTHALMOLOGIST, "Куропаткин Иван", 1900),
                new Appointment(LocalDate.of(2024, 1, 15), Doctor.AFANASEFA, Specialization.NEUROLOGIST, "Кузнецов Владимир", 2200),
                new Appointment(LocalDate.of(2023, 6, 17), Doctor.PETROV, Specialization.GASTROENTEROLOGIST, "Снегирев Павел", 2500)
        );
        List<Appointment> appointmentList = fileReader.readAppointmentRecordsFromFile(EXISTING_FILE);
        assertEquals(appointments, appointmentList);
    }

    @Test
    void readFromNonExistingFile() {
        assertThrows(RuntimeException.class, () -> fileReader.readAppointmentRecordsFromFile(NONEXISTING_FILE));
    }

    @Test
    void readEmptyFile() {
        assertEquals(0, fileReader.readAppointmentRecordsFromFile(EMPTY_FILE).size());
    }

}