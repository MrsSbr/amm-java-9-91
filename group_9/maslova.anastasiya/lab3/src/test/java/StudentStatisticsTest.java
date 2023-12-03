import org.example.StudentStatistics;
import org.example.ShowName;
import org.example.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StudentStatisticsTest {
    private List<Student> studentList;
    private StudentStatistics studentStatistics;

    @BeforeEach
    public void setup() {
        studentList = new ArrayList<>();
    }

    private void addStudentWithShows(Set<ShowName> showNames) {
        studentList.add(new Student(showNames));
    }

    private void initializeStatistics() {
        studentStatistics = new StudentStatistics(studentList);
    }

    @Test
    public void numberOfTicketsBooked() {
        addStudentWithShows(Set.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA));
        initializeStatistics();

        List<Integer> actual = studentStatistics.numberOfTicketsBookedForEachShow();
        List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void numberOfTicketsBookedWithEmptyList() {
        initializeStatistics();

        List<Integer> actual = studentStatistics.numberOfTicketsBookedForEachShow();
        List<Integer> expected = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void oneMostPopularShow() {
        addStudentWithShows(Set.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA));
        addStudentWithShows(Set.of(ShowName.SWAN_LAKE));
        initializeStatistics();

        List<ShowName> actual = studentStatistics.theMostPopularShow();
        List<ShowName> expected = List.of(ShowName.SWAN_LAKE);
        assertEquals(expected, actual);
    }

    @Test
    public void MostPopularShowsWithEmptyList() {
        initializeStatistics();

        List<ShowName> actual = studentStatistics.theMostPopularShow();
        List<ShowName> expected = List.of(ShowName.values());
        assertEquals(expected, actual);
    }

    @Test
    public void severalMostPopularShow() {
        addStudentWithShows(Set.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA));
        addStudentWithShows(Set.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA));

        List<ShowName> actual = studentStatistics.theMostPopularShow();
        List<ShowName> expected = List.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA);
        assertEquals(expected, actual);
    }

    @Test
    public void oneShowForWhichPurchasedTickets() {
        addStudentWithShows(Set.of(ShowName.CARMEN));
        initializeStatistics();

        List<ShowName> actual = studentStatistics.showForWhichPurchasedTickets();
        List<ShowName> expected = List.of(ShowName.CARMEN);
        assertEquals(expected, actual);
    }

    @Test
    public void severalShowForWhichPurchasedTickets() {
        addStudentWithShows(Set.of(ShowName.CARMEN, ShowName.ROMEO_AND_JULIET));
        initializeStatistics();

        List<ShowName> actual = studentStatistics.showForWhichPurchasedTickets().stream().sorted().toList();
        List<ShowName> expected = Stream.of(ShowName.CARMEN, ShowName.ROMEO_AND_JULIET).sorted().toList();
        assertEquals(expected, actual);
    }

    @Test
    public void ShowsForWhichPurchasedTicketsWithEmptyList() {
        initializeStatistics();

        List<ShowName> actual = studentStatistics.showForWhichPurchasedTickets();
        List<ShowName> expected = new ArrayList<>();
        assertEquals(expected, actual);
    }

    @Test
    public void invalidShowName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            addStudentWithShows(Set.of(ShowName.SWAN_LAKE, ShowName.valueOf("INVALID_SHOW")));
        });
        initializeStatistics();


        String expectedMessage = "No enum constant";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void testMaximumTicketsBoundaryCondition() {
        Set<ShowName> allShows = new HashSet<>(Arrays.asList(ShowName.values()));
        Student studentWithAllShows = new Student(allShows);

        studentStatistics = new StudentStatistics(List.of(studentWithAllShows));

        List<Integer> tickets = studentStatistics.numberOfTicketsBookedForEachShow();
        for (int numberOfTickets : tickets) {
            assertEquals(1, numberOfTickets, "Ожидается 1 билет для каждого спектакля");
        }
    }

    @Test
    public void testAddingDuplicateShowsShouldNotIncreaseTicketCount() {
        Set<ShowName> duplicateShows = Stream.generate(() -> ShowName.SWAN_LAKE)
                .limit(5)
                .collect(Collectors.toSet());
        Student studentWithDuplicateShows = new Student(duplicateShows);

        studentStatistics = new StudentStatistics(List.of(studentWithDuplicateShows));

        List<Integer> tickets = studentStatistics.numberOfTicketsBookedForEachShow();
        assertEquals(1, (int) tickets.get(ShowName.SWAN_LAKE.ordinal()), "Ожидаемый 1 билет на SWAN_LAKE, несмотря на дубликаты");
    }

    @Test
    public void testRandomAddStudentsShouldAddCorrectNumberOfStudents() {
        Collection<Student> students = StudentStatistics.randomAddStudents(ArrayList::new);
        assertEquals(StudentStatistics.TOTAL_STUDENTS, students.size());
    }
}