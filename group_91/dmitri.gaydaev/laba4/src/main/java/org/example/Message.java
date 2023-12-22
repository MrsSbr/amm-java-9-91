package org.example;

public class Message {
    private final String date;
    private final String interlocutor;
    private final String text;

    public Message(String date, String interlocutor, String text) {
        this.date = date;
        this.interlocutor = interlocutor;
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public String getInterlocutor() {
        return interlocutor;
    }

    public String getText() {
        return text;
    }

    public long getMessageLength() {
        return text.length();
    }
}