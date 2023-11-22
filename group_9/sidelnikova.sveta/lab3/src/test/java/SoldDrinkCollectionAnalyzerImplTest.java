import drinks.DrinkType;
import drinks.SoldDrink;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import tasks.SoldDrinkCollectionAnalyzerImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class SoldDrinkCollectionAnalyzerImplTest {

    private static SoldDrinkCollectionAnalyzerImpl soldDrinkCollectionAnalyzer;

    @BeforeAll
    static void setUp() {
        soldDrinkCollectionAnalyzer = new SoldDrinkCollectionAnalyzerImpl();
    }

    @Test
    public void testGetMorningDrinks() {
        List<SoldDrink> testCollection = new ArrayList<>() {{
            add(new SoldDrink(DrinkType.FRAPPE, LocalDate.of(2022, 1, 1),
                    LocalTime.of(7, 58, 14)));
            add(new SoldDrink(DrinkType.FRAPPE, LocalDate.of(2022, 1, 1),
                    LocalTime.of(16, 58, 14)));
            add(new SoldDrink(DrinkType.CAPPUCCINO, LocalDate.of(2022, 1, 1),
                    LocalTime.of(18, 58, 14)));
            add(new SoldDrink(DrinkType.ESPRESSO, LocalDate.of(2022, 1, 1),
                    LocalTime.of(9, 0, 0)));
        }};
        Set<DrinkType> result = soldDrinkCollectionAnalyzer.getMorningDrinks(testCollection);
        Assertions.assertThat(result).isEqualTo(new HashSet<>() {{
            add(DrinkType.FRAPPE);
            add(DrinkType.ESPRESSO);
        }});
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testGetMorningDrinksWithEmptyCollection(Collection<SoldDrink> testCollection) {
        if (testCollection == null) {
            Assertions.assertThatThrownBy(() -> soldDrinkCollectionAnalyzer.getMorningDrinks(testCollection))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            Set<DrinkType> result = soldDrinkCollectionAnalyzer.getMorningDrinks(testCollection);
            Assertions.assertThat(result).isEmpty();
        }
    }

    @Test
    public void testGetNotOrderedDrinksLastThreeMonths() {
        List<SoldDrink> testCollection = new ArrayList<>() {{
            add(new SoldDrink(DrinkType.FRAPPE, LocalDate.from(LocalDate.now().minusMonths(3)),
                    LocalTime.of(10, 0, 0)));
            add(new SoldDrink(DrinkType.FRAPPE, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
            add(new SoldDrink(DrinkType.CAPPUCCINO, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
            add(new SoldDrink(DrinkType.ESPRESSO, LocalDate.from(LocalDate.now().minusDays(3)),
                    LocalTime.of(10, 0, 0)));
        }};
        Set<DrinkType> result = soldDrinkCollectionAnalyzer.getNotOrderedDrinksLastThreeMonths(testCollection);
        Assertions.assertThat(result).isEqualTo(new HashSet<>() {{
            add(DrinkType.CAPPUCCINO);
            add(DrinkType.RAF);
            add(DrinkType.GLASSE);
            add(DrinkType.LATTE);
        }});
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testGetNotOrderedDrinksLastThreeMonthsWithEmptyCollection(Collection<SoldDrink> testCollection) {
        if (testCollection == null) {
            Assertions.assertThatThrownBy(() -> soldDrinkCollectionAnalyzer.getNotOrderedDrinksLastThreeMonths(testCollection))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            Set<DrinkType> result = soldDrinkCollectionAnalyzer.getNotOrderedDrinksLastThreeMonths(testCollection);
            Assertions.assertThat(result).isEqualTo(new HashSet<>(Set.of(DrinkType.values())));
        }
    }

    @Test
    public void testGetCappuccinoOrdersCount() {
        List<SoldDrink> testCollection = new ArrayList<>() {{
            add(new SoldDrink(DrinkType.FRAPPE, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
            add(new SoldDrink(DrinkType.CAPPUCCINO, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
            add(new SoldDrink(DrinkType.CAPPUCCINO, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
            add(new SoldDrink(DrinkType.ESPRESSO, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
            add(new SoldDrink(DrinkType.CAPPUCCINO, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
        }};
        int result = soldDrinkCollectionAnalyzer.getCappuccinoOrdersCount(testCollection);
        Assertions.assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testGetCappuccinoOrdersCountWithEmptyCollection(Collection<SoldDrink> testCollection) {
        if (testCollection == null) {
            Assertions.assertThatThrownBy(() -> soldDrinkCollectionAnalyzer.getCappuccinoOrdersCount(testCollection))
                    .isInstanceOf(IllegalArgumentException.class);
        } else {
            int result = soldDrinkCollectionAnalyzer.getCappuccinoOrdersCount(testCollection);
            Assertions.assertThat(result).isEqualTo(0);
        }
    }

}
