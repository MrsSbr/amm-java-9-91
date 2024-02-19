package org.courses;

public enum Specialization {
    THERAPIST("Терапевт"),
    GASTROENTEROLOGIST("Гастроэнтеролог"),
    CARDIOLOGIST("Кардиолог"),
    NEUROLOGIST("Невролог"),
    OPHTHALMOLOGIST("Офтальмолог"),
    DERMATOLOGIST("Дерматолог");

    private final String type;

    Specialization(String type) { this.type = type; }

    public static Specialization getSpecialization(String string) {
        for (Specialization specialization : Specialization.values()) {
            if (specialization.type.equals(string)) {
                return specialization;
            }
        }
        return null;
    }
}