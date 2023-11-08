package solddrink.utils;

import drinks.SoldDrink;
import org.jetbrains.annotations.NotNull;
import java.util.Collection;
import java.util.function.Supplier;

public class SoldDrinkCollectionUtils {

    public static @NotNull Collection<SoldDrink> fill(@NotNull Collection<SoldDrink> source,
                                                      @NotNull Supplier<Collection<SoldDrink>> collectionSupplier) {
        source.clear();
        source = collectionSupplier.get();
        for (int i = 0; i < 10000; i++) {
            source.add(SoldDrinkFactory.generateSoldDrinkRecord());
        }
        return source;
    }

    public static @NotNull Collection<SoldDrink> wrap(@NotNull Collection<SoldDrink> source,
                                                      @NotNull Supplier<Collection<SoldDrink>> collectionSupplier) {
        Collection<SoldDrink> destination = collectionSupplier.get();
        destination.addAll(source);
        return destination;
    }
}
