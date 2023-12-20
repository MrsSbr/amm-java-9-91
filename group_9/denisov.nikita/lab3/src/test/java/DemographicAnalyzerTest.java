import org.junit.jupiter.api.Test;
import ru.nikitadenisov.analyzer.DemographicAnalyzer;
import ru.nikitadenisov.analyzer.Gender;
import ru.nikitadenisov.analyzer.Month;
import ru.nikitadenisov.analyzer.Student;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DemographicAnalyzerTest {
    private static final Collection<Student> STUDENTS = Arrays.asList(
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

    @Test
    void testGetNumberStudentsBornInMonth() {
        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(STUDENTS);

        List<List<Long>> counts = demographicAnalyzer.numberStudentsBornInMonths();

        assertEquals(1L, counts.get(Gender.MALE.ordinal()).get(Month.JANUARY.ordinal()));
        assertEquals(1L, counts.get(Gender.FEMALE.ordinal()).get(Month.MARCH.ordinal()));
    }

    @Test
    void testGetNumberStudentsBornInMonthWithEmptyCollection() {
        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(Collections.emptyList());

        List<List<Long>> counts = demographicAnalyzer.numberStudentsBornInMonths();

        // Идем сначала по списку мужчин, потом женщин.
        for (List<Long> gender : counts) {
            for (Long count : gender) {
                assertEquals(0L, count);
            }
        }
    }

    @Test
    void testGetNumberStudentsBornInMonthWithNullCollection() {
        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(null);

        assertThrows(NullPointerException.class, demographicAnalyzer::numberStudentsBornInMonths);
    }

    @Test
    void testMonthsWithMoreFemalesThanMales() {
        DemographicAnalyzer demographicAnalyzer = new DemographicAnalyzer(STUDENTS);
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
