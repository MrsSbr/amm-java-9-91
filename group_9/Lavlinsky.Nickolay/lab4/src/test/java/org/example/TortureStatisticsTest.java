package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.*;

public class TortureStatisticsTest {
    private final TortureStatistics tortureStatistics = new TortureStatistics();

    @Test
    public void testWithEmptyList() {
        List<StudentRecord> records = new ArrayList<>();
        assertTrue(tortureStatistics.countResitsByTool(records).isEmpty());
        assertTrue(tortureStatistics.calculateTotalTortureTime(records).isEmpty());
        assertTrue(tortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());
    }

    @Test
    public void testWithSingleRecord() {
        List<StudentRecord> records = Collections.singletonList(
                new StudentRecord("Иван", TortureTool.JAVA_CODE_CONVENTION, 30, false)
        );
        assertEquals(0, tortureStatistics.countResitsByTool(records).size());
        assertEquals(30, tortureStatistics.calculateTotalTortureTime(records).get("Иван"));
        assertTrue(tortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());
    }

    @Test
    public void testWithMultipleRecords() {
        List<StudentRecord> records = Arrays.asList(
                new StudentRecord("Иван", TortureTool.JAVA_CODE_CONVENTION, 30, true),
                new StudentRecord("Мария", TortureTool.GITHUB_BUG, 45, false),
                new StudentRecord("Иван", TortureTool.CODE_ERROR, 60, false)
        );
        assertEquals(1, tortureStatistics.countResitsByTool(records).size());
        assertEquals(90, tortureStatistics.calculateTotalTortureTime(records).get("Иван"));
        assertEquals(45, tortureStatistics.calculateTotalTortureTime(records).get("Мария"));
        assertTrue(tortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());
    }

    @Test
    public void testAllResitAndNoResitScenarios() {
        List<StudentRecord> records = Arrays.asList(
                new StudentRecord("Иван", TortureTool.JAVA_CODE_CONVENTION, 30, true),
                new StudentRecord("Мария", TortureTool.GITHUB_BUG, 45, true)
        );
        assertEquals(2, tortureStatistics.countResitsByTool(records).size());
        assertTrue(tortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());

        records = Arrays.asList(
                new StudentRecord("Иван", TortureTool.JAVA_CODE_CONVENTION, 30, false),
                new StudentRecord("Мария", TortureTool.GITHUB_BUG, 45, false)
        );
        assertTrue(tortureStatistics.countResitsByTool(records).isEmpty());
        assertTrue(tortureStatistics.studentsTorturedByAllToolsAndPassed(records).isEmpty());
    }

    @Test
    public void testStudentsTorturedByAllToolsAndPassed() {
        List<StudentRecord> records = new ArrayList<>();
        for (TortureTool tool : TortureTool.values()) {
            records.add(new StudentRecord("Иван", tool, 30, false));
        }
        List<String> passedStudents = tortureStatistics.studentsTorturedByAllToolsAndPassed(records);
        assertEquals(1, passedStudents.size());
        assertTrue(passedStudents.contains("Иван"));
    }
}
