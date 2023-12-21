package org.example;

public class Napkin {
    private final StringBuffer poem = new StringBuffer();

    public String getPoem() {
        return poem.toString();
    }

    public void addLine(String line) {
        poem.append(line);
    }
}
