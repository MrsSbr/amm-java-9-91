package main.java.org.example;

public enum TeaType {
    FUXI_HUANGSHAN_MAOFENG("Фуси Мао Фэн"),
    QIMEN_HUANGSHAN_MAOFENG("Цимэнь Мао Фэн"),
    YUAN_GUAPIAN("Люань Гуапянь"),
    TAIPING_HOUKUI("Тайпин Хоукуй");
    private final String title;

    TeaType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
