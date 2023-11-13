package sortedcontainer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class SortedList<T> implements SortedCollection<T> {

    public static <T> SortedList<T> sortedArrayList(Comparator<T> comparator) {
        return new SortedList<>(ArrayList::new, comparator);
    }

    public static <T> SortedList<T> sortedLinkedList(Comparator<T> comparator) {
        return new SortedList<>(LinkedList::new, comparator);
    }

    private final List<T> data;
    private final Comparator<T> comparator;

    public SortedList(Supplier<List<T>> listSupplier, Comparator<T> comparator) {
        data = listSupplier.get();
        this.comparator = comparator;
    }

    public void add(T item) {
        var first = data.listIterator();
        var second = data.listIterator();
        while (second.hasNext() && comparator.compare(item, second.next()) > 0) {
            first.next();
        }
        first.add(item);
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public Collection<T> getUnmodifiableView() {
        return Collections.unmodifiableList(data);
    }

}
