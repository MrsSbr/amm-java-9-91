package accounting;

import common.FileProvider;
import exceptions.InvalidDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AccountingTest {
    private final Accounting accounting = new Accounting();

    @BeforeEach
    void setUp() {
        List<SalaryRecord> records = List.of(
                new SalaryRecord("IT", "John Doe", 50000),
                new SalaryRecord("HR", "Jane Smith", 60000),
                new SalaryRecord("Finance", "Bob Johnson", 70000),
                new SalaryRecord("IT", "Alice Johnson", 55000),
                new SalaryRecord("Sales", "Michael Brown", 62000),
                new SalaryRecord("IT", "Emily Davis", 68000),
                new SalaryRecord("Legal", "David Miller", 75000),
                new SalaryRecord("Sales", "Samantha Wilson", 58000)
        );
        accounting.setSalaryRecords(records);
    }

    @Test
    void groupTheRecordsByDepartmentsTest() throws InvalidDataException {
        Map<String, List<SalaryRecord>> result = accounting.groupTheRecordsByDepartments();

        assertEquals(5, result.size());
        assertTrue(result.containsKey("IT"));
        assertTrue(result.containsKey("HR"));
        assertTrue(result.containsKey("Finance"));
        assertTrue(result.containsKey("Sales"));
        assertTrue(result.containsKey("Legal"));
        assertEquals(3, result.get("IT").size());
        assertEquals(1, result.get("HR").size());
        assertEquals(1, result.get("Finance").size());
        assertEquals(2, result.get("Sales").size());
        assertEquals(1, result.get("Legal").size());
    }

    @Test
    void findDepartmentWithHighestAverageSalaryTest() throws InvalidDataException {
        String result = accounting.findDepartmentWithHighestAverageSalary();
        assertEquals("Legal", result);
    }

    @Test
    void findDepartmentWithHighestTotalPayoutTest() throws InvalidDataException {
        String result = accounting.findDepartmentWithHighestTotalPayout();
        assertEquals("IT", result);
    }

    @Test
    void groupTheRecordsByDepartmentsWithEmptyListTest() throws InvalidDataException {
        accounting.setSalaryRecords(new ArrayList<>());
        assertTrue(accounting.groupTheRecordsByDepartments().isEmpty());
    }

    @Test
    void groupTheRecordsByDepartmentsWithNullListTest() {
        accounting.setSalaryRecords(null);
        assertThrows(NullPointerException.class, accounting::groupTheRecordsByDepartments);
    }

    @Test
    void findDepartmentWithHighestAverageSalaryWithEmptyListTest() throws InvalidDataException {
        accounting.setSalaryRecords(new ArrayList<>());
        assertNull(accounting.findDepartmentWithHighestAverageSalary());
    }

    @Test
    void findDepartmentWithHighestAverageSalaryWithNullListTest() {
        accounting.setSalaryRecords(null);
        assertThrows(NullPointerException.class, accounting::findDepartmentWithHighestAverageSalary);
    }

    @Test
    void findDepartmentWithHighestTotalPayoutWithEmptyListTest() throws InvalidDataException {
        accounting.setSalaryRecords(new ArrayList<>());
        assertNull(accounting.findDepartmentWithHighestTotalPayout());
    }

    @Test
    void findDepartmentWithHighestTotalPayoutWithNullListTest() {
        accounting.setSalaryRecords(null);
        assertThrows(NullPointerException.class, accounting::findDepartmentWithHighestTotalPayout);
    }
}