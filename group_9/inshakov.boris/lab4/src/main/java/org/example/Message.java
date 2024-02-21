package org.example;

import java.time.LocalDate;

public class Message {
    private LocalDate date;
    private String interlocutor;
    private String messageText;

    public Message(LocalDate date, String interlocutor, String messageText) {
        this.date = date;
        this.interlocutor = interlocutor;
        this.messageText = messageText;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getInterlocutor() {
        return interlocutor;
    }

    public void setInterlocutor(String interlocutor) {
        this.interlocutor = interlocutor;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "Message{" +
                "date=" + date +
                ", interlocutor='" + interlocutor + '\'' +
                ", messageText='" + messageText + '\'' +
                '}';
    }

    public static Message of(int year, int month, int day, String interlocutor, String messageText) {
        return new Message(LocalDate.of(year, month, day), interlocutor, messageText);
    }
}
