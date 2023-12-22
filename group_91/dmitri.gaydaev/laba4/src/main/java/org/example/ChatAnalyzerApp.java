package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class ChatAnalyzerApp {

    public static void main(String[] args) {
        // Replace "file_path" with the actual file path
        Path filePath = Path.of("/Users/gaydaev/IdeaProjects/amm-java-9-91/group_91/dmitri.gaydaev/laba4/src/main/java/org/example/massage.txt");

        try {
            List<String> lines = FileHelper.readAllLines(filePath);
            ChatAnalyzer chatAnalyzer = new ChatAnalyzer(new SimpleMessageParser());
            chatAnalyzer.analyzeChat(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}