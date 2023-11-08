package drinks;

import solddrink.utils.CollectionTransformer;
import java.util.Collection;
import java.util.function.Supplier;


public class SoldDrinkCollection {
    private final Collection<SoldDrink> collection;

    public SoldDrinkCollection(Collection<SoldDrink> collection, CollectionTransformer<SoldDrink> transformer,
                               Supplier<Collection<SoldDrink>> mapperCollection) {
        collection = transformer.transform(collection, mapperCollection);
        this.collection = collection;
    }

    public Collection<SoldDrink> getCollection() {
        return collection;
    }
}
