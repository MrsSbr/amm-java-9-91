package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MessageAnalyzer {
    private static final List<String> EMOTION_KEYWORDS = Arrays.asList(
            "xd", ":p", ":)", ":(", ":D", ":'(", ":O"
    );

    public String findRecipientOfLongestMessage(List<Message> messages) {
        return messages.stream()
                .max(Comparator.comparingInt(m -> m.getMessageText().length()))
                .map(Message::getInterlocutor)
                .orElse("No messages found");
    }

    public DayOfWeek findDayOfWeekWithMostOccurrencesOfWord(List<Message> messages, String word) {
        return messages.stream()
                .filter(m -> m.getDate().isAfter(LocalDate.now().minus(1, ChronoUnit.YEARS)))
                .collect(Collectors.groupingBy(
                        m -> m.getDate().getDayOfWeek(),
                        Collectors.summingInt(m -> countOccurrences(m.getMessageText(), word))
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public String findLeastUsedEmotionPastYear(List<Message> messages) {
        LocalDate oneYearAgo = LocalDate.now().minus(1, ChronoUnit.YEARS);
        Map<String, Long> emotionFrequency = messages.stream()
                .filter(message -> message.getDate().isAfter(oneYearAgo))
                .flatMap(message -> extractEmotions(message.getMessageText()).stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return emotionFrequency.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No emotions found");
    }

    private int countOccurrences(String text, String word) {
        Pattern wordPattern = Pattern.compile("\\b" + Pattern.quote(word) + "\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = wordPattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    private List<String> extractEmotions(String messageText) {
        List<String> foundEmotions = new ArrayList<>();
        for (String emotion : EMOTION_KEYWORDS) {
            if (messageText.contains(emotion)) {
                foundEmotions.add(emotion);
            }
        }
        return foundEmotions;
    }
}
