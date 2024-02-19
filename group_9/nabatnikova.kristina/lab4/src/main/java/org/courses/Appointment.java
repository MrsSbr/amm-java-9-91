package org.courses;

import java.time.LocalDate;
import java.util.Objects;

public class Appointment {
    private final LocalDate dateOfAppointment;
    private final Doctor doctor;
    private final Specialization specialization;
    private final String patient;
    private final int price;


    public Appointment(LocalDate dateOfAppointment, Doctor doctor, Specialization specialization, String patient, int price) {
        this.dateOfAppointment = dateOfAppointment;
        this.doctor = doctor;
        this.specialization = specialization;
        this.patient = patient;
        this.price = price;
    }


    public LocalDate getDateOfAppointment() { return dateOfAppointment; }


    public Doctor getDoctor() { return doctor; }


    public Specialization getSpecialization() { return specialization; }


    public String getPatient() { return patient; }


    public int getPrice() { return price; }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Appointment that = (Appointment) object;

        if (!Objects.equals(dateOfAppointment, that.dateOfAppointment)) return false;
        if (doctor != that.doctor) return false;
        if (specialization != that.specialization) return false;
        if (!Objects.equals(patient, that.patient)) return false;
        return price == that.price;
    }


    @Override
    public int hashCode() {
        int result = dateOfAppointment != null ? dateOfAppointment.hashCode() : 0;
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                ", dateOfAppointment=" + dateOfAppointment +
                ", doctor=" + doctor +
                ", specialization=" + specialization +
                ", patient=" + patient +
                ", price" + price +
                "}";
    }
}