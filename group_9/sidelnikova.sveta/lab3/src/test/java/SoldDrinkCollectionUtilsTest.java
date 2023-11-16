import drinks.DrinkType;
import drinks.SoldDrink;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import solddrink.utils.SoldDrinkCollectionUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Supplier;

public class SoldDrinkCollectionUtilsTest {

    @Test
    void testFillWithUnPositiveSize() {
        Supplier<Collection<SoldDrink>> collectionSupplier = ArrayList::new;

        Collection<SoldDrink> filled = SoldDrinkCollectionUtils.fill(collectionSupplier, -1);
        Assertions.assertThat(filled).isEqualTo(new ArrayList<>());

        filled = SoldDrinkCollectionUtils.fill(collectionSupplier, 0);
        Assertions.assertThat(filled).isEqualTo(new ArrayList<>());
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testWrapWithNullAndEmptySource(Collection<SoldDrink> source) {
        Supplier<Collection<SoldDrink>> collectionSupplier = ArrayList::new;

        if (source == null) {
            Assertions.assertThatThrownBy(() -> SoldDrinkCollectionUtils.wrap(source, collectionSupplier))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            Collection<SoldDrink> wrapped = SoldDrinkCollectionUtils.wrap(source, collectionSupplier);
            Assertions.assertThat(wrapped).isEqualTo(new ArrayList<>());
        }
    }

    @Test
    void testWrapWithSource() {
        List<SoldDrink> source = new ArrayList<>() {{
            add(new SoldDrink(DrinkType.FRAPPE, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
        }};
        Collection<SoldDrink> wrapped = SoldDrinkCollectionUtils.wrap(source, LinkedList::new);
        Assertions.assertThat(wrapped).isInstanceOf(LinkedList.class);
        Assertions.assertThat(wrapped.size()).isEqualTo(1);

        wrapped = SoldDrinkCollectionUtils.wrap(source, HashSet::new);
        Assertions.assertThat(wrapped).isInstanceOf(HashSet.class);
    }

    @Test
    void testFillWithSource() {
        Collection<SoldDrink> filled = SoldDrinkCollectionUtils.fill(LinkedList::new, 10000);
        Assertions.assertThat(filled.size()).isEqualTo(10000);
        Assertions.assertThat(filled).isInstanceOf(LinkedList.class);

        filled = SoldDrinkCollectionUtils.fill(HashSet::new, 10000);
        Assertions.assertThat(filled).isInstanceOf(HashSet.class);
    }
}
