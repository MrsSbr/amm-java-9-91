package Tools;

import GameResources.Estimation;
import GameResources.Game;
import GameResources.Genre;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    private static final Logger logger = Logger.getLogger(FileReader.class.getName());

    public List<Game> readGamesFromFile(Path path) throws IOException {
        logger.info("Запуск процесса считывания данных");

        CheckValidFields checkValid = new CheckValidFields();
        List<Game> result;

        try (Stream<String> fileStream = Files.lines(path)) {
            result = fileStream.map(line -> line.
                            split(";")).
                    map(struct -> {

                        String title = struct[0];
                        checkValid.checkValidTitle(title);

                        Genre genre = Genre.valueOf(struct[1]);
                        checkValid.checkValidGenre(genre.getValue());

                        LocalDate dateOfCompletion = LocalDate.parse(struct[2]);
                        checkValid.checkValidDateOfCompletion(dateOfCompletion);

                        Integer gameTimeInHours = Integer.parseInt(struct[3]);
                        checkValid.checkGameTimeInHours(gameTimeInHours);

                        Estimation estimation = Estimation.valueOf(struct[4]);
                        checkValid.checkValidEstimation(estimation.getValue());

                        return new Game(title, genre, dateOfCompletion, gameTimeInHours, estimation);

                    }).collect(Collectors.toList());

        } catch (NoSuchFileException exception) {
            logger.severe("Ошибка при чтении файла! \n" + exception.getMessage());
            throw new NoSuchFileException(path.toString());
        } catch (Exception exception) {
            logger.severe("Ошибка при чтении файла! \n" + exception.getMessage());
            throw new RuntimeException();
        }
        logger.info("Информация об игровой деятельности Иннкентия успешно считана!");
        return result;
    }
}
