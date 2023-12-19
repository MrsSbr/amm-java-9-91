package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class TortureStatisticsTest {

    @Test
    public void testWithEmptyList() {
        List<StudentRecord> records = new ArrayList<>();
        assertTrue(TortureStatistics.countResitsByTool(records).isEmpty());
        assertTrue(TortureStatistics.calculateTotalTortureTime(records).isEmpty());
        assertTrue(TortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());
    }

    @Test
    public void testWithSingleRecord() {
        List<StudentRecord> records = Collections.singletonList(
                new StudentRecord("Иван", TortureTool.JAVA_CODE_CONVENTION, 30, false)
        );
        assertEquals(0, TortureStatistics.countResitsByTool(records).size());
        assertEquals(30, TortureStatistics.calculateTotalTortureTime(records).get("Иван"));
        assertTrue(TortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());
    }

    @Test
    public void testWithMultipleRecords() {
        List<StudentRecord> records = Arrays.asList(
                new StudentRecord("Иван", TortureTool.JAVA_CODE_CONVENTION, 30, true),
                new StudentRecord("Мария", TortureTool.GITHUB_BUG, 45, false),
                new StudentRecord("Иван", TortureTool.CODE_ERROR, 60, false)
        );
        assertEquals(1, TortureStatistics.countResitsByTool(records).size());
        assertEquals(90, TortureStatistics.calculateTotalTortureTime(records).get("Иван"));
        assertEquals(45, TortureStatistics.calculateTotalTortureTime(records).get("Мария"));
        assertTrue(TortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());
    }

    @Test
    public void testAllResitAndNoResitScenarios() {
        List<StudentRecord> records = Arrays.asList(
                new StudentRecord("Иван", TortureTool.JAVA_CODE_CONVENTION, 30, true),
                new StudentRecord("Мария", TortureTool.GITHUB_BUG, 45, true)
        );
        assertEquals(2, TortureStatistics.countResitsByTool(records).size());
        assertTrue(TortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());

        records = Arrays.asList(
                new StudentRecord("Иван", TortureTool.JAVA_CODE_CONVENTION, 30, false),
                new StudentRecord("Мария", TortureTool.GITHUB_BUG, 45, false)
        );
        assertTrue(TortureStatistics.countResitsByTool(records).isEmpty());
        assertTrue(TortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());
    }

    @Test
    public void testStudentsTorturedByAllToolsAndPassed() {
        List<StudentRecord> records = new ArrayList<>();
        for (TortureTool tool : TortureTool.values()) {
            records.add(new StudentRecord("Иван", tool, 30, false));
        }
        List<String> passedStudents = TortureStatistics.studentsTorturedByAllToolsAndPassed(records);
        assertEquals(1, passedStudents.size());
        assertTrue(passedStudents.contains("Иван"));
    }
}
