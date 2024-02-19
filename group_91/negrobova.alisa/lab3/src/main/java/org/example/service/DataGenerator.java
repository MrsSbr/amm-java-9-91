package org.example.service;

import  org.example.model.MilkRecord;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.concurrent.atomic.AtomicInteger;

public class DataGenerator {

    private static final Random RANDOM = new Random();
    private static final AtomicInteger COUNTER = new AtomicInteger(0);

    public static Collection<MilkRecord> generate(
            int count,
            Supplier<Collection<MilkRecord>> collectionSupplier
    ) {
        final LocalDate FINISH_DATE = LocalDate.now();
        return Stream.generate(() -> createRecord(FINISH_DATE.minusDays(COUNTER.get())))
                .parallel()
                .limit(count)
                .collect(Collectors.toCollection(collectionSupplier));
    }

    private static MilkRecord createRecord(LocalDate date) {
        MilkRecord record = new MilkRecord();
        int feedCount = RANDOM.nextInt(0, 10 ^ 6);
        int milkCount = RANDOM.nextInt(0, 10 ^ 6);
        record.setDate(date);
        record.setFeedCount(feedCount);
        record.setMilkCount(milkCount);
        COUNTER.set(COUNTER.get() + 1);
        return record;
    }
}
