import drinks.DrinkType;
import drinks.SoldDrink;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import solddrink.utils.SoldDrinkCollectionUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class SoldDrinkCollectionUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    void testFillWithNullAndEmptySource(Collection<SoldDrink> source) {
        Supplier<Collection<SoldDrink>> collectionSupplier = ArrayList::new;

        if (source == null) {
            Assertions.assertThatThrownBy(() -> SoldDrinkCollectionUtils.fill(source, collectionSupplier)).isInstanceOf(IllegalArgumentException.class);
        } else {
            Collection<SoldDrink> filled = SoldDrinkCollectionUtils.fill(source, collectionSupplier);
            Assertions.assertThat(filled.size()).isEqualTo(10000);
        }
    }

    @ParameterizedTest
    @NullAndEmptySource
    void testWrapWithNullAndEmptySource(Collection<SoldDrink> source) {
        Supplier<Collection<SoldDrink>> collectionSupplier = ArrayList::new;

        if (source == null) {
            Assertions.assertThatThrownBy(() -> SoldDrinkCollectionUtils.wrap(source, collectionSupplier)).isInstanceOf(IllegalArgumentException.class);
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

        wrapped = SoldDrinkCollectionUtils.wrap(source, HashSet::new);
        Assertions.assertThat(wrapped).isInstanceOf(HashSet.class);
    }

    @Test
    void testFillWithSource() {
        List<SoldDrink> source = new ArrayList<>() {{
            add(new SoldDrink(DrinkType.FRAPPE, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
        }};
        Collection<SoldDrink> filled = SoldDrinkCollectionUtils.fill(source, LinkedList::new);
        Assertions.assertThat(filled.size()).isEqualTo(10000);
        Assertions.assertThat(filled).isInstanceOf(LinkedList.class);

        filled = SoldDrinkCollectionUtils.fill(source, HashSet::new);
        Assertions.assertThat(filled).isInstanceOf(HashSet.class);
    }
}
