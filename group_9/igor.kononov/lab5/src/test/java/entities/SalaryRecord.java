package entities;

import lombok.Data;

@Data
public class SalaryRecord {
    private String department;
    private String fullName;
    private int salary;

    public SalaryRecord() {
    }

    public SalaryRecord(String department, String fullName, int salary) {
        this.department = department;
        this.fullName = fullName;
        this.salary = salary;
    }
}
