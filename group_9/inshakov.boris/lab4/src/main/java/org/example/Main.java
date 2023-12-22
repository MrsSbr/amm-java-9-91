package org.example;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final MessageAnalyzer analyzer = new MessageAnalyzer();
    private static final MessageReader reader = new MessageReader();
    public static void main(String[] args) {
        logger.info("Application started.");

        String filePath = "message.txt";
        List<Message> messages = reader.readMessagesFromFile(filePath);
        String longestMessageRecipient = analyzer.findRecipientOfLongestMessage(messages);
        logger.info("The recipient of the longest message is: " + longestMessageRecipient);
        System.out.println("Получатель самого длинного сообщения: " + longestMessageRecipient);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите слово для поиска: ");
        String word = scanner.nextLine();
        DayOfWeek mostFrequentWordDay = analyzer.findDayOfWeekWithMostOccurrencesOfWord(messages, word);
        logger.info("The day of the week with the most occurrences of the word '" + word + "' is: " + mostFrequentWordDay);
        System.out.println("День недели с наибольшим числом вхождений слова '" + word + "': " + mostFrequentWordDay);

        String leastUsedEmotion = analyzer.findLeastUsedEmotionPastYear(messages);
        logger.info("The least used emotion over the past year is: " + leastUsedEmotion);
        System.out.println("Наименее употребимая эмоция за последний год: " + leastUsedEmotion);

        scanner.close();
        logger.info("Application finished.");
    }
}
