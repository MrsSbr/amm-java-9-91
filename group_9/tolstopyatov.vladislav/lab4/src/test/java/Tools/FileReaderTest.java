package Tools;

import GameResources.Estimation;
import GameResources.Game;
import GameResources.Genre;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileReaderTest {
    private static final Path wrongPath = Path.of("blablabla");
    private static final Path badInfoPath = Path.of("src/main/java/Resources/badInfo.txt");
    private static final Path goodInfoPath = Path.of("src/main/java/Resources/goodInfo.txt");
    private static final List<Game> game = List.of(
            new Game("Сталкер:Тень Чернобыля", Genre.RPG,
                    LocalDate.of(2022, 01, 01), 130,
                    Estimation.EXCELLENT)
    );

    private static final FileReader fileReader = new FileReader();

    @Test
    void tryReadFileWithNotValidPath() {
        assertThrows(NoSuchFileException.class, () -> {
            fileReader.readGamesFromFile(wrongPath);
        });
    }

    @Test
    void tryReadBadInfoFromFile() {
        assertThrows(RuntimeException.class, () -> {
            fileReader.readGamesFromFile(badInfoPath);
        });
    }

    @Test
    void tryReadGoodFromFile() throws IOException {
        List<Game> oneGame = fileReader.readGamesFromFile(goodInfoPath);
        assertIterableEquals(oneGame, game);
    }
}
