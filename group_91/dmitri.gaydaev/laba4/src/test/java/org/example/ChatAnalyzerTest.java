package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.DateTimeException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChatAnalyzerTest {

    private ChatAnalyzer chatAnalyzer;

    @BeforeEach
    public void setUp() {
        MessageParser messageParser = new SimpleMessageParser();
        chatAnalyzer = new ChatAnalyzer(messageParser);
    }

    @Test
    public void testAnalyzeChatWithEmptyLines() {
        List<String> emptyLines = Collections.emptyList();
        assertThrows(NullPointerException.class, () -> chatAnalyzer.analyzeChat(emptyLines));
    }

    @Test
    public void testAnalyzeChatWithLongestMessage() {
        List<String> lines = Arrays.asList(
                "01.01.2023 08:00:00;Alice;Hello, Bob!",
                "01.01.2023 08:05:00;Bob;Hi Alice! How are you?",
                "01.01.2023 08:10:00;Alice;I'm good, thanks! What about you?"
        );

        // Set the input stream for scanner to simulate user input
        String input = "word";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        chatAnalyzer.analyzeChat(lines);
    }

    @Test
    public void testAnalyzeChatWithInvalidDate() {
        List<String> lines = Collections.singletonList(
                "InvalidDate;Alice;Hello, Bob!"
        );

        assertThrows(DateTimeException.class, () -> chatAnalyzer.analyzeChat(lines));
    }

    @Test
    public void testAnalyzeChatWithMostFrequentDay() {
        List<String> lines = Arrays.asList(
                "01.01.2023 08:00:00;Alice;Hello, Bob!",
                "01.01.2023 08:05:00;Bob;Hi Alice! How are you?",
                "01.01.2023 08:10:00;Alice;I'm good, thanks! What about you?",
                "02.01.2023 09:30:00;Charlie;Hey everyone! What's up?"
        );

        // Set the input stream for scanner to simulate user input
        String input = "word";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        chatAnalyzer.analyzeChat(lines);
    }

    @Test
    public void testAnalyzeChatWithEmptyEmojiCount() {
        List<String> lines = Collections.singletonList(
                "01.01.2023 08:00:00;Alice;Hello, Bob!"
        );

        // Set the input stream for scanner to simulate user input
        String input = "word";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        chatAnalyzer.analyzeChat(lines);
    }

}
