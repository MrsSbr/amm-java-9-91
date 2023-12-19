package org.example;

public class StudentRecordParser {

    public static StudentRecord parseFromString(String line) throws IllegalArgumentException {
        String[] parts = line.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Некорректный формат строки: " + line);
        }
        try {
            String name = parts[0].trim();
            TortureTool tool = TortureTool.fromString(parts[1].trim());
            int duration = Integer.parseInt(parts[2].trim());
            boolean isResit = Boolean.parseBoolean(parts[3].trim());
            return new StudentRecord(name, tool, duration, isResit);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка при обработке числовых значений в строке: " + line);
        }
    }
}

