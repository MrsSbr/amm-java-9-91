package org.example;

public enum ShowName {

    SWAN_LAKE("Лебединое озеро"),
    ROMEO_AND_JULIET("Ромео и Джульетта"),
    HAMLET("Гамлет"),
    MIDSUMMER_NIGHTS_DREAM("Сон в летнюю ночь"),
    NUTCRACKER("Щелкунчик"),
    CARMEN("Кармен"),
    FAUST("Фауст"),
    WAR_AND_PEACE("Война и мир"),
    THE_MASTER_AND_MARGARITA("Мастер и Маргарита"),
    ANNA_KARENINA("Анна Каренина");
    private final String showTitle;

    ShowName(String showTitle) {
        this.showTitle = showTitle;
    }

    public String getShowTitle() {
        return showTitle;
    }
}