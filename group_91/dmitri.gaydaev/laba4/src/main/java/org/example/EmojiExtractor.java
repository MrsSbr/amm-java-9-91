package org.example;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

 class EmojiExtractor {
    public static Stream<String> extractEmojis(Message message) {
        Matcher matcher = Pattern.compile("[\\uD83C-\\uDBFF\\uDC00-\\uDFFF]+").matcher(message.getText());
        return matcher.results().map(MatchResult::group);
    }
}

