package accounting;

import exceptions.InvalidDataException;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;


//1. Распечатать ведомости по отделам
//2. Найти отдел с самой высокой средней заработной платой
//3. Найти отдел с самой большой общей суммой выплаты

@Data
public class Accounting {
    private static final Logger logger = Logger.getLogger(Accounting.class.getName());
    private List<SalaryRecord> salaryRecords;

    public Accounting() {
    }

    public Accounting(List<SalaryRecord> salaryRecords) {
        this.salaryRecords = salaryRecords;
    }


    public Map<String, List<SalaryRecord>> groupTheRecordsByDepartments() throws InvalidDataException {
        logger.info("The method \"groupTheRecordsByDepartments\" has started working");

        if (salaryRecords.isEmpty()) {
            throw new InvalidDataException("List is empty");
        }

        return salaryRecords.stream()
                .collect(Collectors.groupingBy(
                        SalaryRecord::getDepartment
                ));
    }

    public String findDepartmentWithHighestAverageSalary() throws InvalidDataException {
        logger.info("The method \"findDepartmentWithHighestAverageSalary\" has started working");

        if (salaryRecords.isEmpty()) {
            throw new InvalidDataException("List is empty");
        }

        return salaryRecords.stream()
                .collect(Collectors.groupingBy(
                        SalaryRecord::getDepartment,
                        Collectors.averagingInt(SalaryRecord::getAmount)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(NullPointerException::new);
    }

    public String findDepartmentWithHighestTotalPayout() throws InvalidDataException {
        logger.info("The method \"findDepartmentWithHighestTotalPayout\" has started working");

        if (salaryRecords.isEmpty()) {
            throw new InvalidDataException("List is empty");
        }

        return salaryRecords.stream()
                .collect(Collectors.groupingBy(
                        SalaryRecord::getDepartment,
                        Collectors.summingInt(SalaryRecord::getAmount)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(NullPointerException::new);
    }
}