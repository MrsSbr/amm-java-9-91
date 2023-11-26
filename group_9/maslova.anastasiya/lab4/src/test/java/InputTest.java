import org.example.Input;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputTest {
    // Дополнительные тесты
    @Test
    void testGetIntWithValidInput() {
        String data = "5\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        assertEquals(5, Input.getInt());
    }

    @Test
    void testGetIntWithInvalidInput() {
        String data = "invalid\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        assertThrows(NoSuchElementException.class, Input::getInt);
    }

    @Test
    void testGetIntWithInvalidInputThenValidInput() {
        String data = "invalid\n10\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        assertEquals(10, Input.getInt());
    }

    @Test
    void testGetIntInRangeWithValidInput() {
        String data = "5\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        assertEquals(5, Input.getIntInRange(1, 10));
    }

    @Test
    void testGetIntInRangeWithInvalidInput() {
        String data = "15\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        assertThrows(NoSuchElementException.class, () -> Input.getIntInRange(1, 10));
    }
}