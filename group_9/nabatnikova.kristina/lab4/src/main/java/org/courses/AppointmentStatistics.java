package org.courses;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AppointmentStatistics {

    //1. Для каждой специализации найти сумму дохода за последний год.
    public Map<Specialization,Integer> revenueBySpecialization(List<Appointment> appointments) {
        Map<Specialization,Integer> revenue = new HashMap<>();

        LocalDate date = LocalDate.now().minusYears(1);

        appointments.stream()
                .filter(appointment -> appointment.getDateOfAppointment().isAfter(date))
                .forEach(appointment -> revenue.merge(appointment.getSpecialization(), appointment.getPrice(), Integer::sum));
        return revenue;
    }


    //2. Найти пациентов, которые были у всех врачей.
    public List<String> patientsOfAllDoctors(List<Appointment> appointments) {
        int numberOfDoctors = Doctor.values().length;

        Map<String, Set<Doctor>> patients = appointments.stream()
                .collect(Collectors.groupingBy(Appointment::getPatient,
                        Collectors.mapping(Appointment::getDoctor, Collectors.toSet())));

        return patients.entrySet().stream()
                .filter(patient -> patient.getValue().size() == numberOfDoctors)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    //3. Для каждого врача найти всех пациентов, которые были на приеме в прошлом году, но не были в этом.
    public Map<Doctor, Set<String>> patientsFromLastYear(List<Appointment> appointments) {

        LocalDate currentYear = LocalDate.now().minusYears(1);
        LocalDate lastYear = LocalDate.now().minusYears(2);

        Map<Doctor, Set<String>> result = new HashMap<>();

        Map<Doctor, List<Appointment>> groupedByDoctor = appointments.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctor));

        for (Map.Entry<Doctor, List<Appointment>> entry : groupedByDoctor.entrySet()) {
            Doctor doctor = entry.getKey();
            Set<String> patientsLastYear = entry.getValue().stream()
                    .filter(appointment -> appointment.getDateOfAppointment().isAfter(lastYear)
                            && appointment.getDateOfAppointment().isBefore(currentYear))
                    .map(Appointment::getPatient)
                    .collect(Collectors.toSet());

            Set<String> patientsThisYear = entry.getValue().stream()
                    .filter(appointment -> appointment.getDateOfAppointment().isAfter(currentYear))
                    .map(Appointment::getPatient)
                    .collect(Collectors.toSet());

            Set<String> patientsNotVisitedThisYear = new HashSet<>(patientsLastYear);
            patientsNotVisitedThisYear.removeAll(patientsThisYear);

            result.put(doctor, patientsNotVisitedThisYear);
        }

        return result;
    }
}

