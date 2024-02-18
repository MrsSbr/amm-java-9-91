package org.example;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class RandomRecordsFactory {
    private final RandomRecord factory = new RandomRecord();
    private final int count;

    public RandomRecordsFactory(int count) {
        this.count = count;
    }

    public Collection<CourtCase> getRecords(Supplier<Collection<CourtCase>> collectionSupplier) {
        return Stream.generate(factory::getRecording)
                .limit(count)
                .collect(collectionSupplier, Collection<CourtCase>::add, Collection<CourtCase>::addAll);
    }
}
