import org.example.TextStatistics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextStatisticsTests {

    @Test
    public void testGetUniqueWords() {
        List<String> inputText = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape");
        TextStatistics textStatistics = new TextStatistics(ArrayList::new, inputText);

        List<String> uniqueWords = textStatistics.getUniqueWords();

        assertEquals(Arrays.asList("apple", "banana", "orange", "grape"), uniqueWords);
    }

    @Test
    public void testGetMostFrequentWords() {
        List<String> inputText = Arrays.asList("apple", "banana", "apple", "orange", "banana", "grape", "apple");
        TextStatistics textStatistics = new TextStatistics(ArrayList::new, inputText);

        Map<String, Long> mostFrequentWords = textStatistics.getMostFrequentWords();

        assertEquals(4, mostFrequentWords.size());
        assertEquals(3, mostFrequentWords.get("apple"));
        assertEquals(2, mostFrequentWords.get("banana"));
        assertEquals(1, mostFrequentWords.get("orange"));
        assertEquals(1, mostFrequentWords.get("grape"));
    }

    @Test
    public void testCountWordsContaining() {
        List<String> inputText = Arrays.asList("apple", "banana", "orange", "grape");
        TextStatistics textStatistics = new TextStatistics(ArrayList::new, inputText);

        long count = textStatistics.countWordsContaining("an");

        assertEquals(2, count);
    }

    @Test
    public void testGetMostFrequentWordsWithEmptyText() {
        TextStatistics textStatistics = new TextStatistics(ArrayList::new, new ArrayList<>());

        Map<String, Long> mostFrequentWords = textStatistics.getMostFrequentWords();
        assertNotNull(mostFrequentWords);
        assertTrue(mostFrequentWords.isEmpty());
    }

    @Test
    public void testCountWordsContainingWithNonexistentQuery() {
        List<String> inputText = Arrays.asList("apple", "banana", "orange", "grape");
        TextStatistics textStatistics = new TextStatistics(ArrayList::new, inputText);

        long count = textStatistics.countWordsContaining("watermelon");
        assertEquals(0, count);
    }
}
