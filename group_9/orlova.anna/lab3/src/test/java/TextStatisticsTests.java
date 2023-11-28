import org.example.TextStatistics;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextStatisticsTests {
    public static final List<String> inputText1 = List.of("apple", "banana", "apple", "orange", "banana", "grape");
    public static final List<String> inputText2 = List.of("apple", "banana", "orange", "grape");
    @Test
    public void testGetUniqueWords() {
        TextStatistics textStatistics = new TextStatistics(inputText1);

        List<String> uniqueWords = textStatistics.getUniqueWords();

        assertEquals(inputText2, uniqueWords);
    }

    @Test
    public void testGetMostFrequentWords() {
        TextStatistics textStatistics = new TextStatistics(inputText1);

        Map<String, Long> mostFrequentWords = textStatistics.getMostFrequentWords();

        assertEquals(4, mostFrequentWords.size());
        assertEquals(2, mostFrequentWords.get("apple"));
        assertEquals(2, mostFrequentWords.get("banana"));
        assertEquals(1, mostFrequentWords.get("orange"));
        assertEquals(1, mostFrequentWords.get("grape"));
    }

    @Test
    public void testCountWordsContaining() {
        TextStatistics textStatistics = new TextStatistics(inputText2);

        long count = textStatistics.countWordsContaining("an");

        assertEquals(2, count);
    }

    @Test
    public void testGetMostFrequentWordsWithEmptyText() {
        TextStatistics textStatistics = new TextStatistics(new ArrayList<>());

        Map<String, Long> mostFrequentWords = textStatistics.getMostFrequentWords();
        assertNotNull(mostFrequentWords);
        assertTrue(mostFrequentWords.isEmpty());
    }

    @Test
    public void testCountWordsContainingWithNonexistentQuery() {
        TextStatistics textStatistics = new TextStatistics(inputText2);

        long count = textStatistics.countWordsContaining("watermelon");
        assertEquals(0, count);
    }
}
