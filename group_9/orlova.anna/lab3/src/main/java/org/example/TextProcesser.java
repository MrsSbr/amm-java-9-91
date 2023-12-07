package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextProcesser {
    public static String inputText() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String input = scanner.nextLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст не должен быть пустым или содержать только пробелы.");
        }

        return input;
    }
    public static List<String> parseText() {

        return Arrays.stream(inputText().split("\\s+"))
                .collect(Collectors.toList());
    }
}

