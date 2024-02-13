package ru.nikitaarsentev.other;

import java.text.NumberFormat;
import java.util.Locale;

public class LongToMoney {
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("ru-RU"));

    public static String transformationLongToMoney(long money) {
        return NUMBER_FORMAT.format(money);
    }
}
