package org.example;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
public class ChatAnalyzer {

    private final MessageParser messageParser;

    public ChatAnalyzer(MessageParser messageParser) {
        this.messageParser = messageParser;
    }

    public void analyzeChat(List<String> lines) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        Map<String, Long> messageLengthByPerson = lines.stream()
                .map(messageParser::parseMessage)
                .collect(Collectors.groupingBy(Message::getInterlocutor, Collectors.summingLong(Message::getMessageLength)));

        Optional<Map.Entry<String, Long>> longestMessageEntry = messageLengthByPerson.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        longestMessageEntry.ifPresent(entry ->
                System.out.println("Person with the longest message: " + entry.getKey()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String searchWord = scanner.next().toLowerCase();

        Map<DayOfWeek, Long> dayOfWeekCount = lines.stream()
                .map(messageParser::parseMessage)
                .filter(message -> message.getText().toLowerCase().contains(searchWord))
                .collect(Collectors.groupingBy(message -> {
                    try {
                        return LocalDate.parse(message.getDate(), formatter).getDayOfWeek();
                    } catch (DateTimeException e) {
                        e.printStackTrace();
                        return null;
                    }
                }, Collectors.counting()));

        Optional<Map.Entry<DayOfWeek, Long>> mostFrequentDayEntry = dayOfWeekCount.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue));

        mostFrequentDayEntry.ifPresent(entry ->
                System.out.println("The word '" + searchWord + "' occurs most frequently on " + entry.getKey()));

        Map<String, Long> emojiCount = lines.stream()
                .map(messageParser::parseMessage)
                .flatMap(EmojiExtractor::extractEmojis)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Optional<Map.Entry<String, Long>> leastUsedEmojiEntry = emojiCount.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue));

        leastUsedEmojiEntry.ifPresent(entry ->
                System.out.println("The least used emoji: " + entry.getKey()));
    }
}
