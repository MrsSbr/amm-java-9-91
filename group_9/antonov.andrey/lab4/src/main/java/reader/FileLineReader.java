package reader;

import java.nio.file.Path;
import java.util.List;
import parser.Parser;

public interface FileLineReader<T> {
    /**
     * @param path   Путь к файлу
     * @param parser Реализация интерфейса, осуществляющая парсинг каждой строки файла
     * @return Cписок cконструированных объектов типа T, полученных с помощью parser
     */
    List<T> readAllLines(Path path, Parser<T> parser);
}
