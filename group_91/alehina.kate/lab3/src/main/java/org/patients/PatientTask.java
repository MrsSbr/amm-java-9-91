package org.patients;

import java.time.LocalDate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.List;

public class PatientTask {
    private final Collection<Patient> patients;

    public PatientTask(Supplier<Collection<Patient>> supplier, List<Patient> listPatients) {
        patients = supplier.get();
        patients.addAll(listPatients);
    }

    // Список здоровых людей
    public long countHealthyPatients() {
        return patients.stream()
                .filter(patient -> patient.getResult() == FluorogramResult.NOT_DETECTED)
                .count();
    }

    // Список людей, которые проходили обследование за последние 3 года
    public List<Patient> lastThreeYearsPatients() {
        return patients.stream()
                .filter(patient -> patient.getDate().isAfter(LocalDate.now().minusYears(3)))
                .collect(Collectors.toList());
    }

    // Список людей, которые проходили обследование последние 5 лет, но не проходили последние 2 года
    public List<Patient> lastFiveNotLastTwoPatients() {
        return patients.stream()
                .filter(patient -> patient.getDate().isBefore(LocalDate.now().minusYears(2)) &&
                        patient.getDate().isAfter(LocalDate.now().minusYears(5)))
                .collect(Collectors.toList());
    }
}
