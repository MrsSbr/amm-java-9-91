import drinks.DrinkType;
import drinks.SoldDrink;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.CollectionPerformanceAnalyzer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class CollectionPerformanceAnalyzerTest {
    @Test
    void collectionPerformanceAnalyzerShouldCreateWithSource() {
        List<SoldDrink> source = new ArrayList<>() {{
            add(new SoldDrink(DrinkType.FRAPPE, LocalDate.of(2022, 1, 1),
                    LocalTime.of(10, 0, 0)));
        }};
        CollectionPerformanceAnalyzer analyzer = new CollectionPerformanceAnalyzer(new LinkedList<>(),
                source);
        Assertions.assertThat(analyzer.getCollection()).isInstanceOf(LinkedList.class);
        Assertions.assertThat(analyzer.getCollection().size()).isEqualTo(1);

        analyzer = new CollectionPerformanceAnalyzer(new HashSet<>(),
                source);
        Assertions.assertThat(analyzer.getCollection()).isInstanceOf(HashSet.class);
        Assertions.assertThat(analyzer.getCollection().size()).isEqualTo(1);
    }

    @Test
    void collectionPerformanceAnalyzerShouldGenerate() {
        CollectionPerformanceAnalyzer analyzer = new CollectionPerformanceAnalyzer(new LinkedList<>());
        Assertions.assertThat(analyzer.getCollection()).isInstanceOf(LinkedList.class);
        Assertions.assertThat(analyzer.getCollection().size()).isEqualTo(10000);

        analyzer = new CollectionPerformanceAnalyzer(new ArrayList<>());
        Assertions.assertThat(analyzer.getCollection()).isInstanceOf(ArrayList.class);
        Assertions.assertThat(analyzer.getCollection().size()).isEqualTo(10000);
    }
}
