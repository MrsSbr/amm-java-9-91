package org.patients;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class PatientTaskTest {
    private final List<Patient> people = List.of(
            new Patient("Алексеев", "Алексей", "Алексеевич",
                    FluorogramResult.NOT_DETECTED, LocalDate.of(2013, 9, 13)),
            new Patient("Александров", "Александр", "Александрович",
                    FluorogramResult.DETECTED, LocalDate.of(2018, 5, 9)),
            new Patient("Петров", "Петр", "Петрович",
                    FluorogramResult.NOT_DETECTED, LocalDate.of(2010, 12, 13)),
            new Patient("Дмитриев", "Дмитрий", "Дмитриев",
                    FluorogramResult.ADDITIONAL_EXAMINATION, LocalDate.of(2013, 1, 3)),
            new Patient("Иванов", "Иван", "Иванович",
                    FluorogramResult.DETECTED, LocalDate.of(2015, 6, 15)),
            new Patient("Михайлов", "Михаил", "Михайлович",
                    FluorogramResult.ADDITIONAL_EXAMINATION, LocalDate.of(2003, 6, 6)),
            new Patient("Сомов", "Николай", "Алексеевич",
                    FluorogramResult.NOT_DETECTED, LocalDate.of(2012, 8, 20)),
            new Patient("Дмитриев", "Александр", "Николаевич",
                    FluorogramResult.NOT_DETECTED, LocalDate.of(2017, 1, 24)),
            new Patient("Зоц", "Елена", "Александровна",
                    FluorogramResult.NOT_DETECTED, LocalDate.of(2016, 5, 13)),
            new Patient("Старшова", "Мария", "Алексеевна",
                    FluorogramResult.DETECTED, LocalDate.of(2013, 7, 8)),
            new Patient("Тагаева", "Диана", "Артуровна",
                    FluorogramResult.NOT_DETECTED, LocalDate.of(2023, 12, 1)),
            new Patient("Воронцова", "Анастасия", "Ивановна",
                    FluorogramResult.NOT_DETECTED, LocalDate.of(2017, 2, 22)),
            new Patient("Солнцева", "Светлана", "Артуровна",
                    FluorogramResult.DETECTED, LocalDate.of(2016, 10, 28)),
            new Patient("Филатов", "Сергей", "Степанович",
                    FluorogramResult.ADDITIONAL_EXAMINATION, LocalDate.of(2019, 11, 11))
    );
    private final List<Patient> emptyPeople = List.of();
    private final List<Patient> peoplNoSuitable = List.of(
            new Patient("Солнцева", "Светлана", "Артуровна",
                    FluorogramResult.DETECTED, LocalDate.of(2016, 10, 28)));

    private final List<Supplier<Collection<Patient>>> listSuppliers = List.of(
            LinkedList::new,
            ArrayList::new,
            HashSet::new
    );

    @Test
    public void countHealthyPatients() {
        for(Supplier<Collection<Patient>> supplier : listSuppliers) {
            PatientTask task = new PatientTask(supplier, people);
            assertEquals(7, task.countHealthyPatients());
        }
    }

    @Test
    public void lastThreeYearsPatients() {
        for(Supplier<Collection<Patient>> supplier : listSuppliers) {
            PatientTask task = new PatientTask(supplier, people);
            assertEquals(List.of(
                    new Patient("Тагаева", "Диана", "Артуровна",
                            FluorogramResult.NOT_DETECTED, LocalDate.of(2023, 12, 1))
            ), task.lastThreeYearsPatients());
        }
    }

    @Test
    public void lastFiveNotLastTwoPatients() {
        for(Supplier<Collection<Patient>> supplier : listSuppliers) {
            PatientTask task = new PatientTask(supplier, people);
            assertEquals(List.of(
                    new Patient("Филатов", "Сергей", "Степанович",
                            FluorogramResult.ADDITIONAL_EXAMINATION, LocalDate.of(2019, 11, 11))
            ), task.lastFiveNotLastTwoPatients());
        }
    }

    @Test
    public void countHealthyPatientsEmptyCollection() {
        for (Supplier<Collection<Patient>> supplier : listSuppliers) {
            PatientTask task = new PatientTask(supplier, emptyPeople);
            assertEquals(0, task.countHealthyPatients());
        }
    }
    @Test
    public void lastThreeYearsEmptyCollection() {
        for(Supplier<Collection<Patient>> supplier : listSuppliers) {
            PatientTask task = new PatientTask(supplier, emptyPeople);
            assertEquals(List.of(), task.lastThreeYearsPatients());
        }
    }
    @Test
    public void lastFiveNotLastTwoPatientsEmptyCollection() {
        for(Supplier<Collection<Patient>> supplier : listSuppliers) {
            PatientTask task = new PatientTask(supplier, emptyPeople);
            assertEquals(List.of(), task.lastFiveNotLastTwoPatients());
        }
    }
    @Test
    public void countHealthyPatientsNoSuitable() {
        for (Supplier<Collection<Patient>> supplier : listSuppliers) {
            PatientTask task = new PatientTask(supplier, peoplNoSuitable);
            assertEquals(0, task.countHealthyPatients());
        }
    }
    @Test
    public void lastThreeYearsNoSuitable() {
        for(Supplier<Collection<Patient>> supplier : listSuppliers) {
            PatientTask task = new PatientTask(supplier, peoplNoSuitable);
            assertEquals(List.of(), task.lastThreeYearsPatients());
        }
    }
    @Test
    public void lastFiveNotLastTwoPatientsNoSuitable() {
        for(Supplier<Collection<Patient>> supplier : listSuppliers) {
            PatientTask task = new PatientTask(supplier, peoplNoSuitable);
            assertEquals(List.of(), task.lastFiveNotLastTwoPatients());
        }
    }
}