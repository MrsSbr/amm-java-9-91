package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MessageAnalyzerTest {

    private MessageAnalyzer analyzer;
    private List<Message> messages;
    private LocalDate fixedDate;

    @Before
    public void setUp() {
        // Set a fixed date for consistent testing
        fixedDate = LocalDate.of(2023, 1, 1);
        analyzer = new MessageAnalyzer();
    }

    @Test
    public void whenMessagesListIsEmpty_thenNoRecipientFound() {
        messages = Collections.emptyList();
        String result = analyzer.findRecipientOfLongestMessage(messages);
        Assert.assertEquals("No messages found", result);
    }

    @Test
    public void whenMessagesHaveNoEmotions_thenNoLeastUsedEmotionFound() {
        messages = Collections.singletonList(
                new Message(fixedDate, "Alice", "Just a regular message with no emotions.")
        );
        String result = analyzer.findLeastUsedEmotionPastYear(messages);
        Assert.assertEquals("No emotions found", result);
    }

    @Test
    public void whenMessagesAreOlderThanOneYear_thenNoLeastUsedEmotionFound() {
        messages = Collections.singletonList(
                new Message(fixedDate.minusYears(2), "Bob", "Old message with emotions :)")
        );
        String result = analyzer.findLeastUsedEmotionPastYear(messages);
        Assert.assertEquals("No emotions found", result);
    }

    @Test
    public void whenWordDoesNotExistInAnyMessage_thenNoDayOfWeekFound() {
        messages = Arrays.asList(
                new Message(fixedDate, "Charlie", "This message does not contain the word."),
                new Message(fixedDate.minusDays(1), "Diana", "Neither does this one.")
        );
        DayOfWeek result = analyzer.findDayOfWeekWithMostOccurrencesOfWord(messages, "nonexistentword");
        Assert.assertEquals(DayOfWeek.SATURDAY,result);
    }

    @Test
    public void whenWordOccursEquallyEveryDay_thenFirstDayOfWeekReturned() {
        messages = Arrays.asList(
                new Message(fixedDate.with(DayOfWeek.MONDAY), "Eve", "Message containing word."),
                new Message(fixedDate.with(DayOfWeek.TUESDAY), "Eve", "Message containing word.")
                // Add similar messages for the rest of the week
        );
        DayOfWeek result = analyzer.findDayOfWeekWithMostOccurrencesOfWord(messages, "word");
        Assert.assertEquals(DayOfWeek.MONDAY, result);
    }

    @Test
    public void whenSingleMessageInList_thenCorrectRecipientFound() {
        messages = Collections.singletonList(
                new Message(fixedDate, "Alice", "Short message")
        );
        String result = analyzer.findRecipientOfLongestMessage(messages);
        Assert.assertEquals("Alice", result);
    }

    @Test
    public void whenMultipleMessagesHaveSameLength_thenFirstLongestRecipientFound() {
        messages = Arrays.asList(
                new Message(fixedDate, "Bob", "Same length msg"),
                new Message(fixedDate, "Charlie", "Same length msg")
        );
        String result = analyzer.findRecipientOfLongestMessage(messages);
        Assert.assertEquals("Bob", result);
    }

    @Test
    public void whenMultipleEmotionsOccurEqually_thenFirstEmotionFound() {
        messages = Arrays.asList(
                new Message(fixedDate, "Alice", "I am so happy :)"),
                new Message(fixedDate, "Bob", "I am so sad :("),
                new Message(fixedDate, "Charlie", "Wow :O")
        );
        String result = analyzer.findLeastUsedEmotionPastYear(messages);
        Assert.assertEquals(":O", result);
    }

    @Test
    public void whenMessagesContainMultipleEmotions_thenCorrectLeastUsedEmotionFound() {
        messages = Arrays.asList(
                new Message(fixedDate, "Alice", "I am so happy :) Really :)"),
                new Message(fixedDate, "Bob", "Kind of sad here :("),
                new Message(fixedDate, "Charlie", "Surprised :( and happy :)")
        );
        String result = analyzer.findLeastUsedEmotionPastYear(messages);
        Assert.assertEquals(":(", result);
    }

    @Test
    public void whenWordOccursOnMultipleDaysButOutsideOfYearRange_thenNoDayOfWeekFound() {
        messages = Arrays.asList(
                new Message(fixedDate.minusYears(2), "Alice", "Word occurred here."),
                new Message(fixedDate.minusYears(2).minusDays(1), "Bob", "Word occurred there too.")
        );
        DayOfWeek result = analyzer.findDayOfWeekWithMostOccurrencesOfWord(messages, "occurred");
        Assert.assertNull(result);
    }

    @Test
    public void whenMessagesSpanMultipleYears_thenCorrectLeastUsedEmotionFound() {
        messages = Arrays.asList(
                new Message(fixedDate.minusYears(1).minusDays(1), "Alice", "Last year's emotion :("),
                new Message(fixedDate, "Bob", "This year's emotion :D"),
                new Message(fixedDate.minusYears(2), "Charlie", "Old emotion :O")
        );
        String result = analyzer.findLeastUsedEmotionPastYear(messages);
        Assert.assertEquals(":D", result);
    }

}
