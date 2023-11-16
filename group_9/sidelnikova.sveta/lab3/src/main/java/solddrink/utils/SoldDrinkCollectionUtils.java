package solddrink.utils;

import drinks.SoldDrink;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldDrinkCollectionUtils {

    public static @NotNull Collection<SoldDrink> fill(@NotNull Supplier<Collection<SoldDrink>> collectionSupplier,
                                                      int size) {
        if (size < 0)
            return collectionSupplier.get();
        return Stream.generate(SoldDrinkFactory::generateSoldDrinkRecord)
                .limit(size)
                .collect(Collectors.toCollection(collectionSupplier));
    }

    public static @NotNull Collection<SoldDrink> wrap(@NotNull Collection<SoldDrink> source,
                                                      @NotNull Supplier<Collection<SoldDrink>> collectionSupplier) {
        return source.stream()
                .collect(Collectors.toCollection(collectionSupplier));
    }
}
