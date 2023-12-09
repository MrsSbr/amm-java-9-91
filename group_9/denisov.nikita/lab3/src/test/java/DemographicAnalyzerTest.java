import org.junit.jupiter.api.Test;
import ru.nikitadenisov.lab3.analyzer.DemographicAnalyzer;
import ru.nikitadenisov.lab3.analyzer.Gender;
import ru.nikitadenisov.lab3.analyzer.Month;
import ru.nikitadenisov.lab3.analyzer.Student;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DemographicAnalyzerTest {
    @Test
    void testGetNumberStudents() {
        Collection<Student> students = Arrays.asList(
                new Student(Gender.MALE, Month.JANUARY),
                new Student(Gender.MALE, Month.MARCH),
                new Student(Gender.MALE, Month.MARCH),
                new Student(Gender.MALE, Month.APRIL),
                new Student(Gender.MALE, Month.SEPTEMBER),
                new Student(Gender.FEMALE, Month.JANUARY),
                new Student(Gender.FEMALE, Month.MARCH),
                new Student(Gender.FEMALE, Month.APRIL),
                new Student(Gender.FEMALE, Month.APRIL),
                new Student(Gender.FEMALE, Month.AUGUST),
                new Student(Gender.FEMALE, Month.AUGUST),
                new Student(Gender.FEMALE, Month.SEPTEMBER),
                new Student(Gender.FEMALE, Month.SEPTEMBER)
        );

        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(students);

        assertEquals(2, demographicAnalyzer.numberStudentsInMonth(Month.JANUARY));
        assertEquals(3, demographicAnalyzer.numberStudentsInMonth(Month.APRIL));
        assertEquals(0, demographicAnalyzer.numberStudentsInMonth(Month.OCTOBER));
    }

    @Test
    void testGetNumberStudentsWithEmptyCollection() {
        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(Collections.emptyList());

        assertEquals(0, demographicAnalyzer.numberStudentsInMonth(Month.OCTOBER));
    }

    @Test
    void testGetNumberStudentsWithNullCollection() {
        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(null);

        assertThrows(NullPointerException.class, () ->
                demographicAnalyzer.numberStudentsInMonth(Month.APRIL));
    }

    @Test
    void testMonthsWithMoreFemalesThanMales() {
        Collection<Student> students = Arrays.asList(
                new Student(Gender.MALE, Month.JANUARY),
                new Student(Gender.MALE, Month.MARCH),
                new Student(Gender.MALE, Month.MARCH),
                new Student(Gender.MALE, Month.APRIL),
                new Student(Gender.MALE, Month.SEPTEMBER),
                new Student(Gender.FEMALE, Month.JANUARY),
                new Student(Gender.FEMALE, Month.MARCH),
                new Student(Gender.FEMALE, Month.APRIL),
                new Student(Gender.FEMALE, Month.APRIL),
                new Student(Gender.FEMALE, Month.AUGUST),
                new Student(Gender.FEMALE, Month.AUGUST),
                new Student(Gender.FEMALE, Month.SEPTEMBER),
                new Student(Gender.FEMALE, Month.SEPTEMBER)
        );

        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(students);
        List<Month> result = demographicAnalyzer.monthsWithMoreFemalesThanMales();

        assertEquals(3, result.size());

        assertTrue(result.contains(Month.AUGUST));
        assertTrue(result.contains(Month.SEPTEMBER));
        assertTrue(result.contains(Month.APRIL));
    }

    @Test
    void testMonthsWithMoreFemalesThanMalesWithNoFemale() {
        Collection<Student> students = Arrays.asList(
                new Student(Gender.MALE, Month.JANUARY),
                new Student(Gender.MALE, Month.FEBRUARY),
                new Student(Gender.MALE, Month.MARCH)
        );

        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(students);
        List<Month> result = demographicAnalyzer.monthsWithMoreFemalesThanMales();

        assertTrue(result.isEmpty());
    }

    @Test
    void testMonthsWithMoreFemalesThanMalesWithEqualMonths() {
        Collection<Student> students = Arrays.asList(
                new Student(Gender.MALE, Month.JANUARY),
                new Student(Gender.MALE, Month.AUGUST),
                new Student(Gender.FEMALE, Month.JANUARY),
                new Student(Gender.FEMALE, Month.AUGUST)
        );

        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(students);
        List<Month> result = demographicAnalyzer.monthsWithMoreFemalesThanMales();

        assertTrue(result.isEmpty());
    }

    @Test
    void testMonthsWithMoreFemalesThanMalesWithEmptyCollection() {
        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(Collections.emptyList());
        List<Month> result = demographicAnalyzer.monthsWithMoreFemalesThanMales();

        assertTrue(result.isEmpty());
    }

    @Test
    void testMonthsWithMoreFemalesThanMalesWithNullCollection() {
        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(null);

        assertThrows(NullPointerException.class, demographicAnalyzer::monthsWithMoreFemalesThanMales);
    }
}
