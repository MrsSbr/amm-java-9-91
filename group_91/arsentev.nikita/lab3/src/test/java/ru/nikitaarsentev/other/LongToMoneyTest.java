package ru.nikitaarsentev.other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongToMoneyTest {
    @Test
    void transformationLongToMoneyWithPositiveValue() {
        long money = 123456;
        String expected = "123 456,00 ₽";
        assertEquals(expected, LongToMoney.transformationLongToMoney(money));
    }

    @Test
    void transformationLongToMoneyWithNegativeValue() {
        long money = -123456;
        String expected = "-123 456,00 ₽";
        assertEquals(expected, LongToMoney.transformationLongToMoney(money));
    }

    @Test
    void transformationLongToMoneyWithZero() {
        long money = 0;
        String expected = "0,00 ₽";
        assertEquals(expected, LongToMoney.transformationLongToMoney(money));
    }

    @Test
    void transformationLongToMoneyWithLargeValue() {
        long money = 123456789012345L;
        String expected = "123 456 789 012 345,00 ₽";
        assertEquals(expected, LongToMoney.transformationLongToMoney(money));
    }

}