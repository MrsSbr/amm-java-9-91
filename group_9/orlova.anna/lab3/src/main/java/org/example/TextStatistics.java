package org.example;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TextStatistics {
    private final Collection<String> text;

    public TextStatistics(Supplier<Collection<String>> supplier, List<String> storage) {
        text = supplier.get();
        text.addAll(storage);
    }

    // список уникальных слов в тексте
    public List<String> getUniqueWords() {
        return text.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    // список самых длинных слов с частотой их использования
    public Map<String, Long> getMostFrequentWords() {
        return text.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    // количество слов, которые содержат слово, введенное пользователем
    public long countWordsContaining(String query) {
        return text.stream()
                .filter(word -> word.contains(query))
                .count();
    }
}
