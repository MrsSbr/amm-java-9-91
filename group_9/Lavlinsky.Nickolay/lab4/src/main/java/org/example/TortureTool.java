package org.example;

public enum TortureTool {
    JAVA_CODE_CONVENTION("джава код конвеншен"),
    GITHUB_BUG("баг в гит хабе"),
    BAD_WEATHER("погода не очень"),
    CODE_ERROR("ошибка в коде"),
    TOUGH_QUESTION("сложный вопрос");

    private final String displayName;

    TortureTool(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // Метод для получения enum по строковому представлению
    public static TortureTool fromString(String text) {
        for (TortureTool tool : TortureTool.values()) {
            if (tool.displayName.equalsIgnoreCase(text)) {
                return tool;
            }
        }
        throw new IllegalArgumentException("Нет инструмента пыток с названием: " + text);
    }
}

