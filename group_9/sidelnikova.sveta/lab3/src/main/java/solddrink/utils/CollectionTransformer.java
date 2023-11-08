package solddrink.utils;

import java.util.Collection;
import java.util.function.Supplier;

public interface CollectionTransformer<T> {
    Collection<T> transform(Collection<T> source, Supplier<Collection<T>> collectionSupplier);
}

