package ru.nikitaarsentev.factories;

import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class DayFactory {
    public static <T extends Collection<LocalDate>>
    T generateDays(Supplier<T> factory, LocalDate startDate, int durability) {
        return IntStream.range(0, durability)
                .mapToObj(startDate::plusDays)
                .collect(factory, Collection::add, Collection::addAll);
    }
}
