package parser;


public interface Parser<T> {
    /**
     * @param line Строка, подлежащая парсингу
     * @return Объект типа T, сконструированный на основе строки
     */
    T parseLine(String line);
}
