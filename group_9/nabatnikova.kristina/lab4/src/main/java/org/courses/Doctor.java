package org.courses;

public enum Doctor {
    IVANOVA("Иванова Елена Михайловна"),
    PETROV("Петров Петр Петрович"),
    KIRILLOV("Кириллов Максим Денисович"),
    AFANASEFA("Афанасьева Людмила Викторовна"),
    SOKOLOVA("Соколова Наталья Сергеевна"),
    ZYEVA("Зуева Анна Александровна"),
    LAPINA("Лапина Валерия Леонидовна"),
    SIDOROV("Сидоров Сергей Павлович"),
    SEMENOV("Семенов Виктор Алексеевич");

    private final String name;

    Doctor(String doctor) { this.name = doctor; }

    public static Doctor getDoctor(String string) {
        for (Doctor doctor : Doctor.values()) {
            if (doctor.name.equals(string)) {
                return doctor;
            }
        }
        return null;
    }
}