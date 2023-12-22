package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleMessageParserTest {

    @Test
    public void testParseMessage() {
        SimpleMessageParser messageParser = new SimpleMessageParser();

        String testLine = "01.01.2023 08:00:00;Alice;Hello, Bob!";
        Message parsedMessage = messageParser.parseMessage(testLine);

        assertNotNull(parsedMessage);
        assertEquals("01.01.2023 08:00:00", parsedMessage.getDate());
        assertEquals("Alice", parsedMessage.getInterlocutor());
        assertEquals("Hello, Bob!", parsedMessage.getText());
    }

    @Test
    public void testParseMessageWithInvalidFormat() {
        SimpleMessageParser messageParser = new SimpleMessageParser();

        // Invalid format: Missing semicolon
        String testLine = "01.01.2023 08:00:00AliceHello, Bob!";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> messageParser.parseMessage(testLine));
    }

}
