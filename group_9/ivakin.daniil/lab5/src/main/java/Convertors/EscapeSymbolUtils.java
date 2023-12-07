package Convertors;

import java.util.HashMap;
import java.util.Map;

public class EscapeSymbolUtils {
    private static final Map<Character, String> escapeCharMap;

    static {
        escapeCharMap = new HashMap<>();
        escapeCharMap.put('\"', "\\\"");
        escapeCharMap.put('\\', "\\\\");
        escapeCharMap.put('/', "\\/");
        escapeCharMap.put('\b', "\\b");
        escapeCharMap.put('\f', "\\f");
        escapeCharMap.put('\n', "\\n");
        escapeCharMap.put('\r', "\\r");
        escapeCharMap.put('\t', "\\t");
    }

    public static String transformWithEscapes(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] chars = str.toCharArray();

        for (char c : chars) {
            if (escapeCharMap.containsKey(c)) {
                strBuilder.append(escapeCharMap.get(c));
            } else {
                strBuilder.append(c);
            }
        }

        return strBuilder.toString();
    }

    public static String transformWithEscapes(char c) {
        if (escapeCharMap.containsKey(c)) {
            return escapeCharMap.get(c);
        } else {
            return String.valueOf(c);
        }
    }

    public static String transformWithEscapes(Character c) {
        if (escapeCharMap.containsKey(c)) {
            return escapeCharMap.get(c);
        } else {
            return c.toString();
        }
    }
}
