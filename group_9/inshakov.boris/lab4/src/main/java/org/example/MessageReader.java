package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MessageReader {

    public List<Message> readMessagesFromFile(String resourcePath) {
        List<Message> messages = new ArrayList<>();
        InputStream is = MessageReader.class.getClassLoader().getResourceAsStream(resourcePath);
        if (is == null) {
            throw new IllegalArgumentException("File not found: " + resourcePath);
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length == 3) {
                        LocalDate date = LocalDate.parse(parts[0]);
                        String interlocutor = parts[1];
                        String messageText = parts[2];
                        messages.add(new Message(date, interlocutor, messageText));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return messages;
    }
}
