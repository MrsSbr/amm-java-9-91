package sortedcontainer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SortedContainerTest {

    Random rng = new Random();

    static Stream<SortedCollection<Integer>> implementationsShouldKeepElementsSorted() {
        return Stream.of(
                new TreeSetWrapper<Integer>(Comparator.naturalOrder()),
                SortedList.<Integer>sortedArrayList(Comparator.naturalOrder()),
                SortedList.<Integer>sortedLinkedList(Comparator.naturalOrder())
        );
    }

    @ParameterizedTest
    @MethodSource
    void implementationsShouldKeepElementsSorted(SortedCollection<Integer> collection) {
        for (int i = 0; i < 1000; ++i) {
            collection.add(rng.nextInt());
        }
        assertThat(collection.getUnmodifiableView().toArray(Integer[]::new))
                .isSortedAccordingTo(Comparator.naturalOrder());
    }

}
