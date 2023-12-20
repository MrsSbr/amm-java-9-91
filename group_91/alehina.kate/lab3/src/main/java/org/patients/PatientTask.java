package org.patients;

import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Supplier;
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
        LocalDate lastTreeYear = LocalDate.now().minusYears(3);
        return patients.stream()
                .filter(patient -> patient.getDate().isAfter(lastTreeYear))
                .toList();
    }

    // Список людей, которые проходили обследование последние 5 лет, но не проходили последние 2 года
    public List<Patient> lastFiveNotLastTwoPatients() {
        LocalDate lastTwoYear = LocalDate.now().minusYears(2);
        LocalDate lastFiveYear = LocalDate.now().minusYears(5);
        return patients.stream()
                .filter(patient -> patient.getDate().isBefore(lastTwoYear) &&
                        patient.getDate().isAfter(lastFiveYear))
                .toList();
    }
}
