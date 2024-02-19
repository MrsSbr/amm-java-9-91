package org.courses;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public List<Appointment> readAppointmentRecordsFromFile(Path path) {
        List<Appointment> appointments;

        File file = new File(path.toString());
        if (file.exists() && file.length() == 0) {
            logger.info("Файл пустой");
            return Collections.emptyList();
        }

        try (Stream<String> fileStream = Files.lines(path)){
            appointments = fileStream
                    .map(line -> line.split(";"))
                    .map(fields -> {
                        LocalDate dateOfAppointment = LocalDate.parse(fields[0]);
                        Doctor doctor = Doctor.getDoctor(fields[1]);
                        Specialization specialization = Specialization.getSpecialization(fields[2]);
                        String patient = fields[3];
                        int price = Integer.parseInt(fields[4]);
                        return new Appointment(dateOfAppointment, doctor, specialization, patient, price);
                    }).toList();
        } catch (IOException exception) {
            logger.info("Ошибка чтения файла -> " + exception.getMessage());
            throw new RuntimeException();
        }
        return appointments;

    }
}