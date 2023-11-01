import org.example.StudentStatistics;
import org.example.ShowName;
import org.example.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class StudentStatisticsTest {
    @Test
    public void numberOfTicketsBooked() {
        Set<ShowName> showNames = Set.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(showNames));
        StudentStatistics studentStatistics = new StudentStatistics(studentList);


        List<Integer> actual = studentStatistics.numberOfTicketsBookedForEachShow();
        List<Integer> expected = Arrays.asList(1, 0, 0, 0, 0, 0, 0, 0, 0, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void oneMostPopularShow() {
        Set<ShowName> showNames = Set.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(showNames));
        studentList.add(new Student(Set.of(ShowName.SWAN_LAKE)));
        StudentStatistics studentStatistics = new StudentStatistics(studentList);


        List<ShowName> actual = studentStatistics.theMostPopularShow();
        List<ShowName> expected = List.of(ShowName.SWAN_LAKE);
        assertEquals(expected, actual);
    }

    @Test
    public void severalMostPopularShow() {
        Set<ShowName> showNames = Set.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(showNames));
        studentList.add(new Student(Set.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA)));
        StudentStatistics studentStatistics = new StudentStatistics(studentList);


        List<ShowName> actual = studentStatistics.theMostPopularShow();
        List<ShowName> expected = List.of(ShowName.SWAN_LAKE, ShowName.ANNA_KARENINA);
        assertEquals(expected, actual);
    }

    @Test
    public void oneShowForWhichPurchasedTickets() {
        Set<ShowName> showNames = Set.of(ShowName.CARMEN);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(showNames));
        StudentStatistics studentStatistics = new StudentStatistics(studentList);


        List<ShowName> actual = studentStatistics.theMostPopularShow();
        List<ShowName> expected = List.of(ShowName.CARMEN);
        assertEquals(expected, actual);
    }

    @Test
    public void severalShowForWhichPurchasedTickets() {
        Set<ShowName> showNames = Set.of(ShowName.CARMEN, ShowName.ROMEO_AND_JULIET);
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(showNames));
        StudentStatistics studentStatistics = new StudentStatistics(studentList);


        List<ShowName> actual = studentStatistics.theMostPopularShow();
        List<ShowName> expected = List.of(ShowName.ROMEO_AND_JULIET, ShowName.CARMEN);
        assertEquals(expected, actual);
    }

}