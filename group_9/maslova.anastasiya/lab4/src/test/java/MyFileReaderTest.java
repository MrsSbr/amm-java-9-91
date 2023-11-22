import org.example.MyFileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class MyFileReaderTest {

    private static final Path BAD_PATH = Path.of("maslova.anastasiya/lab4/src123/main/resources/orders.txt");

    @Test
    public void testFileIsOpened() {
        // Тест на открытие и чтение файла
        try {
            Path tempFilePath = Files.createTempFile("test-orders", ".txt"); // Создаем временный файл для тестирования
            // Вызываем метод для чтения файла
            MyFileReader.readOrdersFromFile(tempFilePath);
            // Если метод успешно выполнился без исключений, считаем, что файл открыт
            assertTrue(true);
        } catch (IOException e) {
            // Если возникло исключение при открытии файла, тест считается неудачным
            fail("Ошибка при открытии файла: " + e.getMessage());
        }
    }

    @Test
    public void testFileIsOpenedWithBadPath() {
        // Попытка чтения файла с неправильным путем
        assertThrows(RuntimeException.class, () -> MyFileReader.readOrdersFromFile(BAD_PATH));
    }
}
