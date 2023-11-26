import org.example.MyFileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyFileReaderTest {

    private static final Path BAD_PATH = Path.of("maslova.anastasiya/lab4/src123/main/resources/orders.txt");
    private final MyFileReader myFileReader = new MyFileReader();

    @Test
    public void testFileIsOpened() throws IOException {
        // Тест на открытие и чтение файла
        Path tempFilePath = Files.createTempFile("test-orders", ".txt"); // Создаем временный файл для тестирования

        // Вызываем метод для чтения файла
        assertDoesNotThrow(() -> myFileReader.readOrdersFromFile(tempFilePath));
    }

    @Test
    public void testFileIsOpenedWithBadPath() {
        // Попытка чтения файла с неправильным путем
        assertThrows(RuntimeException.class, () -> myFileReader.readOrdersFromFile(BAD_PATH));
    }
}
