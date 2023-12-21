package org.example;

public class StudentRecord {
    private String name;
    private TortureTool tortureTool;
    private int duration; // время в минутах
    private boolean isResit; // был ли отправлен на пересдачу

    // Конструктор по умолчанию
    public StudentRecord() {
    }

    // Конструктор со всеми параметрами
    public StudentRecord(String name, TortureTool tortureTool, int duration, boolean isResit) {
        this.name = name;
        this.tortureTool = tortureTool;
        this.duration = duration;
        this.isResit = isResit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TortureTool getTortureTool() {
        return tortureTool;
    }

    public void setTortureTool(TortureTool tortureTool) {
        this.tortureTool = tortureTool;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isResit() {
        return isResit;
    }

    public void setResit(boolean isResit) {
        this.isResit = isResit;
    }

    @Override
    public String toString() {
        return "StudentRecord{" +
                "name='" + name + '\'' +
                ", tortureTool='" + tortureTool + '\'' +
                ", duration=" + duration +
                ", isResit=" + isResit +
                '}';
    }
}


