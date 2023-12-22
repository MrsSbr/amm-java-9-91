package org.example;

public class SimpleMessageParser implements MessageParser {
    @Override
    public Message parseMessage(String line) {
        String[] parts = line.split(";");
        return new Message(parts[0], parts[1], parts[2]);
    }
}
