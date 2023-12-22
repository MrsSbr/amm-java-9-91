package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmojiExtractorTest {

    @Test
    public void testExtractEmojis() {
        Message testMessage = new Message("01.01.2023 08:00:00", "Alice", "Hello, 😊 Bob! 🌟");

        List<String> extractedEmojis = EmojiExtractor.extractEmojis(testMessage)
                .collect(Collectors.toList());

        assertEquals(2, extractedEmojis.size());
        assertEquals("😊", extractedEmojis.get(0));
        assertEquals("🌟", extractedEmojis.get(1));
    }

    @Test
    public void testExtractEmojisWithNoEmojis() {
        Message testMessage = new Message("01.01.2023 08:00:00", "Alice", "Hello, Bob!");

        List<String> extractedEmojis = EmojiExtractor.extractEmojis(testMessage)
                .collect(Collectors.toList());

        assertEquals(0, extractedEmojis.size());
    }

}
