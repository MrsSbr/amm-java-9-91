package org.example;

public class Napkin {
    private final StringBuilder poem = new StringBuilder();

    public String getPoem() {
        return poem.toString();
    }

    public void addLine(String line) {
        poem.append(line);
    }
}
